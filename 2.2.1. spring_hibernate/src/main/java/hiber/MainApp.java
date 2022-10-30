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
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");

      Car car1 = new Car(1, "Audi");
      Car car2 = new Car(2, "BMW");
      Car car3 = new Car(3, "Citroen");

      car1.setUser(user1);
      car2.setUser(user2);
      car3.setUser(user3);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      List<Car> cars = userService.listCars();
      for (Car car : cars) {
         System.out.println(car);
      }

      User user  = userService.getUserHavingCar(1, "Audi");
      if(user != null)
         System.out.println(user) ;
      else
         System.out.println("User not found");
      context.close();
   }
}
