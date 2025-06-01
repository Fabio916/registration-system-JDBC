package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		UserDao userDao = DaoFactory.createUserDao();
		
		/*System.out.print("Find by id: ");
		int id = sc.nextInt();
		User user = userDao.findById(id);
		System.out.println(user);
		
		System.out.print("Find All: \n");
		List<User> users = userDao.findAll();
		
		users.forEach(System.out::println);
		
		
		System.out.println("=== Insert implementation ===");
		User user = new User(null, "Joao Gabo", "gugamundi123@gmail.com", "realyeFODA");
		userDao.insert(user);
		System.out.println("User inserted!");
		*/
		
		System.out.println("Delete test: ");
		System.out.print("Enter the id from the user: ");
		int id = sc.nextInt();
		userDao.deleteById(id);
		System.out.println("Delete succesfull");
		
		sc.close();
	}

}
