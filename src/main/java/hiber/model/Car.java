package hiber.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_name")
    private String name;

    @Column(name = "car_series")
    private Integer series;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    User user;

    public Car() {
    }

    public Car(String name, Integer series) {
        this.name = name;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getSeries() == car.getSeries() &&
                Objects.equals(getId(), car.getId()) &&
                Objects.equals(getName(), car.getName()) &&
                Objects.equals(getUser(), car.getUser());
    }

    @Override
    public int hashCode() {
        final int x = 31;
        int result = 1;
        result = result * x + (int) getId().longValue();
        result = result * x + getName().hashCode();
        result = result * x + getSeries();
        return result;
    }

}
