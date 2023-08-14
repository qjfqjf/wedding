package cn.wedding.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WedInfo implements Serializable {
    private Integer id;
    private String infoType;
    private String imageId;
    private String title;
    private String author;
    private String descr;
    private String imagePath;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}
