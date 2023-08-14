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
public class Wedding implements Serializable {
    private String id;
    private String title;
    private String cityId;
    private String typeId;
    private String ministerId;
    private String bridegroom;
    private String bride;
    private String contact;
    private String contactTel;
    private String hotel;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}