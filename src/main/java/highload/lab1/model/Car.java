package highload.lab1.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "brand")
    private String brand;

    @NotBlank
    @Column(name = "type")
    private String type;

    @Min(value = 0, message = "horsepower cannot be negative")
    @Column(name = "horsepower")
    private int horsepower;

    @NotBlank(message = "registration number cannot be empty")
    @Column(name = "registration_number")
    private String registrationNumber;

    @Min(value = 0, message = "mileage cannot be negative")
    @Column(name = "mileage")
    private int mileage;

    @Temporal(TemporalType.DATE)
    @Column(name = "tech_inspection_date")
    private LocalDate techInspectionDate;

    @OneToOne
    @Column(name = "driver")
    private Driver driver;

    @ManyToMany(mappedBy = "part_car")
    private Set<CarPart> carParts;

    @ManyToMany
    @JoinTable(
            name = "car_race",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"))
    private Set<Race> races;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public LocalDate getTechInspectionDate() {
        return techInspectionDate;
    }

    public void setTechInspectionDate(LocalDate techInspectionDate) {
        this.techInspectionDate = techInspectionDate;
    }

    public Set<CarPart> getCarParts() {
        return carParts;
    }

    public void setCarParts(Set<CarPart> carParts) {
        this.carParts = carParts;
    }

    public Set<Race> getRaces() {
        return races;
    }

    public void setRaces(Set<Race> races) {
        this.races = races;
    }
}
