package uz.fayziddin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "firstName", nullable = false, length = 64)
    private String first_name;

    @NotBlank
    @Column(name = "lastName", nullable = false, length = 64)
    private String last_name;

    @NotBlank
    @Size(min = 8, max = 64, message = "Username length must be in 8 and 64")
    @Column(name = "username", nullable = false)
    private String username;

    @NotBlank
    @Email(message = "Enter correct email address")
    private String email;

    @NotBlank
    @Pattern(regexp = "^\\+9989\\d{8}", message = "Enter only mobile number")
    private String phone;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull
    @Past(message = "Birthday must be in past")
    private Date birthday;

    @NotNull
    @Min(value = 18, message = "Registration age must be more than 18")
    private Integer age;
}
