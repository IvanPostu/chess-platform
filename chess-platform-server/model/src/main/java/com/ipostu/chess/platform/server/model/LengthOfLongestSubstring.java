package com.ipostu.chess.platform.server.model;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int calculate(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s should not be null");
        }

        int lowerBound = 0;
        int upperBound = calculateUpperBound(lowerBound, s);

        int leftSubstringIndex = lowerBound;
        int rightSubstringIndex = upperBound;

        while (upperBound < s.length()) {
            lowerBound = upperBound;
            upperBound = calculateUpperBound(lowerBound, s);
            if (rightSubstringIndex - leftSubstringIndex < upperBound - lowerBound) {
                leftSubstringIndex = lowerBound;
                rightSubstringIndex = upperBound;
            }
        }


        return rightSubstringIndex - leftSubstringIndex;
    }

    private static int calculateUpperBound(int lowerBound, String s) {
        Set<Character> charactersSet = new HashSet<>();
        for (int i = lowerBound; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (charactersSet.contains(c)) {
                return i;
            }
            charactersSet.add(s.charAt(i));
        }
        return s.length();
    }

}
