package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VisitMapServiceTest {

    VisitMapService visitMapService;
    final Long visitId = 1L;
    final Owner owner = Owner.builder().id(2L).build();
    final Pet pet = Pet.builder().id(3L).owner(owner).build();

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();
        visitMapService.save(Visit.builder().id(visitId).pet(pet).build());
    }

    @Test
    void findAll() {
        Set<Visit> visitSet = visitMapService.findAll();
        assertEquals(1,visitSet.size());
    }

    @Test
    void deleteById() {
        visitMapService.deleteById(visitId);
        assertEquals(0,visitMapService.findAll().size());
    }

    @Test
    void delete() {
        visitMapService.delete(visitMapService.findById(visitId));
        assertEquals(0,visitMapService.findAll().size());
    }

    @Test
    void saveId() {
        Long id = 4L;
        Visit visit = Visit.builder().id(id).pet(pet).build();
        Visit savedVisit = visitMapService.save(visit);
        assertEquals(id,savedVisit.getId());
    }

    @Test
    void findById() {
        Visit visit = visitMapService.findById(visitId);
        assertEquals(visitId,visit.getId());
    }
}