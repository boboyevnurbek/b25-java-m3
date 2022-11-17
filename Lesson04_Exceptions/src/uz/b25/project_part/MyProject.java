package uz.b25.project_part;

import uz.b25.project_part.entity.User;
import uz.b25.project_part.service.UserService3;

import java.time.LocalDate;

public class MyProject {
    public static void main(String[] args) {
        User user = new User("Alibek", "ali", "1",
                LocalDate.of(2000,1,1));

        String result = new UserService3().addUser(user);
        System.out.println("result = " + result);
    }
}
