package ie.atu.labexam;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class personController {
    private List<person> personList = new ArrayList<>();

    @GetMapping("/{employeeCode}")
    public List<person> getPerson()
    {
        return personList;
    }

    @PostMapping("addEmployee")
    public String addEmployee(@RequestBody @Valid person Person, String employeeCode){
        personList.add(Person);
        return "employee successfully added\n" + "employeeCode: " + employeeCode;
    }


    @PutMapping("/{employeeCode}")
    public String updatePerson(@PathVariable("employeeCode") String employeeCode, @RequestBody person updatedPerson){
        for (person per: personList){
            if (per.getEmployeeCode().equals(employeeCode)){
                per.setName(updatedPerson.getName());
                per.setEmail(updatedPerson.getEmail());
                per.setPosition(updatedPerson.getPosition());
                per.setSalary(updatedPerson.getSalary());
                return per + "details updated";
            }
        }
        return null;
    }

    @DeleteMapping("/{employeeCode}")
    public String deleteProduct(@PathVariable("employeeCode") String employeeCode){
        for (person p : personList){
            if (p.getEmployeeCode().equals(employeeCode)){
                personList.remove(p);
                return employeeCode + " has been removed";
            }
        }
        return employeeCode + "not found";
    }
}
