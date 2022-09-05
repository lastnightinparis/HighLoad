package highload.lab1.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "country cannot be empty")
    @Column(name = "country")
    private String country;

    @NotBlank(message = "city cannot be empty")
    @Column(name = "country")
    private String city;

    @Min(value = 0, message = "count of race stops cannot be negative" )
    @Column(name = "stop_count")
    private int stopCount;

    @ManyToMany(mappedBy = "car_race")
    private Set<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStopCount() {
        return stopCount;
    }

    public void setStopCount(int stopCount) {
        this.stopCount = stopCount;
    }
}
