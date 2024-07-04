import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int[] parameters = Arrays.stream(input.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int t = parameters[0];
        int b = parameters[1];
        for (int i = 0; i < t; i++) {
            String result = solve(input, b);
            // System.err.println("Case #" + (i + 1) + ": " + result);
            System.out.println(result);
            if (input.nextLine().equals("N")) {
                break;
            }
        }
    }

    private static String solve(Scanner input, int b) {
        int[] array = new int[b];
        Arrays.fill(array, -1);
        int requestsNumber = 0;
        int p = 0;
        Integer same = null;
        Integer different = null;
        while (p < b / 2) {

            while (p < b / 2 && (requestsNumber == 0 || requestsNumber % 10 != 0)) {
                int l = request(input, p);
                int r = request(input, b - 1 - p);
                requestsNumber += 2;
                array[p] = l;
                array[b - 1 - p] = r;
                if (l == r) {
                    same = p;
                }
                if (l != r) {
                    different = p;
                }
                p++;
            }

            if (p < b / 2) {
                int action;
                if (different == null) {
                    int s = request(input, same);
                    request(input, same);
                    requestsNumber += 2;
                    action = s != array[same] ? 0 : 1;
                } else if (same == null) {
                    int d = request(input, different);
                    request(input, different);
                    requestsNumber += 2;
                    action = d != array[different] ? 0 : 3;
                } else {
                    int s = request(input, same);
                    int d = request(input, different);
                    requestsNumber += 2;
                    if (s == array[same]) {
                        action = d == array[different] ? 3 : 1;
                    } else {
                        action = d == array[different] ? 2 : 0;
                    }
                }

                if (action == 0) {
                    complement(array, p + 1);
                } else if (action == 1) {
                    revert(array, p + 1);
                } else if (action == 2) {
                    complement(array, p + 1);
                    revert(array, p + 1);
                }
            }
        }

        return IntStream.of(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    private static void revert(int[] array, int limit) {
        for (int i = 0; i < limit; i++) {
            swap(array, i, array.length - 1 - i);
        }
    }

    private static void complement(int[] array, int limit) {
        for (int i = 0; i < limit; i++) {
            array[i] = complement(array[i]);
            array[array.length - 1 - i] = complement(array[array.length - 1 - i]);
        }
    }

    private static int complement(int v) {
        return v == 0 ? 1 : 0;
    }

    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }

    private static int request(Scanner input, int i) {
        System.out.println(i + 1);
        return Integer.parseInt(input.nextLine());
    }
}
