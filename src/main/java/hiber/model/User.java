package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
   private Car car;

   public User() {
   }

   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
      car.setUser(this);
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public Long getCarId() {
      return car.getId();
   }

   public String getCarName() {
      return car.getName();
   }

   public void setCarName(String carName) {
      car.setName(carName);
   }

   public int getCarSeries() {
      return car.getSeries();
   }

   public void setCarSeries(int series) {
      car.setSeries(series);
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof User)) return false;
      User user = (User) o;
      return Objects.equals(getId(), user.getId()) &&
              Objects.equals(getFirstName(), user.getFirstName()) &&
              Objects.equals(getLastName(), user.getLastName()) &&
              Objects.equals(getEmail(), user.getEmail()) &&
              Objects.equals(getCar(), user.getCar());
   }

   @Override
   public int hashCode() {
      final int x = 31;
      int result = 1;
      result = result * x + (int) getId().longValue();
      result = result * x + getFirstName().hashCode();
      result = result * x + getLastName().hashCode();
      result = result * x + getEmail().hashCode();
      result = result * x + getCar().hashCode();
      return result;
   }

   @Override
   public String toString() {
      return "User: " +
              "id=" + id + "," + "\n" +
              "firstName='" + firstName + "," + "\n" +
              "lastName='" + lastName + "," + "\n" +
              "email='" + email + "," + "\n" +
              "Car_id=" + car.getId() + "," + "\n" +
              "Car_name = " + car.getName() + "," + "\n" +
              "Car_series = " + car.getSeries() + ".";
   }
}
