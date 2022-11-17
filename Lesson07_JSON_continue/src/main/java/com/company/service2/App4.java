package com.company.service2;

import com.company.entity.Todo;
import com.company.entity.User;
import com.company.files.WorkWithFiles;

import java.util.List;

public class App4 {
    public static void main(String[] args) {
        List<User> userList = WorkWithFiles.getUsers();
        List<Todo> todoList = WorkWithFiles.getTodos();

        System.out.printf("%-5s %-25s %-7s %s \n\n",
                "Id", "User name", "Done", "Title");

        for (Todo todo : todoList) {
            User user = userList.stream()
                    .filter(u -> u.getId().equals(todo.getUserId()))
                    .findFirst().orElse(null);
            System.out.printf("%-5s %-25s %-7s %s \n",
                    todo.getId(), user.getName(),  todo.isCompleted(), todo.getTitle());
        }
    }
}
