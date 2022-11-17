package com.company.service;

import java.util.UUID;

public class App5 {
    public static void main(String[] args) {
        System.out.println("UUID.randomUUID() = " + UUID.randomUUID());
        System.out.println("UUID.randomUUID() = " + UUID.randomUUID());
        System.out.println("UUID.randomUUID() = " + UUID.randomUUID());
        System.out.println("UUID.randomUUID() = " + UUID.randomUUID());

        UUID uuid = UUID.fromString("814908fa-47a9-485c-a3c6-a13c97bd702f");
        System.out.println("uuid = " + uuid);
    }
}
