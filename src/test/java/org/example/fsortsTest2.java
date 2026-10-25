package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class fsortsTest2 {

    @ParameterizedTest
    @MethodSource("testBubbleSortData")
    void testBubbleSort(int N) {
        Random random = new Random(); // или new Random(7777) для воспроизводимости
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = random.nextInt(100); // случайные числа от 0 до 99

        long start = System.nanoTime();
        fsorts.quickSort(arr);
        System.out.println(System.nanoTime() - start);

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    static Stream<Arguments> testBubbleSortData() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(10),
                Arguments.of(100),
                Arguments.of(1000),
                Arguments.of(2000),
                Arguments.of(4000),
                Arguments.of(8000),
                Arguments.of(16000),
                Arguments.of(32000),
                Arguments.of(64000),
                Arguments.of(128000)
        );
    }
}