import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            if (!processTestCase(scanner, bitLength)) {
                System.exit(0);
            }
        }
    }

    public static boolean processTestCase(Scanner scanner, int bitLength) {
        int diffIndex = -1, sameIndex = -1;
        int[] bits = new int[bitLength];
        for (int i = 0, queries = 0; i <= (bitLength - 1) / 2; i++) {
            if (queries % 10 == 9) {
                // burn a query
                System.out.println(1);
                queries++;
            }
            if (queries > 0 && queries % 10 == 0) {
                if (diffIndex == -1 || sameIndex == -1) {
                    int targetIndex = (diffIndex == -1) ? sameIndex : diffIndex;
                    System.out.println(targetIndex + 1);
                    queries++;
                    if (scanner.nextInt() != bits[targetIndex]) {
                        complementArray(bits, i);
                    }
                } else {
                    System.out.println(sameIndex + 1);
                    queries++;
                    boolean sameChanged = scanner.nextInt() != bits[sameIndex];

                    System.out.println(diffIndex + 1);
                    queries++;
                    boolean diffChanged = scanner.nextInt() != bits[diffIndex];

                    if (diffChanged && sameChanged) {
                        complementArray(bits, i);
                    } else if (diffChanged) {
                        reverseArray(bits, i);
                    } else if (sameChanged) {
                        complementAndReverseArray(bits, i);
                    }
                }
            }

            System.out.println(i + 1);
            queries++;
            bits[i] = scanner.nextInt();

            System.out.println(bitLength - i);
            queries++;
            bits[bitLength - i - 1] = scanner.nextInt();

            if (diffIndex == -1 && bits[i] != bits[bitLength - i - 1]) {
                diffIndex = i;
            }
            if (sameIndex == -1 && bits[i] == bits[bitLength - i - 1]) {
                sameIndex = i;
            }
        }

        System.out.println(Arrays.toString(bits));

        return "Y".equals(scanner.next());
    }

    private static void complementArray(int[] array, int len) {
        for (int left = 0, right = array.length - 1; left <= len; left++, right--) {
            array[left] = array[left] == 0 ? 1 : 0;
            array[right] = array[right] == 0 ? 1 : 0;
        }
    }

    private static void reverseArray(int[] array, int len) {
        for (int left = 0, right = array.length - 1; left <= len; left++, right--) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    private static void complementAndReverseArray(int[] array, int len) {
        for (int left = 0, right = array.length - 1; left <= len; left++, right--) {
            int temp = array[left] == 0 ? 1 : 0;
            array[left] = array[right] == 0 ? 1 : 0;
            array[right] = temp;
        }
    }
}