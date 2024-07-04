import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int B = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int[] bits = new int[B];
            Arrays.fill(bits, -1);

            Set<Integer> sameIndices = new HashSet<>();
            Set<Integer> diffIndices = new HashSet<>();
            Set<Integer> restIndices = IntStream.range(0, B).boxed().collect(Collectors.toSet());

            boolean found = false;
            while (!found) {
                if (!sameIndices.isEmpty()) {
                    int index = sameIndices.iterator().next();
                    if (query(sc, index) != bits[index]) {
                        invert(bits, sameIndices);
                    }
                } else {
                    query(sc, 0);
                }

                if (!diffIndices.isEmpty()) {
                    int index = diffIndices.iterator().next();
                    if (query(sc, index) != bits[index]) {
                        invert(bits, diffIndices);
                    }
                } else {
                    query(sc, 0);
                }

                for (int i = 0; i < 4; ++i) {
                    int index1 = restIndices.iterator().next();
                    bits[index1] = query(sc, index1);

                    int index2 = B - 1 - index1;
                    bits[index2] = query(sc, index2);

                    if (bits[index1] == bits[index2]) {
                        sameIndices.add(index1);
                        sameIndices.add(index2);
                    } else {
                        diffIndices.add(index1);
                        diffIndices.add(index2);
                    }

                    restIndices.remove(index1);
                    restIndices.remove(index2);
                    if (restIndices.isEmpty()) {
                        System.out.println(Arrays.stream(bits).mapToObj(String::valueOf).collect(Collectors.joining()));
                        System.out.flush();

                        String result = sc.next();
                        if (result.equals("N")) {
                            System.exit(1);
                        }

                        found = true;

                        break;
                    }
                }
            }
        }

        sc.close();
    }

    static void invert(int[] bits, Set<Integer> indices) {
        for (int index : indices) {
            bits[index] = 1 - bits[index];
        }
    }

    static int query(Scanner sc, int index) {
        System.out.println(index + 1);
        System.out.flush();

        String result = sc.next();
        if (result.equals("N")) {
            System.exit(1);
        }

        return Integer.parseInt(result);
    }
}