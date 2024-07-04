import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            int[] numbs = new int[N * 2];
            for (int j = 0; j < N; j++) {
                numbs[j * 2] = scanner.nextInt();
                numbs[j * 2 + 1] = scanner.nextInt();
                scanner.nextLine();
            }
            solve(i, N, numbs);
        }
    }

    private static void solve(int testCase, int N, int[] arr) {
        String[] workArr = new String[N];
        int firstMin = 0, firstMax = 0, secondMin = 0;
        String first = "C", second = "J";
        boolean impossible = false;

        if (arr[1] <= arr[2]) {
            workArr[0] = first;
            workArr[1] = first;
            firstMin = arr[1];
            firstMax = arr[2];
        } else if (arr[0] > arr[3]) {
            workArr[0] = first;
            workArr[1] = first;
            firstMin = arr[2];
            firstMax = arr[1];
        } else {
            workArr[0] = first;
            workArr[1] = second;
            firstMin = arr[0];
            firstMax = arr[1];
            secondMin = arr[2];
        }

        for (int i = 2; i < arr.length - 2; i += 2) {
            if (arr[i + 1] == arr[i + 2]) {
                workArr[i / 2] = workArr[(i / 2) - 1];
                if (workArr[i / 2].equals("C")) {
                    firstMax = arr[i + 3];
                }
            } else if (arr[i + 1] < arr[i + 2] && firstMax <= arr[i + 3]) {
                firstMax = arr[i + 3];
                workArr[i / 2] = first;
            } else if (arr[i + 1] > arr[i + 2] && firstMin >= arr[i + 2]) {
                firstMin = arr[i + 2];
                workArr[i / 2] = first;
            } else if (arr[i + 1] > arr[i + 2] && secondMin >= arr[i + 3]) {
                secondMin = arr[i + 3];
                workArr[i / 2] = second;
            } else {
                impossible = true;
                break;
            }
        }

        if (!impossible) {
            System.out.println("Case #" + testCase + ": " + String.join("", workArr));
        } else {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        }
    }
}