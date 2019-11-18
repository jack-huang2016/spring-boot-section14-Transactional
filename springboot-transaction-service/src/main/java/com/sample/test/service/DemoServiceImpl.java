/**
 * FileName: DemoServiceImpl
 * Author:   huang.yj
 * Date:     2019/11/18 9:57
 * Description: 实现类
 */
package com.sample.test.service;

import com.sample.test.common.entity.User;
import com.sample.test.common.exception.ServiceException;
import com.sample.test.common.exception.UserExistException;
import com.sample.test.dao.UserDao;
import com.sample.test.service.interfaces.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 〈实现类〉
 *
 * @author huang.yj
 * @create 2019/11/18
 * @since 0.0.1
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor={UserExistException.class})
    public User saveUserWithRollBack(User user) throws Exception{

        User u = null;
        try {
            u = userDao.save(user);

            if ("itaem".equals(u.getUserName())) {
                throw new UserExistException("用户名itaem已存在，数据将回滚");
            }
        } catch (UserExistException e){
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return u;
    }

    @Override
    @Transactional(noRollbackFor ={UserExistException.class})
    public User saveUserWithoutRollBack(User user) throws Exception{
        User u = null;
        try {
            u = userDao.save(user);

            if ("itaem".equals(u.getUserName())) {
                throw new UserExistException("用户名itaem虽已存在，但数据将不会回滚");
            }
        } catch (UserExistException e){
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return u;
    }
}