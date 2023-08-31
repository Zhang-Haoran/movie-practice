package com.jiangren.movie.service;

import com.jiangren.movie.dao.UserDao;
import com.jiangren.movie.dto.user.UserGetDto;
import com.jiangren.movie.dto.user.UserPostDto;
import com.jiangren.movie.entity.User;
import com.jiangren.movie.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    private final UserMapper userMapper;

    public UserGetDto create(UserPostDto userPostDto){
        User user = new User();
        user.setPassword(userPostDto.getPassword());
        user.setEmail(userPostDto.getEmail());
        user.setName(userPostDto.getName());

        userDao.save(user);
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setEmail(user.getEmail());
        userGetDto.setName(user.getName());
        userGetDto.setId(user.getId());
        userGetDto.setCreatedTime(user.getCreatedTime());
        userGetDto.setUpdatedTime(user.getUpdatedTime());
        return userGetDto;
    }

    public UserGetDto findUserById(long userId) {
        User savedUser = userDao.findById(userId).get();

        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setEmail(savedUser.getEmail());
        userGetDto.setName(savedUser.getName());
        userGetDto.setId(savedUser.getId());
        userGetDto.setCreatedTime(savedUser.getCreatedTime());
        userGetDto.setUpdatedTime(savedUser.getUpdatedTime());

        return userGetDto;
    }
}
