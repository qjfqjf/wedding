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
public class City implements Serializable {
    private Integer id;
    private String chName;
    private String enName;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}