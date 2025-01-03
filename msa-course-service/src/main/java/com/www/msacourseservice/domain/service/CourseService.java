package com.www.msacourseservice.domain.service;

import com.www.msacourseservice.domain.entity.Course;
import com.www.msacourseservice.domain.repository.CourseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  private final CourseRepository courseRepository;

  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public Course saveCourse(Course course) {
    return courseRepository.save(course);
  }

  public Course updateCourse(Long courseId, Course courseDetails) {
    Course course = courseRepository.findById(courseId)
        .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
    course.setTitle(courseDetails.getTitle());
    course.setDescription(courseDetails.getDescription());
    course.setInstructorId(courseDetails.getInstructorId());
    return courseRepository.save(course);
  }

  public Optional<Course> getCourseById(Long courseId) {
    return courseRepository.findById(courseId);
  }

  public List<Course> getAllCourses() {
    return courseRepository.findAll();
  }

  public List<Course> getCourseByIds(List<Long> courseIds) {
    return courseRepository.findAllById(courseIds);
  }
}