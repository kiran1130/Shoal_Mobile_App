package helper;

import com.github.javafaker.Faker;

public class Helper {
	
	public static String generateFirstName() {
		Faker faker = new Faker();
		 String firstName = faker.name().firstName();
		 
		 return firstName;

	}
	
	public static String generateLastName() {
		Faker faker = new Faker();
		 
		 String lastName = faker.name().lastName();
		 return lastName;
	

	}
	
	public static String generateMobileNumber() {
		Faker faker = new Faker();
		 
		 String mobNumber = faker.number().digits(9);
		 return mobNumber;
		 

	}
	

}
