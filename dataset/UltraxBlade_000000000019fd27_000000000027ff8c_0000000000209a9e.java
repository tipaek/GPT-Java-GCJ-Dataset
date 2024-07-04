import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int B = in.nextInt();
        int[] arr = new int[B];
        for (int testCase = 1; testCase <= T; testCase++) {
            int symmetry = -1;
            int asymmetry = -1;
            int i = 0;
            int j = B - 1;
            int query = 0;
            while (i <= j && query < 150) {
                query++;
                if (query % 10 == 1 && query > 1) {
                    System.out.println(symmetry);
                    int s = in.nextInt();
                    query++;
                    System.out.println(asymmetry);
                    int a = in.nextInt();
                    if (arr[symmetry] != s) {
                        flipBits(arr);
                    }
                    if (arr[asymmetry] != a) {
                        reverse(arr);
                    }
                } else {
                    System.out.println(i);
                    arr[i] = in.nextInt();
                    query++;
                    System.out.println(j);
                    arr[j] = in.nextInt();
                    if (symmetry == -1 && arr[i] == arr[j]) {
                        symmetry = i;
                    } else if (asymmetry == -1 && arr[i] != arr[j]) {
                        asymmetry = i;
                    }
                    i++;
                    j--;
                }
            }
            String s = "";
            for (int bit : arr) {
                s += bit;
            }
            System.out.println(s);
            if (in.next().equals("N")) {
                break;
            }
        }
    }

    private static void flipBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }
    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
