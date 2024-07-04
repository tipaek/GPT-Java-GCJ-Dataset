import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int T = 0, b = 0;
        StringBuilder numberBuilder = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                numberBuilder.append(ch);
            } else if (numberBuilder.length() > 0) {
                if (T == 0) {
                    T = Integer.parseInt(numberBuilder.toString());
                    numberBuilder.setLength(0);
                } else {
                    b = Integer.parseInt(numberBuilder.toString());
                    break;
                }
            }
        }

        if (b == 0) {
            b = Integer.parseInt(numberBuilder.toString());
        }

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int[] arr = new int[b + 1];
            Arrays.fill(arr, -5);
            int queryCount = 0;
            int response = -1, feedback = -1;
            int mark1 = -1, mark2 = -1;

            for (int i = 1; i <= b / 2; i++) {
                if (queryCount > 0 && queryCount % 10 == 0) {
                    response = -1;
                    feedback = -1;
                    if (mark1 != -1) {
                        System.out.println(mark1);
                        response = getResponse(scanner);
                        queryCount++;
                    }
                    if (mark2 != -1) {
                        System.out.println(mark2);
                        feedback = getResponse(scanner);
                        queryCount++;
                    }

                    if (response == arr[mark1]) {
                        if (mark2 == -1 || feedback == arr[mark2]) {
                            // do nothing
                        } else {
                            reverse(arr);
                        }
                    } else if (response != -1 && response != arr[mark1]) {
                        if (mark2 == -1 || feedback != arr[mark2]) {
                            complement(arr);
                        } else {
                            complementAndReverse(arr);
                        }
                    } else {
                        if (feedback == arr[mark2]) {
                            // do nothing
                        } else {
                            reverse(arr);
                        }
                    }
                }

                System.out.println(i);
                arr[i] = getResponse(scanner);
                System.out.println(b - i + 1);
                arr[b - i + 1] = getResponse(scanner);

                if (mark1 == -1 && arr[i] == arr[b - i + 1]) {
                    mark1 = i;
                }
                if (mark2 == -1 && arr[i] != arr[b - i + 1]) {
                    mark2 = i;
                }
                queryCount += 2;
            }

            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 1; i <= b; i++) {
                resultBuilder.append(arr[i]);
            }
            System.out.println(resultBuilder.toString());

            String result = scanner.next();
            if (result.charAt(0) == 'N') {
                System.exit(0);
            }
        }
    }

    private static int getResponse(Scanner scanner) {
        String str = scanner.next();
        if (str.charAt(0) != 'N') {
            return str.charAt(0) - '0';
        }
        return -1;
    }

    private static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 1; i <= n / 2; i++) {
            if (arr[i] == -5) return;
            int temp = arr[i];
            arr[i] = arr[n - i];
            arr[n - i] = temp;
        }
    }

    private static void complement(int[] arr) {
        int n = arr.length;
        for (int i = 1; i <= n / 2; i++) {
            if (arr[i] == -5) return;
            arr[i] = 1 - arr[i];
            arr[n - i] = 1 - arr[n - i];
        }
    }

    private static void complementAndReverse(int[] arr) {
        complement(arr);
        reverse(arr);
    }
}