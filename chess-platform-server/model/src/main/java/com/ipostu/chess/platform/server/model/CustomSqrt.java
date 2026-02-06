package com.ipostu.chess.platform.server.model;

public final class CustomSqrt {
    private CustomSqrt() {
    }

    // 0 1 2 3 4 5 6 7 8 9
    // l=0, h=3
    // l=2,h=3
    // l=3,h=3
    // return 3
    // 0 1 2 3 4 5
    // l=0, h=5
    // l=3, h=5
    // l=3, h=3
    // l=3, h=2
    public static int sqrt(final int num) {
        int low = 0;
        int high = num;
        int result = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int square = mid * mid;
            if (square == num) {
                return mid;
            }
            if (square > num) {
                high = mid - 1;
            }
            if (square < num) {
                low = mid + 1;
            }
        }

        return low - 1;
    }

}
