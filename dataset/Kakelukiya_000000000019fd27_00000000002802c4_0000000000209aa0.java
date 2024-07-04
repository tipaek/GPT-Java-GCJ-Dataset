import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int mSize = in.nextInt();
            int trace = in.nextInt();

            int[][] template = new int[mSize][mSize];

            for (int row = 0; row < mSize; row++) {
                for (int col = 0; col < mSize; col++) {
                    template[row][col] = Math.floorMod((col - row), mSize) + 1;
                }
            }

            int[] mapping = new int[mSize + 1];
            for (int iMap = 0; iMap < mapping.length; iMap++) {
                mapping[iMap] = iMap;
            }

            boolean possible = false;
            boolean flip = false;
            if (trace % mSize == 0) {
                int target = trace / mSize;
                mapping[1] = target;
                mapping[target] = 1;
                possible = true;
            } else if (mSize % 2 == 0) {
                // evens
                int[] digits = new int[mSize / 2];
                int sum = 0;
                for (int k = 0; k < digits.length; k++) {
                    digits[k] = k + 1;
                    sum += k + 1;
                }

                int index = digits.length - 1;
                while (index >= 0) {
                    if (sum * 2 == trace) {
                        // found target break
                        break;
                    } else {
                        // increment
                        sum++;
                        if (digits[index] == index + (mSize / 2) + 1) {
                            index--;
                        }
                        if (index != -1) {
                            digits[index]++;
                        }
                    }
                }

                if (index != -1) {
                    possible = true;

                    Set<Integer> diagDigits = new HashSet<>();
                    for (int d = 2; d <= mSize; d += 2) {
                        diagDigits.add(d);
                    }

                    // preserve evens in set
                    for (int k = 0; k < digits.length; k++) {
                        int num = digits[k];
                        if (num % 2 == 0) {
                            diagDigits.remove(num);
                        }
                    }

                    // change mapping
                    for (int k = 0; k < digits.length; k++) {
                        int num = digits[k];
                        if (num % 2 == 1) {
                            int freeEven = diagDigits.iterator().next();
                            mapping[freeEven] = num;
                            mapping[num] = freeEven;
                            diagDigits.remove(freeEven);
                        }
                    }
                    flip = true;
                }
            }

            if (possible) {
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                printArray(template, mapping, flip);
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
    }

    public static void printArray(int[][] array, int[] mapping, boolean flip) {
        if (flip) {
            for (int row = 0; row < array.length; row++) {
                for (int col = array.length - 1; col > 0; col--) {
                    System.out.print(mapping[array[row][col]] + " ");
                }
                System.out.println(mapping[array[row][0]]);
            }
        } else {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array.length - 1; col++) {
                    System.out.print(mapping[array[row][col]] + " ");
                }
                System.out.println(mapping[array[row][array.length - 1]]);
            }
        }
    }
}