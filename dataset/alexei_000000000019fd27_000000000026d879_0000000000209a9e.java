import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for (int c = 1; c <= t ; c++) {
            System.err.println("Test " + c);
            int arr[] = new int[b];
            for (int i = 0; i < b; i++) {
                arr[i] = 2;
            }
            int offset = 0;
            int remaining = 10;

            while(true) {
                System.err.println("Starting loop");
                System.err.println(Arrays.toString(arr));

                while (remaining > 1 && offset <= b / 2) {
                    System.out.println("" + (offset + 1));
                    remaining--;
                    arr[offset] = in.nextInt();
                    System.err.println("Wrote " + arr[offset] + " to pos " + offset);

                    System.out.println("" + (b - offset));
                    remaining--;
                    arr[b - offset - 1] = in.nextInt();
                    System.err.println("Wrote " + arr[b - offset - 1] + " to pos " + (b - offset - 1));
                    offset++;
                    System.err.println("Remaining " + remaining + " offset " + offset);
                }
                if (offset > b/2) {
                    StringBuilder sb = new StringBuilder();
                    for (int i: arr) {
                        sb.append(i);
                    }
                    System.out.println(sb.toString());
                    String s = in.next();
                    if (s.equals("Y")) {
                        break;
                    } else {
                        throw new RuntimeException(s);
                    }
                }
                while (remaining > 0) {
                    System.out.println("" + offset);
                    remaining--;
                    System.err.println("Remaining" + remaining);
                }

                System.err.println("New info");
                System.err.println(Arrays.toString(arr));

                remaining = 10;
                int[][] options = generate(arr);
                List<int[]> opts = new ArrayList<>();

                System.err.println("Generated options");
                for (int[] option : options) {
                    opts.add(option);
                    System.err.println(Arrays.toString(option));
                }

                while (opts.size() > 1) {
                    int xor = xor(opts.get(0), opts.get(1));
                    if (xor == -1) {
                        System.err.println("Two similar arrays, removing one");
                        opts.remove(0);
                        continue;
                    }
                    System.out.println("" + (xor + 1));
                    remaining--;
                    System.err.println("Remaining" + remaining);
                    int xored = in.nextInt();
                    System.err.println("Checked " + xor + " received " + xored);
                    List<int[]> toRemove = new ArrayList<>();
                    for (int[] op : opts) {
                        if (op[xor] != xored) {
                            toRemove.add(op);
                        }
                    }
                    opts.removeAll(toRemove);
                }
                arr = opts.get(0);
            }
        }

    }

    private static int xor(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == 2) continue;
            if (a1[i] != a2[i]) return i;
        }
        return -1;
    }

    private static int[][] generate(int[] arr) {
        int[][] res = new int[4][];
        res[0] = Arrays.copyOf(arr, arr.length);
        res[1] = new int[arr.length];
        res[2] = new int[arr.length];
        res[3] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) res[1][i] = 0;
            else if (arr[i] == 0) res[1][i] = 1;
            else if (arr[i] == 2) res[1][i] = 2;
            res[2][arr.length-1-i] = res[0][i];
            res[3][arr.length-1-i] = res[1][i];
        }
        return res;
    }
}