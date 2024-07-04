import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.hasNextInt() ? sc.nextInt() : 0;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            char[] arr = new char[n];
            int minC = -1, maxC = -1, minJ = -1, maxJ = -1;

            boolean isImpossible = false;

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (start >= maxC || end <= minC) {
                    arr[j] = 'C';
                    minC = start;
                    maxC = end;
                } else if (start >= maxJ || end <= minJ) {
                    arr[j] = 'J';
                    minJ = start;
                    maxJ = end;
                } else {
                    arr[j] = 'A';
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : new String(arr);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        sc.close();
    }
}