package com.airtel.ytl.service;

import com.airtel.ytl.entity.Properties;
import com.airtel.ytl.entity.Student;
import com.airtel.ytl.repository.PropertiesRepository;
import com.airtel.ytl.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessClass {

    private  final Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private StudentRepository studentRepository;

     @Autowired
     private PropertiesRepository propertiesRepository;

    public List<Student> retriveStudent(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElseThrow(null);
    }

    public Student getStudentByName(String name){
        return studentRepository.getByName(name);
    }

    public String deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return "Student deleted";
    }

    public Student updateStudent(Integer id,Student student){
        Student existingStudent=getStudentById(id);
        existingStudent.setAge(student.getAge());
        existingStudent.setName(student.getName());

        return studentRepository.save(existingStudent);
    }

    public Properties postProperties(Properties property){

        Properties responseByPropertyRepo=null;
        try{
             responseByPropertyRepo =propertiesRepository.findByKey(property.getKey());
            if(responseByPropertyRepo.equals(null)){
                return propertiesRepository.save(property);
            }else {
                logger.info("exception not occured");
                return updateProperties(property.getId(), property);
            }

        }catch(Exception e) {
            logger.info("in catch block "+property.getId()+" "+property.getKey()+" "+
                    property.getProfile()+" "+property.getType()+" "+property.getValue());
            logger.error("error",e);
            return propertiesRepository.save(property);
        }
    }

    public List<Properties> retrieveProperty(){
        return propertiesRepository.findAll();
    }

    public  Properties getPropertyById(Integer id){
       return propertiesRepository.findById(id).orElseThrow(null);
    }

    public Properties updateProperties(Integer id, Properties property){

        Properties exixtingProperty=getPropertyById(id);
        exixtingProperty.setKey(property.getKey());
        exixtingProperty.setType(property.getType());
        exixtingProperty.setProfile(property.getProfile());
        exixtingProperty.setValue((property.getValue()));

        return  propertiesRepository.save(exixtingProperty);
    }

//    public List<Properties> fetchOnlyProfile(String profile){
//        return propertiesRepository.fetchProfile(profile);
//    }
}
