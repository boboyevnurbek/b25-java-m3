package com.company.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

//    private Integer id;
    private UUID id;
    private String title;
    private String author;
    private double price;

}
