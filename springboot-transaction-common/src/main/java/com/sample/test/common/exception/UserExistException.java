/**
 * FileName: ServiceException
 * Author:   huang.yj
 * Date:     2019/11/12 17:55
 * Description: 自定义Service层异常类
 */
package com.sample.test.common.exception;

/**
 * 〈自定义Service层异常类〉
 *
 * @author huang.yj
 * @create 2019/11/12
 * @since 0.0.1
 */
public class UserExistException extends Exception{
    public UserExistException(){}

    public UserExistException(String message){
        super(message);
    }

    public UserExistException(String message, Exception e){
        super(message, e);
    }
}