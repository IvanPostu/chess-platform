package com.ipostu.chess.platform.server.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomSqrtTest {

    @Test
    public void testCustomSqrt() {
        assertEquals(3, CustomSqrt.sqrt(9));
        assertEquals(2, CustomSqrt.sqrt(4));
        assertEquals(2, CustomSqrt.sqrt(5));
    }

}
