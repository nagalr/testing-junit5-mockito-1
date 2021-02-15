package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

/**
 * Created by ronnen on 15-Feb-2021
 */


public class AnnotationMocksTest {

    @Mock
    Map<String, Object> mapMock;

    /**
     * ! hello
     * * thanks!
     * ? today
     * + hi there!
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMock() {
        mapMock.put("keyvalue", "foo");
    }
}



