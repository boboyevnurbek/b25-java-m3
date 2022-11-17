package uz.b25.project_part.service;

import uz.b25.project_part.entity.User;

import java.time.LocalDate;

public class UserService {
    public String addUser(User user){
        String message = checkParams(user);
        if(!message.equals("ok")) return message;

        return "User successfully added";
    }

    private String checkParams(User user) {
        if(user == null){
            return "User's data not found";
        }

        if(user.getFullName()==null || user.getFullName().isBlank()){
            return "Full name is required";
        }

        if(!user.getBirthDate().plusYears(18).isBefore(LocalDate.now())){
            return "Age must be great than 17";
        }

        return "ok";
    }
}
