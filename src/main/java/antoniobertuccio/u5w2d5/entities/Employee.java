package antoniobertuccio.u5w2d5.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Setter(AccessLevel.NONE)
  private UUID id;
  private String username;
  private String name;
  private String surname;
  private String email;
  @JsonIgnore
  @OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<Device> devices;

  public Employee(String username, String name, String surname, String email, List<Device> devices) {
    this.username = username;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.devices = devices;
  }
}
