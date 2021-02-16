package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by ronnen on 16-Feb-2021
 */

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    // definition of a repository Mock
    @Mock
    SpecialtyRepository specialtyRepository;

    // definition of a service Mock
    // the repository Mock will be injected into it
    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    void deleteTest() {

        // define a Speciality object for testing
        Speciality speciality = new Speciality();

        // define operation for the Speciality-Service,
        // the operation will be done by the repository
        specialitySDJpaService.delete(speciality);

        // verify that the repository was called once
        // on the 'speciality' object.
        verify(specialtyRepository, times(1)).delete(speciality);
    }

    @Test
    void deleteByIdTest() {
        specialitySDJpaService.deleteById(1L);
        verify(specialtyRepository,times(1)).deleteById(1L);
    }

    @Test
    void findByIdTest() {

        // internal objects for testing
        Speciality returning = new Speciality();

        // tell the repository Mock what to do on 'findById' call
        // the repository Mock is making the call to Service object
        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(returning));

        // the service is expecting 'findById'
        // in practice, the repository Mock is executing the call, as we defined a line above
        returning = specialitySDJpaService.findById(1L);

        // checking the return value is not null
        assertThat(returning).isNotNull();

        // verify that 'findById' returned the speciality object
        verify(specialtyRepository, times(1)).findById(1L);
    }

    @Test
    void findAllTest() {

        // define a reference to Speciality Set for testing
        // initialize to 'null' in-purpose, we check later if its not null
        Set<Speciality> specialities = null;

        // define what the service should do when called on 'findAll'
        when(specialitySDJpaService.findAll()).thenReturn(specialities);

        // execute the 'findAll' call
        specialities = specialitySDJpaService.findAll();

        // verify that 'specialtyRepository' was called once on 'findAll'
        verify(specialtyRepository, times(1)).findAll();

        // verify that 'specialities' is not null
        assertThat(specialities).isNotNull();

    }

    @Test
    void saveTest() {

        // define a Speciality pointer for testing
        Speciality speciality;

        // define what the service should do when called on 'save'
        when(specialitySDJpaService.save(any(Speciality.class))).thenReturn(new Speciality());

        // execute the 'save' call
        speciality = specialitySDJpaService.save(new Speciality());

        // verify that 'specialityRepository' was called once on any Speciality object
        verify(specialtyRepository, times(1)).save(any(Speciality.class));

        // verify that 'specialities' is not null
        assertThat(speciality).isNotNull();
    }
}