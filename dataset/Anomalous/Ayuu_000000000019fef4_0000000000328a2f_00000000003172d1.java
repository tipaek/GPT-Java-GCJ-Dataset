import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            int count = 0;
            int result = 0;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[j] == arr[k]) {
                        count++;
                    }
                }
            }

            if (count == d) {
                result = 0;
            } else if (arr.length == 1) {
                result = Math.abs(d - arr[0]);
            } else {
                for (int j = 0; j < n; j++) {
                    while (arr[j] % 2 == 0) {
                        result++;
                        arr[j] /= 2;
                    }
                    while (arr[j] % 3 == 0) {
                        result++;
                        arr[j] /= 3;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }

        sc.close();
    }
}