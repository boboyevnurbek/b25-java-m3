package com.company.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data

//@RequiredArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    @JsonProperty("number")
    private Integer id;
    private String title;
    private String author;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return id.equals(book.id) && title.equals(book.title) && author.equals(book.author);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, author);
//    }
}
