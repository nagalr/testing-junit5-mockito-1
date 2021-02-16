package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by ronnen on 16-Feb-2021
 */

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService service;


    @Test
    void findAll() {
        Set<Visit> visits;

        when(service.findAll()).thenReturn(new HashSet<>());

        visits = service.findAll();

        verify(repository, times(1)).findAll();

        assertThat(visits).isNotNull();

    }

    @Test
    void findByIdTest() {
        Visit visit = null;

        when(repository.findById(1L)).thenReturn(Optional.of(new Visit()));

        visit = service.findById(1L);

        verify(repository, times(1)).findById(1L);

        assertThat(visit).isNotNull();
    }

    @Test
    void save() {

        Visit visit = null;

        when(service.save(any(Visit.class))).thenReturn(new Visit());

        visit = service.save(new Visit());

        verify(repository, times(1)).save(any(Visit.class));

        assertThat(visit).isNotNull();
    }

    @Test
    void delete() {

        Visit visit = new Visit();

        service.delete(visit);

        verify(repository, times(1)).delete(any(Visit.class));

    }

    @Test
    void deleteById() {

        service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}