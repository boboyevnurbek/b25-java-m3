package com.company.service;

import com.company.entity.Book;

import java.util.HashSet;

public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(10, "Java", "A");
        Book book2 = new Book(11, "Java", "B");

        System.out.println("book1.hashCode() = " + book1.hashCode());
        System.out.println("book2.hashCode() = " + book2.hashCode());
        System.out.println("book1.equals(book2) = " + book1.equals(book2));

        HashSet<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        System.out.println("books = " + books);
    }
}
