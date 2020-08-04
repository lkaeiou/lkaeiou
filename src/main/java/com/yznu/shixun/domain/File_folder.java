package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 名片夹
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class File_folder {
    private Integer folder_id;//文件夹序号
    private String folder_name;//文件夹名字
    private String folder_type;//文件夹类别
}
