import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        int[] result = new int[b];
        for (int r : result) {
            result[r] = -1;
        }

        int sameIdx = -1;
        int sameVal = -1;
        int diffIdx = -1;
        int diffVal = -1;

        for (int i = 1; i <= t; ++i) {
            for (int a = 0; a < 5; a++) {
                System.out.println(a);
                result[a] = in.nextInt();
                System.out.println(b - a - 1);
                result[b - a - 1] = in.nextInt();

                if (sameIdx == -1 && (result[a] == result[b - a - 1])) {
                    sameIdx = a;
                    sameVal = result[sameIdx];
                }

                if (diffIdx == -1 && (result[a] != result[b - a - 1])) {
                    diffIdx = a;
                    diffVal = result[diffIdx];
                }
            }

            String answer = "N";
            while (!"Y".equals(answer)) {
                if (sameIdx != -1 && diffIdx != -1) {
                    // strategy when we have both cases
                    int ansA;
                    int ansB;
                    System.out.println(sameIdx);
                    ansA = in.nextInt();
                    System.out.println(diffIdx);
                    ansB = in.nextInt();
                    if (ansA == sameVal && ansB == diffVal) {
                        //
                    } else if (ansA != sameVal && ansB == diffVal) {
                        both(result);
                    } else if (ansA == sameVal && ansB != diffVal) {
                        reverse(result);
                    } else {
                        complement(result);
                    }
                } else if (sameIdx == -1) {
                    // strategy when we have only diff numbers
                    System.out.println(diffIdx);
                    int ans = in.nextInt();
                    if (ans != diffVal) {
                        complement(result);
                        System.out.println(0);
                        in.nextInt();
                    }
                } else {
                    // strategy when we have only same numbers
                    System.out.println(sameIdx);
                    int ans = in.nextInt();
                    if (ans != sameVal) {
                        complement(result);
                        System.out.println(0);
                        in.nextInt();
                    }
                }

                long count = Arrays.stream(result).filter(val -> val == -1).count();
                if (count == 0) {
                    System.out.println(print(result));
                }
                answer = in.next();
            }
        }
    }

    private static void complement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
    }

    private static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    private static void both(int[] array) {
        complement(array);
        reverse(array);
    }

    private static String print(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i : array) {
            builder.append(i);
        }
        return builder.toString();
    }
}