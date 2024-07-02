package sekolah.lms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Table(name = "subject_students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SubjectStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
