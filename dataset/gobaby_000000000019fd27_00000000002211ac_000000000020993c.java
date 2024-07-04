import java.util.Scanner;

public class Problem1 {
    private static final int MAX_NUM = 101;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testTotalCount = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testTotalCount; testCase++) {
            int arrSize = Integer.parseInt(scanner.nextLine());
            int[][] arr = new int[arrSize][arrSize];
            for (int i = 0; i < arrSize; i++) {
                String line = scanner.nextLine();
                if (line == null || line.length() == 0) {
                    return;
                }

                String temp[] = line.split(" ");
                for (int j = 0; j < temp.length; j++) {
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }

            System.out.println(new String().format("Case #%s: %s %s %s",
                    testCase, findTraceSum(arr), findRowRepeatCount(arr), findColumnRepeatCount(arr)));
        }
    }

    public static int findTraceSum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }

        return sum;
    }

    //가로
    public static int findRowRepeatCount(int[][] arr) {
        int repeatCount = 0;
        for (int i = 0; i < arr.length; i++) {

            boolean check[] = new boolean[MAX_NUM];
            for (int j = 0; j < arr.length; j++) {
                if (check[arr[i][j]]) {
                    repeatCount++;
                    break;
                } else {
                    check[arr[i][j]] = true;
                }
            }
        }

        return repeatCount;
    }

    //세로
    public static int findColumnRepeatCount(int[][] arr) {
        int repeatCount = 0;
        for (int i = 0; i < arr.length; i++) {

            boolean check[] = new boolean[MAX_NUM];
            for (int j = 0; j < arr.length; j++) {
                if (check[arr[j][i]]) {
                    repeatCount++;
                    break;
                } else {
                    check[arr[j][i]] = true;
                }
            }
        }

        return repeatCount;
    }
}
