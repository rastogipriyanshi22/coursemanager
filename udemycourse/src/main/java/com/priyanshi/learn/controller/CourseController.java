package com.priyanshi.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshi.learn.exception.BadRequestException;
import com.priyanshi.learn.model.Course;
import com.priyanshi.learn.service.CourseService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping(value = "/{courseId}")
	public Course getCourseByName(@PathVariable String courseId) {
		return service.getCourseByName(courseId);
	}
	
	@GetMapping(value = "/getAllCourses")
	public List<Course> getAllCourses() {
		return service.getCourses();
	}

	@PostMapping(value = "/addCourse", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCourse(@RequestBody final Course course) {
		return ResponseEntity.ok().body(service.addCourse(course));
	}

	@PutMapping(value = "/updateCourse/{courseId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCourse(@RequestBody final Course course, @PathVariable String courseId) throws BadRequestException {
		return ResponseEntity.ok().body(service.updateCourse(course, courseId));
	}
	
	@DeleteMapping(value = "/deleteCourse/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable String courseId) throws BadRequestException{
		return ResponseEntity.ok().body(service.deleteCourseById(courseId));
	}
	
}
