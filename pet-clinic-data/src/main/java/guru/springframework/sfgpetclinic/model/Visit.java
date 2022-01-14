package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @ManyToOne
    @JoinColumn(name ="pet_id")
    private Pet pet;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
}
