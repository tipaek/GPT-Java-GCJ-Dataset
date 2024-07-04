package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        IntStream.rangeClosed(1, T).forEach(t -> {
            int N = scanner.nextInt();
            List<List<Integer>> matrix = IntStream.range(0, N).boxed()
                    .map(i -> IntStream.range(0, N).boxed()
                            .map(j -> scanner.nextInt())
                            .collect(toList()))
                    .collect(toList());
            solve(matrix, t);
        });
    }

    private static void solve(List<List<Integer>> matrix, int t) {
        int trace = IntStream.range(0, matrix.size()).boxed()
                .map(i -> matrix.get(i).get(i))
                .reduce(0, Integer::sum);
        int rows = matrix.stream()
                .map(row -> row.stream().distinct().count() == row.size() ? 0 : 1)
                .reduce(0, Integer::sum);
        int columns = IntStream.range(0, matrix.size()).boxed()
                .map(j -> IntStream.range(0, matrix.size()).boxed()
                        .map(i -> matrix.get(i).get(j))
                        .distinct().count() == matrix.size() ? 0 : 1)
                .reduce(0, Integer::sum);
        System.out.println(format("Case #%s: %s %s %s", t, trace, rows, columns));
    }
}