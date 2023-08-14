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
public class Video implements Serializable {
    private String id;
    private String weddingId;
    private String videoTypeId;
    private String path;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}