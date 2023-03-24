package merveozer.multipledb.secondary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import merveozer.multipledb.secondary.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
