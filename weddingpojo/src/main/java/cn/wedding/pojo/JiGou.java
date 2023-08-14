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
public class JiGou implements Serializable {
    private Integer id;
    private String title;
    private String contact;
    private String contactTel;
    private Integer cityId;
    private String address;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private byte[] symbol;
}