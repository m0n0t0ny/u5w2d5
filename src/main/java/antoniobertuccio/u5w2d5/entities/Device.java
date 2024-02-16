package antoniobertuccio.u5w2d5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String type;
  private String status;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "employee_UUID")
  private Employee employee;

  public Device(String type, String status, Employee employee) {
    this.type = type;
    this.status = status;
    this.employee = employee;
  }
}
