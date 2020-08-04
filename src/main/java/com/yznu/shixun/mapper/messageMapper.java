package com.yznu.shixun.mapper;

import com.yznu.shixun.domain.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface messageMapper {
    @Insert("INSERT INTO message ( message_name,emp_id,message_content,message_time) VALUES   (#{message_name},#{emp_id},#{message_content},now())")
    int sendmessage(@Param("message_name") String message_name, @Param("message_content") String message_content, @Param("emp_id") int emp_id);//发送新消息
    //将信息的字段插入信息表
    @Select("select message_id from message order by message_id DESC limit 1")
    int findmess();
    @Select("select id from message_read order by id DESC limit 1")
    int findmess_read();//找到最后一条消息
    @Insert("INSERT INTO message_read (message_id) VALUES (#{message_id})")
    int messageread(@Param("message_id") int message_id);//信息状态表插入一条message_id
@Select("SELECT *,( SELECT count(*) FROM message_read WHERE t.message_id =message_read.message_id AND message_read.emp_id=#{emp_id}) AS readStatus FROM message t where t.message_id not in (select message_id from message_read where emp_id=#{emp_id} and delete_flag=1) AND t.emp_id<>#{emp_id}")
    List<Message> Recvmessage(int emp_id);//查找到所有未删除信息
    @Insert("insert ignore into message_read (emp_id,message_id) VALUES (#{emp_id},#{message_id})")
   int messageflag(int emp_id, @Param("message_id") int message_id);//新增一条信息标记，
    @Update("update message_read set delete_flag='1'  where message_id=#{message_id} and emp_id=#{emp_id}" )
    int delete(int emp_id, @Param("message_id") int message_id);//将信息标记message_read的未删除状态修改
    @Update("update message_read set read_flag='1'  where emp_id=#{emp_id} and message_id=#{message_id}" )
    int read(int message_id, int emp_id);////将信息标记message_read的未读状态修改
    @Select("SELECT\n" +
            "message.message_name,\n" +
            "message.message_id,\n" +
            "message.message_time,\n" +
            "message.message_content,\n" +
            "message_read.message_id\n" +
            "FROM\n" +
            "message\n" +
            "RIGHT OUTER JOIN message_read ON message.message_id = message.message_id\n" +
            "WHERE\n" +
            "message.emp_id = #{emp_id} AND\n" +
            "message_read.delete_flag = 0 AND\n" +
            "message_read.read_flag = 1\n")
    List<Message> Recvedmessage(int emp_id);//已读信息显示
    @Select("SELECT t.* FROM message t LEFT JOIN message_read r on t.message_id = r.message_id where r.delete_flag = 1 and r.emp_id = #{emp_id}")
    List<Message> rubmessage(int emp_id);//查出已删除的信息
}
