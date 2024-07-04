import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int[] arr = new int[b];
            int k = 1;

            while (k <= 100) {
                System.out.println(k);
                arr[k - 1] = scanner.nextInt();

                if (k == b) {
                    System.out.println(Arrays.toString(arr));
                    char response = scanner.next().charAt(0);
                    if (response == 'N') {
                        System.exit(0);
                    }
                } else if (k % 10 == 1 && k != 1) {
                    System.exit(0);
                }
                k++;
            }
        }
    }
}