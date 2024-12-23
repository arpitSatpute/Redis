// File: src/main/java/com/redis/redisCache/Dto/UserDto.java
package com.redis.redisCache.Dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private String email;

    public UserDto() {
    }

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    // Default constructor

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}