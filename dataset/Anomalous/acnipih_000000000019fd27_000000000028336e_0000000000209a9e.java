import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader);

        int t = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int[] arr = new int[b];
            Arrays.fill(arr, -1);
            int[] resultArray = processArray(arr, scanner);
            String resultString = Arrays.stream(resultArray)
                                        .mapToObj(String::valueOf)
                                        .collect(Collectors.joining(""));
            System.out.println(resultString);
            String result = scanner.next();
            if (result.equals("N")) return;
        }
    }

    private static int[] processArray(int[] arr, Scanner scanner) {
        int start = 0;
        int end = arr.length - 1;
        int step = 1;
        int n = arr.length;

        while (true) {
            if (start > end) {
                boolean isComplete = true;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == -1) {
                        if (step % 10 == 1) {
                            isComplete = false;
                            break;
                        }
                        System.out.println(i + 1);
                        arr[i] = scanner.nextInt();
                        step++;
                    }
                }
                if (isComplete) return arr;
            }

            if (step > 1 && step % 10 == 1) {
                int x = -1;
                int y = -1;
                for (int i = 0; i < end; i++) {
                    if (arr[i] == arr[n - i - 1] && arr[i] != -1 && x == -1) x = i;
                    if (y == -1 && arr[i] != -1 && arr[n - i - 1] != -1 && arr[i] != arr[n - i - 1]) y = i;
                    if (x >= 0 && y >= 0) break;
                }
                if (y == -1) {
                    handleSingleChange(scanner, arr, x);
                } else if (x == -1) {
                    handleSingleChange(scanner, arr, y);
                } else {
                    handleDoubleChange(scanner, arr, x, y);
                    step++;
                }
            } else {
                handleRegularChange(scanner, arr, start, end, step);
                step++;
            }
        }
    }

    private static void handleSingleChange(Scanner scanner, int[] arr, int index) {
        System.out.println(index + 1);
        int val = scanner.nextInt();
        if (val != arr[index]) {
            flipArray(arr);
        }
    }

    private static void handleDoubleChange(Scanner scanner, int[] arr, int x, int y) {
        System.out.println(x + 1);
        int valX = scanner.nextInt();
        System.out.println(y + 1);
        int valY = scanner.nextInt();
        boolean flip = valX != arr[x];
        boolean reverse = (valY == arr[y] && flip) || (valY != arr[y] && !flip);
        if (flip) {
            flipArray(arr);
        }
        if (reverse) {
            reverseArray(arr);
        }
    }

    private static void handleRegularChange(Scanner scanner, int[] arr, int start, int end, int step) {
        if (step % 2 == 1) {
            System.out.println(start + 1);
            arr[start++] = scanner.nextInt();
        } else {
            System.out.println(end + 1);
            arr[end--] = scanner.nextInt();
        }
    }

    private static void flipArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                arr[i] = (arr[i] + 1) % 2;
            }
        }
    }

    private static void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
}