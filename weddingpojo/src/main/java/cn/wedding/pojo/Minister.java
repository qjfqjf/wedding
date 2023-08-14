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
public class Minister implements Serializable {
    private Integer id;
    private String name;
    private String title;
    private String desc;
    private Integer jigouId;
    private String tel;
    private String qq;
    private String email;
    private Integer cityId;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}