import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            int[] numbers = new int[N];
            for (int j = 0; j < N; j++) {
                numbers[j] = scanner.nextInt();
            }
            scanner.nextLine();
            solve(i, N, numbers);
        }
    }

    private static void solve(int testCase, int N, int[] arr) {
        String[] workArr = new String[N];
        System.out.println(Arrays.toString(arr));
        String first = "C";
        String second = "J";

        if (arr[1] <= arr[2]) {
            workArr[0] = first;
            workArr[1] = first;
        } else {
            workArr[0] = first;
            workArr[1] = second;
            String temp = first;
            first = second;
            second = temp;
        }

        int workerArrIndex = 2;
        for (int i = 2; i < arr.length - 2; i++) {
            workArr[workerArrIndex] = (arr[i + 1] <= arr[i + 2]) ? first : second;
            i++;
            if (workerArrIndex == N - 1) {
                break;
            }
            workerArrIndex++;
        }

        System.out.println("Case #" + testCase + ": " + Arrays.toString(workArr));
    }
}