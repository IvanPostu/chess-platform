package com.ipostu.chess.platform.server.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTest {

    @Test
    public void testLengthOfLongestSubstringTest() {
        assertEquals(3, LengthOfLongestSubstring.calculate("ababcab"));
    }

}
