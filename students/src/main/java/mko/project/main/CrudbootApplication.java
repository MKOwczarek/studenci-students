package mko.project.main;

import mko.project.main.domain.Student;
import mko.project.main.domain.StudentRepository;
import mko.project.main.domain.User;
import mko.project.main.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CrudbootApplication 
{
	
	private static final Logger log = LoggerFactory.getLogger(CrudbootApplication.class);
	
	public static void main(String[] args) 
        {
		SpringApplication.run(CrudbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudentRepository repository, UserRepository urepository) 
        {
		return (args) -> 
                {
			// Save students
			repository.save(new Student("Steve", "Stevens", "IT", "steve.stevent@st.com"));
			repository.save(new Student("Mary", "Robinson", "IT", "mary@robinson.com"));
			repository.save(new Student("Kate", "Keystone", "Finance","kate@kate.com"));
			repository.save(new Student("Diana", "Doll", "Management","diana@doll.com"));


			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			urepository.save(user1);
			urepository.save(user2); 
		};
	}
}
