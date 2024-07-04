import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int[] arr = new int[B];
            for (int j = 0; j < B; j++) {
                System.out.println(j);
                arr[j] = sc.nextInt();
            }

            for (int v : arr)
                System.out.print(v);

            System.out.println();
        }
    }
}
