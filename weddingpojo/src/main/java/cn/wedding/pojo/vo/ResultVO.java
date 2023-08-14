package cn.wedding.pojo.vo;

import cn.wedding.pojo.constant.SysCode;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应的结果对象
 * @param <T>
 */
@Data
public class ResultVO<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public void success(){
        this.code   = SysCode.COMMON_SUCCESS;
        this.msg    = "操作成功！";
    }

    public void success(Integer code){
        this.code   = code;
        this.msg    = "操作成功！";
    }

    public void success(Integer code,String msg){
        this.code   = code;
        this.msg    = msg;
    }

    public void success(Integer code,String msg,T data){
        this.code   = code;
        this.msg    = msg;
        this.data   = data;
    }

    public void fail(){
        this.code   = SysCode.COMMON_FAIL;
        this.msg    = "操作失败！";
    }

    public void fail(Integer code){
        this.code   = code;
        this.msg    = "操作失败！";
    }

    public void fail(Integer code,String msg){
        this.code   = code;
        this.msg    = msg;
    }

    public void fail(Integer code,String msg,T data){
        this.code   = code;
        this.msg    = msg;
        this.data   = data;
    }
}
