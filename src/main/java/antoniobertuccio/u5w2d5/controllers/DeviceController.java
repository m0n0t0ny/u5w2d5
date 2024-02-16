package antoniobertuccio.u5w2d5.controllers;

import antoniobertuccio.u5w2d5.entities.Device;
import antoniobertuccio.u5w2d5.exceptions.BadRequestException;
import antoniobertuccio.u5w2d5.payloads.devices.EmployeeIdDTO;
import antoniobertuccio.u5w2d5.payloads.devices.NewDeviceDTO;
import antoniobertuccio.u5w2d5.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/device")
public class DeviceController {
  @Autowired
  private DeviceService deviceService;

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Device saveDevice(@RequestBody @Validated NewDeviceDTO body, BindingResult validation) {

    if (validation.hasErrors()) {
      throw new BadRequestException(validation.getAllErrors());
    }
    return deviceService.save(body);
  }

  @GetMapping("")
  public List<Device> getDevices(@RequestParam(required = false) UUID employeeId) {
    if (employeeId != null) return deviceService.findByEmployee(employeeId);
    else return deviceService.getDevices();
  }

  @GetMapping("/{deviceId}")
  public Device findById(@PathVariable UUID deviceId) {
    return deviceService.findById(deviceId);
  }

  @PutMapping("/{deviceId}")
  public Device findAndUpdate(@PathVariable UUID deviceId, @RequestBody NewDeviceDTO body) {
    return deviceService.findByIdAndUpdate(deviceId, body);
  }

  @DeleteMapping("/{deviceId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void findAndDelete(@PathVariable UUID deviceId) {
    deviceService.findByIdAndDelete(deviceId);
  }

  @PatchMapping("/{deviceId}/assign")
  public Device assignDeviceToEmployee(@PathVariable UUID deviceId, @RequestBody EmployeeIdDTO employeeId) {
    return deviceService.assignDeviceToEmployee(deviceId, employeeId);
  }
}
