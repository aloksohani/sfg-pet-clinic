package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapServiceTest {
    PetTypeMapService petTypeMapService;
    final Long petTypeId = 1L;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();
        petTypeMapService.save(PetType.builder().id(petTypeId).build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = petTypeMapService.findAll();
        assertEquals(1, petTypes.size());
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(petTypeId);
        assertEquals(0,petTypeMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id =2L;
        PetType petType2 = PetType.builder().id(id).build();
        PetType savedPet = petTypeMapService.save(petType2);
        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveNoId() {
        PetType savedPet = petTypeMapService.save(PetType.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void delete() {
        petTypeMapService.delete(petTypeMapService.findById(petTypeId));
        assertEquals(0,petTypeMapService.findAll().size());
    }

    @Test
    void findById() {
        PetType petType = petTypeMapService.findById(petTypeId);
        assertEquals(petTypeId,petType.getId());
    }
}