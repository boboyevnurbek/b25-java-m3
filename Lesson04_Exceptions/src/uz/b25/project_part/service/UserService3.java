package uz.b25.project_part.service;

import uz.b25.project_part.entity.User;
import uz.b25.project_part.exceptions.ValidException;

import java.io.IOException;
import java.time.LocalDate;

public class UserService3 {
    public String addUser(User user){


        try {
            checkParams(user);

            //  ....

            return "User successfully added";

        } catch (ValidException e) {
            return e.getMessage();
        }

    }

    private String checkParams(User user) throws ValidException {
        if(user == null){
            throw  new ValidException("User's data not found");
        }

        if(user.getFullName()==null || user.getFullName().isBlank()){
            throw new ValidException("Full name is required");
        }

        if(!user.getBirthDate().plusYears(18).isBefore(LocalDate.now())){
            throw new ValidException("Age must be great than 17");
        }

        return "ok";
    }
}
