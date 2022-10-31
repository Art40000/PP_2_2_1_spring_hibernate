package hiber.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "series", "model" }) })
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "series")
    private int series;
    @Column(name = "model")
    private String model;

    public Car() {
    }
    public Car(int series, String model){
        this.series = series;
        this.model = model;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getSeries() { return series; }

    public void setSeries(int series) { this.series = series; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}';
    }
}
