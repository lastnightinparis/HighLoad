package highload.lab1.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "first name cannot be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "last name cannot be empty")
    @Column(name = "last_name")
    private String lastName;
    @OneToOne
    @Column(name = "userId")
    private User account;

    @Max(value = 10, message = "level cannot be more 10")
    @Min(value = 1, message = "level cannot be less 1")
    @Column(name = "level")
    private int level;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
