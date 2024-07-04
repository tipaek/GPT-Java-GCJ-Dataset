import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        
        int T = 0, b = 0;
        StringBuilder numberBuilder = new StringBuilder();
        
        for (char ch : inputData.toCharArray()) {
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

        for (int testCase = 1; testCase <= T; testCase++) {
            int[] arr = new int[b + 1];
            Arrays.fill(arr, -5);
            int queryCount = 0;
            String responseStr;
            int response = -1, feedback = -1;
            int mark1 = -1, mark2 = -1;

            for (int i = 1; i <= b / 2; i++) {
                if (queryCount > 0 && queryCount % 10 == 0) {
                    response = -1;
                    feedback = -1;

                    if (mark1 != -1) {
                        System.out.println(mark1);
                        responseStr = scanner.next();
                        if (responseStr.charAt(0) != 'N') {
                            response = responseStr.charAt(0) - '0';
                        }
                        queryCount++;
                    }

                    if (mark2 != -1) {
                        System.out.println(mark2);
                        responseStr = scanner.next();
                        if (responseStr.charAt(0) != 'N') {
                            feedback = responseStr.charAt(0) - '0';
                        }
                        queryCount++;
                    }

                    if (response == arr[mark1]) {
                        if (mark2 == -1 || feedback == arr[mark2]) {
                            // Do nothing
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
                            // Do nothing
                        } else {
                            reverse(arr);
                        }
                    }
                }

                System.out.println(i);
                responseStr = scanner.next();
                if (responseStr.charAt(0) != 'N') {
                    response = responseStr.charAt(0) - '0';
                }
                arr[i] = response;

                System.out.println(b - i + 1);
                responseStr = scanner.next();
                if (responseStr.charAt(0) != 'N') {
                    response = responseStr.charAt(0) - '0';
                }
                arr[b - i + 1] = response;

                if (mark1 == -1 && arr[i] == arr[b - i + 1]) {
                    mark1 = i;
                }
                if (mark2 == -1 && arr[i] != arr[b - i + 1]) {
                    mark2 = i;
                }
                queryCount += 2;
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= b; i++) {
                result.append(arr[i]);
            }
            System.out.println(result.toString());
            String finalResponse = scanner.next();
            if (finalResponse.charAt(0) == 'N') {
                System.exit(0);
            }
        }
    }

    static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 1; i <= n / 2; i++) {
            if (arr[i] == -5) {
                return;
            }
            int temp = arr[i];
            arr[i] = arr[n - i];
            arr[n - i] = temp;
        }
    }

    static void complement(int[] arr) {
        int n = arr.length;
        for (int i = 1; i <= n / 2; i++) {
            if (arr[i] == -5) {
                return;
            }
            arr[i] = 1 - arr[i];
            arr[n - i] = 1 - arr[n - i];
        }
    }

    static void complementAndReverse(int[] arr) {
        complement(arr);
        reverse(arr);
    }
}