package com.library.domain.entities;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


 @Column(name="name_book")
    private String nameBook;

 @Column(name="author")
    private String author;

 @Column(name="publishing_house")
    private String publishingHouse;

public Book(){

}

 public Book(String author){
  this.author = author;
 }

 public String getNameBook() {
  return nameBook;
 }

 public void setNameBook(String nameBook) {
  this.nameBook = nameBook;
 }

 public long getId() {
  return id;
 }

 public String getAuthor() {
  return author;
 }

 public void setAuthor(String author) {
  this.author = author;
 }

 public String getPublishingHouse() {
  return publishingHouse;
 }

 public void setPublishingHouse(String publishingHouse) {
  this.publishingHouse = publishingHouse;
 }
}
