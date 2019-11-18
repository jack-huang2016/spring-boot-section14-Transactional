/**
 * FileName: MyController
 * Author:   huang.yj
 * Date:     2019/11/18 10:30
 * Description: 控制器
 */
package com.sample.test.web;

import com.sample.test.common.entity.User;
import com.sample.test.service.interfaces.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈控制器〉
 *
 * @author huang.yj
 * @create 2019/11/18
 * @since 0.0.1
 */
@RestController
public class MyController {
    @Autowired
    private DemoService demoService;

    /**
     * 测试回滚情况
     * @param user
     * @return
     */
    @RequestMapping("/rollback")
    public ResponseEntity<Void> rollback(User user){
        try {
            demoService.saveUserWithRollBack(user);
            // 成功，响应201
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 测试不回滚情况
     * @param user
     * @return
     */
    @RequestMapping("/norollback")
    public ResponseEntity<Void> noRollback(User user){
        try {
            demoService.saveUserWithoutRollBack(user);
            // 成功，响应201
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}