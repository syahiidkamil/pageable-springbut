package sekolah.lms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
}
