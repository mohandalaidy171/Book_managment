package com.example.books.repository;

import com.example.books.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<BooksEntity,Integer> {

    int deleteById(int x);
    @Modifying
    @Query("UPDATE BooksEntity b set b.title=?1 where b.id=?2")
    int updateByTittle(String title,int x);
}
