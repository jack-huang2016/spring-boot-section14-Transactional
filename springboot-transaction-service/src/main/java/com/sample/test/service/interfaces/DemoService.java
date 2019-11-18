package com.sample.test.service.interfaces;

import com.sample.test.common.entity.User;

public interface DemoService {
    public User saveUserWithRollBack(User user) throws Exception;
    public User saveUserWithoutRollBack(User user) throws Exception;
}
