package cn.wedding.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_user")
public class User implements Serializable {
    private String id;
    private String userName;
    private String nickName;
    private String password;
    private String status;
    private String email;
    private String tel;
    private String sex;
    private String avatar;
    private String userType;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private Integer delFlag;
    private String salt;
}