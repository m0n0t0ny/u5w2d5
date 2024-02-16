package antoniobertuccio.u5w2d5.repositories;


import antoniobertuccio.u5w2d5.entities.Device;
import antoniobertuccio.u5w2d5.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DevicesRepository extends JpaRepository<Device, UUID> {
  List<Device> findByEmployee(Employee employee);
}
