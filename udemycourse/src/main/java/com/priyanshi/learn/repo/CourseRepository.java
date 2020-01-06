package com.priyanshi.learn.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.priyanshi.learn.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
	
	@Query(value = "select * from learn.course where cid = ?1", nativeQuery = true)
	public Course findByCourse(String courseId);
}
