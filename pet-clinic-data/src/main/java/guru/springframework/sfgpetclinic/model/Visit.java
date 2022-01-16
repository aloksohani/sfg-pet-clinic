package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Builder
    public Visit(Long id, Pet pet, LocalDate date, String description) {
        super(id);
        this.pet = pet;
        this.date = date;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name ="pet_id")
    private Pet pet;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
}
