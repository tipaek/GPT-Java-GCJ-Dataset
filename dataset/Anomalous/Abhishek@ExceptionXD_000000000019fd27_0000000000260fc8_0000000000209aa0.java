import java.util.Scanner;

public class Solution {

    public static void rotate(int[] array) {
        int length = array.length;
        int lastElement = array[length - 1];
        for (int i = length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = lastElement;
        for (int value : array) {
            System.out.print(value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int max = N * N;

            if ((K % N != 0) || (K > max)) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                break;
            } else {
                int value = K / N;
                int increment = value + 1;
                int count = 1;
                int threshold = N - increment;
                int[] tempArray = new int[N];
                int index;

                for (index = 0; index <= threshold; index++) {
                    tempArray[index] = increment++;
                }
                for (int k = index; k < N; k++) {
                    tempArray[k] = count++;
                }

                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int p = 1; p <= N; p++) {
                    rotate(tempArray);
                    System.out.println();
                }
            }
        }
    }
}