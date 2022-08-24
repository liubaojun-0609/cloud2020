package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/24
 * Time: 9:14
 * Description: Json封装体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommentResult(Integer code,String message){
        this(code,message,null);
    }

}
