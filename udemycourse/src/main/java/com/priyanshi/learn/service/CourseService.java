package com.priyanshi.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanshi.learn.exception.BadRequestException;
import com.priyanshi.learn.model.Course;
import com.priyanshi.learn.repo.CourseRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public Course getCourseByName(String courseId) {
		return courseRepository.findByCourse(courseId);
	}
	
	public List<Course> getCourses() {
		return (List<Course>) courseRepository.findAll();
	}

	public Course addCourse(Course course) {
		log.info("Saving course in database");
		courseRepository.save(course);
		return course;
	}

	public Course updateCourse(Course course, String courseId) throws BadRequestException {
		try {
			log.info("updated data value");
			Course courseDetail = courseRepository.findByCourse(courseId);
			if (!StringUtils.isEmpty(courseDetail)) {
				courseDetail.setAuthor(course.getAuthor());
				courseDetail.setName(course.getName());
				log.info("updated data entry value in database");
				courseRepository.save(courseDetail);
				return courseDetail;
			} else
				throw new BadRequestException("course not present in database {}");
		} catch (BadRequestException bre) {
			throw bre;
		}
	}

	public String deleteCourseById(String courseId) throws BadRequestException {
		try {
		Course courseDetail = courseRepository.findByCourse(courseId);
		if (!StringUtils.isEmpty(courseDetail)) {
		log.info("delete course with id {}", courseId);
		courseRepository.deleteById(courseDetail.getId());
		return "course deleted successfully";
		}
		else
			throw new BadRequestException("course not present in database {}");
		}
		catch (BadRequestException bre) {
			throw bre;
		}
	}

	
}
