package cn.wedding.exception;

import lombok.Getter;
import lombok.Setter;

public class SysException extends RuntimeException{
    @Setter
    @Getter
    private int code;
    private String msg;
    public SysException(int code,String msg){
        super(msg);
        this.code = code;
    }
}
