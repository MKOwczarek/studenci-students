package mko.project.main.tests;

import org.junit.Test;
import org.junit.runner.*;

import static org.junit.Assert.*;

import java.util.Optional;
import mko.project.main.domain.Student;
import mko.project.main.domain.StudentRepository;
import mko.project.main.domain.User;
import mko.project.main.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CrudbootApplicationTests 
{


	private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) 
    {
        this.studentRepository = studentRepository;
    }    
    
    @Test
    public void addUser() 
    {
    	User user = new User("testuser", "testuser", "USER");

    	assertNull(user.getId());
    	userRepository.save(user);
    	assertNotNull(user.getId());
    }
    
	@Test
    public void addStudent() 
    {
		Student student = new Student("Test", "Student", "IT", "test@test.com");
		
		studentRepository.save(student);
		Optional<Student> findStudent = studentRepository.findById(student.getId());
		assertTrue(findStudent.isPresent());
    }
    
}
