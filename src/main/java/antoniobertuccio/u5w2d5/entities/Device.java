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
  @Setter(AccessLevel.NONE)
  private UUID id;
  private String name;
  private String type;
  private String status;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "employee_UUID")
  private Employee employee;
}
