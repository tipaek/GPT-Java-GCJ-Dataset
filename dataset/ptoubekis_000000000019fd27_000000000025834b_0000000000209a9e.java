import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private final static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private final static int ALL_DIFFERENT = 0;
    private final static int YES = 1;
    private final static int NO = 2;

    public static void main(String[] args) {
        int cases = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            foo(b);
        }
    }

    private static void foo(int b) {
        int known = 0;
        int[] data = new int[b];
        Arrays.fill(data, -1);
        for (int i = 0; i < 15; i++) {
            int queries = 0;
            if (known > 0) {
                int changed = ALL_DIFFERENT;
                for (int j = 0; j < known; j++) {
                    if (data[j] == data[b - j - 1]) {
                        int bit = askForBit(j);
                        queries++;
                        if (bit == data[j]) {
                            changed = NO;
                        } else {
                            changed = YES;
                        }
                        break;
                    }
                }
                if (changed == ALL_DIFFERENT) {
                    int bit = askForBit(0);
                    queries++;
                    if (bit != data[0]) {
                        reverse(data);
                    }
                } else {
                    if (changed == YES) {
                        change(data);
                    }
                    for (int j = 0; j < known; j++) {
                        if (data[j] != data[b - j - 1]) {
                            int bit = askForBit(j);
                            queries++;
                            if (bit != data[j]) {
                                reverse(data);
                            }
                            break;
                        }
                    }
                }
            }
            while (queries <= 8 && known < b / 2) {
                data[known] = askForBit(known);
                data[b - known - 1] = askForBit(b - known - 1);
                known++;
                queries += 2;
            }
            if (queries == 9) {
                askForBit(0);
                queries++;
            }
            if (known == b / 2) {
                for (int k = 0; k < b; k++) {
                    System.out.print(data[k]);
                }
                System.out.println();
                String s = in.next();
                if (s.equals("Y")) {
                    return;
                } else {
                    System.exit(0);
                }
            }
        }
    }

    private static int askForBit(int p) {
        System.out.println(p + 1);
        int b = in.nextInt();
        return b;
    }

    private static void reverse(int[] list) {
        for (int i = 0; i < list.length / 2; i++) {
            int temp = list[i];
            list[i] = list[list.length - i - 1];
            list[list.length - i - 1] = temp;
        }
    }

    private static void change(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 1) {
                list[i] = 0;
            } else if (list[i] == 0) {
                list[i] = 1;
            }
        }
    }

}
