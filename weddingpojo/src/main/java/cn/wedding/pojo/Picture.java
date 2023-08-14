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
public class Picture implements Serializable {
    private String id;
    private String weddingId;
    private String picTypeId;
    private String imageId;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}