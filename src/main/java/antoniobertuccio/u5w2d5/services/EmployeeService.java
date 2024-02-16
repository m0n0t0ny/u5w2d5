package antoniobertuccio.u5w2d5.services;

import antoniobertuccio.u5w2d5.entities.Employee;
import antoniobertuccio.u5w2d5.exceptions.BadRequestException;
import antoniobertuccio.u5w2d5.exceptions.EmployeeNotFoundException;
import antoniobertuccio.u5w2d5.payloads.employees.NewEmployeeDTO;
import antoniobertuccio.u5w2d5.repositories.EmployeesRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class EmployeeService {
  @Autowired
  private Cloudinary cloudinaryUploader;

  @Autowired
  private EmployeesRepository employeesRepository;


  public Employee save(NewEmployeeDTO body) throws IOException {
    employeesRepository.findByEmail(body.email()).ifPresent(user -> {
      throw new BadRequestException("L'email " + body.email() + " è già stata utilizzata");
    });
    Employee newEmployee = new Employee();
    newEmployee.setProfilePic("https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());
    newEmployee.setUsername(body.username());
    newEmployee.setName(body.name());
    newEmployee.setSurname(body.surname());
    newEmployee.setEmail(body.email());

    return employeesRepository.save(newEmployee);
  }

  public Page<Employee> getEmployees(int page, int size, String sort) {

    Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
    return employeesRepository.findAll(pageable);
  }

  public Employee findById(UUID id) {
    return employeesRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  public void findByIdAndDelete(UUID id) {
    Employee found = this.findById(id);
    employeesRepository.delete(found);
  }

  public Employee findByIdAndUpdate(UUID id, Employee body) {
    Employee found = this.findById(id);
    found.setName(body.getName());
    found.setSurname(body.getSurname());
    found.setEmail(body.getEmail());
    found.setProfilePic(body.getProfilePic());
    return employeesRepository.save(found);
  }

  public Employee uploadAvatar(UUID id, MultipartFile file) throws IOException {
    Employee found = this.findById(id);
    String avatarURL = (String) cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
    found.setProfilePic(avatarURL);
    return employeesRepository.save(found);
  }
}
