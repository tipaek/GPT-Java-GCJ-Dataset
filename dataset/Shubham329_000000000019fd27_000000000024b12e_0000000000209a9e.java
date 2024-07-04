import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int[] arr = new int[B];
            for (int j = 0; j < B; j++) {
                System.out.println(j + 1);
                String s = sc.next();
                if (s.equals("N")) {
                    break;
                }
                arr[j] = Integer.parseInt(s);
            }

            for (int v : arr)
                System.out.print(v);

            System.out.println();
            sc.next();
        }
    }
}
