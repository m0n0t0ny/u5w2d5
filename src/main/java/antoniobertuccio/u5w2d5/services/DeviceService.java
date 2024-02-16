package antoniobertuccio.u5w2d5.services;

import antoniobertuccio.u5w2d5.entities.Device;
import antoniobertuccio.u5w2d5.entities.Employee;
import antoniobertuccio.u5w2d5.exceptions.DeviceNotFoundException;
import antoniobertuccio.u5w2d5.payloads.devices.NewDeviceDTO;
import antoniobertuccio.u5w2d5.repositories.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceService {
  @Autowired
  private DevicesRepository devicesRepository;

  @Autowired
  private EmployeeService employeeService;

  public Device save(NewDeviceDTO body) {
    Device newDevice = new Device();
    newDevice.setName(body.name());
    newDevice.setType(body.type());
    return devicesRepository.save(newDevice);
  }

  public List<Device> getDevices() {
    return devicesRepository.findAll();
  }

  public Device findById(UUID id) {
    return devicesRepository.findById(id).orElseThrow(() -> new DeviceNotFoundException(id));
  }

  public void findByIdAndDelete(UUID id) {
    Device found = this.findById(id);
    devicesRepository.delete(found);
  }

  public Device findByIdAndUpdate(UUID id, NewDeviceDTO body) {
    Device found = this.findById(id);

    found.setName(body.name());
    found.setType(body.type());

    return devicesRepository.save(found);
  }

  public List<Device> findByEmployee(UUID employeeId) {
    Employee employee = employeeService.findById(employeeId);
    return devicesRepository.findByEmployee(employee);
  }
}
