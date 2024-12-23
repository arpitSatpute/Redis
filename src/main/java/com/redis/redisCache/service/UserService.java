package com.redis.redisCache.service;

import com.redis.redisCache.Dto.UserDto;
import com.redis.redisCache.entity.Users;
import com.redis.redisCache.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo ur;

    @CachePut(value = "users" , key = "#result.id")
    public Users saveUser(UserDto userDto) {
        Users user = new Users();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        Users savedUser = ur.save(user);
        return savedUser;
    }

    @CacheEvict(value = "users", allEntries = true)
    public List<Users> getUsers() {
        return ur.findAll();
    }

    @Cacheable(value = "users" , key = "#Id")
    public Users getUser(Long Id) {
        return ur.findById(Id).orElse(null);
    }

    @CacheEvict(value = "users" , key = "#Id", allEntries = true)
    public String deleteUser(Long Id) {
        ur.deleteById(Id);
        return "User with Id: " + Id + " deleted successfully";
    }

}
