package com.company.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Getter
//@Setter
////@ToString(exclude = "password")
//@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private List<String> subjects;
    //private LocalDate birthDate;

//    public User(Integer id, String username, String password, List<String> subjects) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.subjects = subjects;
//    }

    //    public User(Integer id, String username, String password) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
