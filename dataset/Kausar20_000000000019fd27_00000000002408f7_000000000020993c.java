import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i, j, sum = 0;
        int case1 = 1;
        while (t-- > 0) {
            int size = sc.nextInt();
            int a[][] = new int[size][size];
            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {
                    a[i][j] = sc.nextInt();
                    if (i == j) {
                        sum = sum + a[i][j];
                    }
                }
            }

            int count1 = 0;
            for (i = 0; i < size; i++) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (j = 0; j < size; j++) {
                    if (arr.contains(a[i][j])) {
                        count1++;
                        break;
                    }
                    arr.add(a[i][j]);
                }
            }

            int count = 0;
            for (i = 0; i < size; i++) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (j = 0; j < size; j++) {
                    if (arr.contains(a[j][i])) {
                        count++;
                        break;
                    }
                    arr.add(a[j][i]);
                }
            }

            System.out.println("Case #" + case1 + ": " + sum + " " + count1 + " " + count);
            case1++;
            sum = 0;
        }
    }
}