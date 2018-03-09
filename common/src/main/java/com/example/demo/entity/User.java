package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 16:16
 * @modified by:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    private String name;
    private Integer age;
}
