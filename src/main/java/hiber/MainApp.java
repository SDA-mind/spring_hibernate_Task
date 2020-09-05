package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Lada", 2202)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW", 5)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Opel", 200)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Ford", 1999)));
        User selectedUser = userService.selectedUser(3L, 200);
        System.out.print(selectedUser);
        System.out.println();

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.print(user);
            System.out.println();
        }

        context.close();
    }
}
