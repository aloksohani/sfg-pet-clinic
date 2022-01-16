package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="specialities")
public class Speciality extends BaseEntity{

    @Builder
    Speciality(Long id){
        super(id);
    }

    @Column(name = "description")
    private String description;
}
