package com.le.viet.mockito.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by onelazyguy on 4/2/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TigerTest {
    @Mock
    private Animal tigerMock;

    @Test
    public void testTigerMakeNoise(){
        String acutalNoise = "rgghh rgghh";
        tigerMock = mock(Tiger.class);
        when(tigerMock.makeNoise()).thenReturn(acutalNoise);
        //verify(tigerMock).makeNoise();
        String expectedNoise = tigerMock.makeNoise();
        assertEquals(acutalNoise, expectedNoise);
    }
}
