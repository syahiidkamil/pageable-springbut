package sekolah.lms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name="teacher_id", nullable = false)
    private Teacher teacher;
}