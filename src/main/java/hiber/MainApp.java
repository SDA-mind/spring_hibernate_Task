package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Lada", 2202)));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW", 5)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Opel", 200)));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Ford", 1999)));
      User selectedUser = userService.selectedUser(2L, 5);

      System.out.println("Id = " + selectedUser.getId());
      System.out.println("First Name = " + selectedUser.getFirstName());
      System.out.println("Last Name = " + selectedUser.getLastName());
      System.out.println("Email = " + selectedUser.getEmail());
      System.out.println();

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car_id = " + user.getCar().getId());
         System.out.println("Car_name = " + user.getCar().getName());
         System.out.println("Car_series = " + user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
