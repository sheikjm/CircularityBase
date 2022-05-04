package com.trustrace.circularity.serviceImpl;

import com.trustrace.circularity.entity.User;
import com.trustrace.circularity.repository.UserRepository;
import com.trustrace.circularity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    @Cacheable("getAllUser")
    public List<User> getAllUser() {
        log.info("get all user call");
        return userRepository.findAll();
    }
}
