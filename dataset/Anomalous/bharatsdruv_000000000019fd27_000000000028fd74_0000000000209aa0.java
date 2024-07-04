import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int N = scanner.nextInt();
            int T = scanner.nextInt();
            String result = "";
            boolean isPossible = false;

            switch (N) {
                case 2:
                    if (T == 2) {
                        isPossible = true;
                        result = "1 2\n2 1";
                    } else if (T == 4) {
                        isPossible = true;
                        result = "2 1\n1 2";
                    }
                    break;
                case 3:
                    if (T == 3) {
                        isPossible = true;
                        result = "1 2 3\n3 1 2\n2 3 1";
                    } else if (T == 6) {
                        isPossible = true;
                        result = "2 1 3\n1 2 3\n3 1 2";
                    } else if (T == 9) {
                        isPossible = true;
                        result = "3 1 2\n2 3 1\n1 2 3";
                    }
                    break;
                case 4:
                    if (T == 4) {
                        isPossible = true;
                        result = "1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1";
                    } else if (T == 8) {
                        isPossible = true;
                        result = "2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2";
                    } else if (T == 12) {
                        isPossible = true;
                        result = "3 4 1 2\n2 3 4 1\n1 2 3 4\n4 1 2 3";
                    } else if (T == 16) {
                        isPossible = true;
                        result = "4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4";
                    }
                    break;
                case 5:
                    if (T == 5) {
                        isPossible = true;
                        result = "1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1";
                    } else if (T == 10) {
                        isPossible = true;
                        result = "2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2";
                    } else if (T == 15) {
                        isPossible = true;
                        result = "3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3";
                    } else if (T == 20) {
                        isPossible = true;
                        result = "4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4";
                    } else if (T == 25) {
                        isPossible = true;
                        result = "5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5";
                    }
                    break;
                default:
                    break;
            }

            System.out.print("Case #" + tc + ": ");
            if (isPossible) {
                System.out.println("POSSIBLE");
                System.out.println(result);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}