package antoniobertuccio.u5w2d5.controllers;

import antoniobertuccio.u5w2d5.entities.Employee;
import antoniobertuccio.u5w2d5.exceptions.BadRequestException;
import antoniobertuccio.u5w2d5.payloads.employees.NewEmployeeDTO;
import antoniobertuccio.u5w2d5.payloads.employees.NewEmployeeResponseDTO;
import antoniobertuccio.u5w2d5.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public NewEmployeeResponseDTO saveEmployee(@RequestBody @Validated NewEmployeeDTO body, BindingResult validation) throws Exception {
    if (validation.hasErrors()) {
      throw new BadRequestException(validation.getAllErrors());
    }
    Employee newEmployee = employeeService.save(body);
    return new NewEmployeeResponseDTO(newEmployee.getId());
  }

  @GetMapping("")
  public Page<Employee> getEmployee(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue = "id") String sortBy) {
    return employeeService.getEmployees(page, size, sortBy);
  }

  @GetMapping("/{employeeId}")
  public Employee findById(@PathVariable UUID employeeId) {
    return employeeService.findById(employeeId);
  }

  @DeleteMapping("/{employeeId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void findAndDelete(@PathVariable UUID employeeId) {
    employeeService.findByIdAndDelete(employeeId);
  }

  @PatchMapping("/{employeeId}/profilePic")
  public Employee uploadAvatar(@RequestParam("avatar") MultipartFile file, @PathVariable UUID employeeId) {
    try {
      return employeeService.uploadAvatar(employeeId, file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @PatchMapping("/{employeeId}/email")
  public Employee updateEmail(@PathVariable UUID employeeId, @RequestParam("email") String email) {
    return employeeService.updateEmail(employeeId, email);
  }

}
