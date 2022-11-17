package com.company.entity;

import lombok.Data;

@Data
public class Todo {
    private Integer id;
    private Integer userId;
    private String title;
    private boolean completed;
}
