package guru.springframework;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by ronnen on 15-Feb-2021
 */


public class InlineMockTest {
    @Test
    void testInlineMock() {

        // inline mock creation using a static method of Mockito
        Map mapMock = mock(Map.class);
        assertEquals(mapMock.size(), 0);
    }

}
