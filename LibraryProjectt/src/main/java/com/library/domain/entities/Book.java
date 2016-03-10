package com.library.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private long id;


 @Column(name = "name_book")
 @NotNull(message = "field should be filled in")
 @Size(min=3,max=15, message = "size of field should be between 3 and 15 characters")
 private String nameBook;

 @Column(name = "author")
 @NotNull(message = "field should be filled in")
 @Size(min=3,max=15,message = "size of field should be between 3 and 15 characters")
 private String author;

 @Column(name = "publishing_house")
 @NotNull(message = "field should be filled in")
 @Size(min=3,max=15,message = "size of field should be between 3 and 15 characters")
 private String publishingHouse;

 @OneToOne(optional = false,mappedBy = "book")
 private BookLeading bookLeading;

 public Book() {

 }

 public Book(String author) {
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

 public BookLeading getBookLeading() {
  return bookLeading;
 }

 public void setBookLeading(BookLeading bookLeading) {
  this.bookLeading = bookLeading;
 }
}
