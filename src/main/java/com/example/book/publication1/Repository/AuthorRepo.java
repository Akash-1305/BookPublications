package com.example.book.publication1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.publication1.Entity.Author;

public interface AuthorRepo extends JpaRepository <Author,Integer> {

}
