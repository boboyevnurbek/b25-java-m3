package uz.b25.project_part.service;

import uz.b25.project_part.entity.User;

import java.io.IOException;
import java.time.LocalDate;

public class UserService2 {
    public String addUser(User user){


        try {
            checkParams(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  ....

            return "User successfully added";




    }

    private String checkParams(User user)
            throws IOException, NumberFormatException, ArithmeticException {
        if(user == null){
            throw new IOException("User's data not found");
        }

        if(user.getFullName()==null || user.getFullName().isBlank()){
            throw new NumberFormatException("Full name is required");
        }

        if(!user.getBirthDate().plusYears(18).isBefore(LocalDate.now())){
            throw new ArithmeticException("Age must be great than 17");
        }

        return "ok";
    }
}
