package com.pang.entity;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private String username;
    private String password;
    private String id;
}
