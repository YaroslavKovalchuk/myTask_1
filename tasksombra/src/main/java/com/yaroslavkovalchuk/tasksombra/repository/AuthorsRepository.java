package com.yaroslavkovalchuk.tasksombra.repository;

import com.yaroslavkovalchuk.tasksombra.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorsRepository extends JpaRepository<Authors,Long> {


    @Query("select a from Authors a where a.books.size = (select max(a.books.size) from Authors a) ")
    Authors maxBooks();

    @Query("select a from Authors a where year(a.born) <= year(current_date)-:age order by a.born asc")
    List<Authors> getAuthorsOlderThen(@Param("age") Integer age);


}
