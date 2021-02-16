package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by ronnen on 16-Feb-2021
 */

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    void deleteTest() {
        specialitySDJpaService.delete(new Speciality());
    }

    @Test
    void deleteByIdTest() {
        specialitySDJpaService.deleteById(1L);

        verify(specialtyRepository,never()).deleteById(2L);
    }

    @Test
    void findByIdTest() {
        Speciality returning = new Speciality();

        // tell the repository Mock what to do on 'findById' call
        // the repository Mock is making to call the
        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(returning));

        // do what we defined
        returning = specialitySDJpaService.findById(1L);

        // checking the return value
        assertThat(returning).isNotNull();

        // verify that 'findById' returned the speciality object
        verify(specialtyRepository, times(1)).findById(1L);
    }
}