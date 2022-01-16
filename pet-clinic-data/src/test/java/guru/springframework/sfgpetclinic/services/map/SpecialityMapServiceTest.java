package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityMapServiceTest {

    SpecialityMapService specialityMapService;
    final Long specialityId = 1L;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        specialityMapService.save(Speciality.builder().id(specialityId).build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialitySet = specialityMapService.findAll();
        assertEquals(1, specialitySet.size());
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(specialityId);
        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void delete() {
        specialityMapService.delete(specialityMapService.findById(specialityId));
        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Speciality speciality = Speciality.builder().id(id).build();
        Speciality savedSpeciality = specialityMapService.save(speciality);
        assertEquals(id, savedSpeciality.getId());
    }

    @Test
    void saveNoId() {
        Speciality savedSpeciality = specialityMapService.save(Speciality.builder().build());
        assertNotNull(savedSpeciality);
        assertNotNull(savedSpeciality.getId());
    }

    @Test
    void findById() {
        Speciality speciality = specialityMapService.findById(specialityId);
        assertEquals(specialityId,speciality.getId());
    }
}