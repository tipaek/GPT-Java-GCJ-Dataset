import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int[] arr = new int[b];
            for (int k = 1; k <= b; k++) {
                System.out.println(k);
                arr[k - 1] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr));
            char ok = scanner.next().charAt(0);
            if (ok == 'Y' || ok == 'y') {
                System.exit(0);
            }
        }
    }
}