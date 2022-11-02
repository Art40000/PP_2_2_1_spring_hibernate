package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "series")
    private int series;
    @Column(name = "model")
    String model;
    @OneToOne(cascade = CascadeType.ALL)
    User user;

    public Car() {
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getSeries() { return series; }

    public void setSeries(int series) { this.series = series; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", series=" + series +
                ", model='" + model + '\'' +
                ", user=" + user.getId() +
                '}';
    }
}
