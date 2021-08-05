package com.airtel.ytl.controller;

import com.airtel.ytl.entity.Properties;
import com.airtel.ytl.entity.Student;
import com.airtel.ytl.service.BusinessClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private BusinessClass businessClass;

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> retrieveAllStudent(){
        List<Student> list= businessClass.retriveStudent();
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/postStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student request){
        Student response= businessClass.saveStudent(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
       Student response= businessClass.getStudentById(id);
       return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<Student> getByName(@PathVariable String name){
      Student response= businessClass.getStudentByName(name);
      return ResponseEntity.ok(response);
    }


    @DeleteMapping(value = "/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable  Integer id){
        String response= businessClass.deleteStudent(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/updateStudent/{id}")
    public  ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody Student request){
        Student response= businessClass.updateStudent(id, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/postProperty")
    public  ResponseEntity<Properties> postProperty(@RequestBody Properties property){
        Properties response=businessClass.postProperties(property);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getProperty")
    public  ResponseEntity<List<Properties>> retrieveProperty(){
        List<Properties> list= businessClass.retrieveProperty();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/getPropertyById/{id}")
    public ResponseEntity<Properties> getPropertyById(@PathVariable Integer id){
        Properties response=businessClass.getPropertyById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value ="/updateProperty/{id}")
    public ResponseEntity<Properties> updateProperty(@PathVariable Integer id,
                                                     @RequestBody Properties properties){
        Properties response= businessClass.updateProperties(id,properties);
        return ResponseEntity.ok(response);
    }

//    @GetMapping(value = "/fetchProfile/{profile}")
//    public  ResponseEntity<List<Properties>> fetchProfile(String profile){
//        List<Properties > response=businessClass.fetchOnlyProfile(profile);
//        return ResponseEntity.ok(response);
//    }
}
