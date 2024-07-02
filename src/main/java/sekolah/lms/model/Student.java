package sekolah.lms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nim;
    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
