package com.blogapplication.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
     
    private int id;
    
    private String name;
    
    private String email;
    
    
    private String password;
    
    private int age;
    
    private String gender;
}
