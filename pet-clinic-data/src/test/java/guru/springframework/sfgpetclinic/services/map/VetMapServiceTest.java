package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetMapServiceTest {

    VetMapService vetMapService;
    final Long vetId = 1L;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        vetMapService.save(Vet.builder().id(vetId).build());
    }

    @Test
    void findAll() {
        Set<Vet> vetSet = vetMapService.findAll();
        assertEquals(1, vetSet.size());
    }

    @Test
    void deleteById() {
        vetMapService.deleteById(vetId);
        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void delete() {
        vetMapService.delete(vetMapService.findById(vetId));
        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Vet vet = Vet.builder().id(id).build();
        Vet savedVet = vetMapService.save(vet);
        assertEquals(id, savedVet.getId());
    }

    @Test
    void saveNoId() {
        Vet savedVet = vetMapService.save(Vet.builder().build());
        assertNotNull(savedVet);
        assertNotNull(savedVet.getId());
    }

    @Test
    void findById() {
        Vet vet = vetMapService.findById(vetId);
        assertEquals(vetId, vet.getId());
    }
}