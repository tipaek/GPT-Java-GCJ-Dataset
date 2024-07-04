import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.hasNextInt() ? sc.nextInt() : 0;

        for (int i = 0; i < t; i++) {
            int n = sc.hasNextInt() ? sc.nextInt() : 0;
            char[] arr = new char[n];
            int minc = -1, maxc = -1, minj = -1, maxj = -1;

            boolean isImpossible = false;

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (start >= maxc || end <= minc) {
                    arr[j] = 'C';
                    minc = start;
                    maxc = end;
                } else if ((start >= maxj || end <= minj) && start < maxc && start > minc) {
                    arr[j] = 'J';
                    minj = start;
                    maxj = end;
                } else {
                    arr[j] = 'A';
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(arr));
            }
        }
    }
}