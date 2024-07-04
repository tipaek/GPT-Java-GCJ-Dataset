import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            String[] arr = new String[N];
            String maxString = "";
            int maxLength = -1;

            for (int j = 0; j < N; j++) {
                arr[j] = scanner.next();
                if (arr[j].length() > maxLength) {
                    maxLength = arr[j].length();
                    maxString = arr[j];
                }
            }

            // You can add any further processing or output here if needed
        }
        
        scanner.close();
    }
}