import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = createScaner();

        int testCases;

        testCases = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= testCases; i++) {
            StringBuilder sb = new StringBuilder();
            int N = in.nextInt();
            in.nextLine();
            for (int a = 0; a < N; a++) {
                sb.append(in.nextLine());
                sb.append(" ");
            }
            int[] numbs = Arrays.stream(sb.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
            solve(i, N, numbs);
        }
    }

    private static void solve(int testCase, int N, int[] arr) {
        String[] workArr = new String[N];
        System.out.println(Arrays.toString(arr));
        int workerArrIndex = 0;
        int cmin = 0;
        int cmax = 0;
        int jmin = 0;
        int jmax = 0;
        String first = "C";
        String second = "J";

        if (arr[1] <= arr[2]) {
            workArr[0] = first;
            workArr[1] = first;
        } else {
            workArr[0] = first;
            workArr[1] = second;
            String tmp = first;
            first = second;
            second = tmp;
        }
        workerArrIndex = 2;


        for (int i = 2; i < arr.length - 2; i++) {
            if (arr[i + 1] <= arr[i + 2]) {
                workArr[workerArrIndex] = first;
            } else if (arr[i + 1] > arr[i + 2]) {
                workArr[workerArrIndex] = second;
            }
            i++;
            if (workerArrIndex == N - 1) {
                break;
            }
            workerArrIndex++;
        }
        System.out.println("Case #" + testCase + ": " + Arrays.toString(workArr));
    }

    public static Scanner createScaner() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return sc;
    }
}