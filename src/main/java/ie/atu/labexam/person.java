package ie.atu.labexam;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class person {
    @NotBlank(message = "employee code cant be blank")
    @Pattern(regexp = "EMP-1234")
    public String employeeCode;
    @NotBlank(message = "name cant be blank")
    @Size(max = 100, message = "name cannot be more than 100 characters")
    private String name;
    @Email(message = "enter email correctly")
    private String email;
    @NotBlank(message = "must be Manager, Developer or Analyst")
    private String position;
    @Min(value = 0, message = "salary must be positive")
    private int salary;
    @DateTimeFormat()
    private String dateOfJoining;



}
