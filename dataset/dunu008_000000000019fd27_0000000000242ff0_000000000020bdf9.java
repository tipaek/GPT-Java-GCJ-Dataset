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
        int workerArrIndex = 0;
        int firstmin = 0;
        int firstmax = 0;
        int secondmin = 0;
        String first = "C";
        String second = "J";
        boolean imp = false;

        if (arr[1] <= arr[2]) {             //smaller
            workArr[0] = first;
            workArr[1] = first;
            firstmin = arr[1];
            firstmax = arr[2];
        } else if (arr[0] > arr[3]) {       //both larger
            workArr[0] = first;
            workArr[1] = first;
            firstmin = arr[2];
            firstmax = arr[1];
        } else {
            workArr[0] = first;
            workArr[1] = second;
            firstmin = arr[0];
            firstmax = arr[1];
            secondmin = arr[2];
        }
        workerArrIndex = 2;


        for (int i = 2; i < arr.length - 2; i++) {
            if (arr[i + 1] == arr[i + 2]) {
                workArr[workerArrIndex] = workArr[workerArrIndex - 1];
                if (workArr[workerArrIndex] == "C"){
                    firstmax = arr[i + 3];
                }
            } else if (arr[i + 1] < arr[i + 2] && firstmax <= arr[i + 3]) {
                firstmax = arr[i + 3];
                workArr[workerArrIndex] = first;
            } else if (arr[i + 1] > arr[i + 2] && firstmin >= arr[i + 2]) {
                firstmin = arr[i + 2];
                workArr[workerArrIndex] = first;
            } else if (arr[i + 1] > arr[i + 2] && secondmin >= arr[i + 3]) {
                secondmin = arr[i + 3];
                workArr[workerArrIndex] = second;
            } else {
                imp = true;
                break;
            }
            i++;
            if (workerArrIndex == N - 1) {
                break;
            }
            workerArrIndex++;
        }
        if (!imp) {
            System.out.println("Case #" + testCase + ": " + Arrays.toString(workArr));
        } else {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        }

    }

    public static Scanner createScaner() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return sc;
    }
}