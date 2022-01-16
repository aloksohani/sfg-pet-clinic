package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;
    final String petName = "cat";
    final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(petId).name(petName).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();
        assertEquals(1, petSet.size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(petId);
        assertEquals(0,petMapService.findAll().size());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(1L));
        assertEquals(0,petMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Pet pet = Pet.builder().id(id).build();
        Pet savedPet = petMapService.save(pet);
        assertEquals(id,savedPet.getId());
    }

    @Test
    void saveNoId() {
        Pet savedPet = petMapService.save(Pet.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());

    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(petId);
        assertEquals(petId, pet.getId());
    }
}