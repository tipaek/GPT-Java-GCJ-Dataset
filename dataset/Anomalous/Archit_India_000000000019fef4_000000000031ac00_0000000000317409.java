import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String s = scanner.next();
            int length = s.length();
            String result = "IMPOSSIBLE";
            int[] steps = new int[length];
            int top = -1;

            if (Math.abs(X) + Math.abs(Y) <= 0) {
                steps[++top] = 1;
            }

            for (int j = 0; j < length; j++) {
                char direction = s.charAt(j);
                switch (direction) {
                    case 'N':
                        Y++;
                        break;
                    case 'S':
                        Y--;
                        break;
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                }

                if (Math.abs(X) + Math.abs(Y) <= j + 1) {
                    steps[++top] = j + 1;
                }
            }

            int minSteps = Integer.MAX_VALUE;
            for (int j = 0; j <= top; j++) {
                if (minSteps > steps[j]) {
                    minSteps = steps[j];
                }
            }

            if (top != -1) {
                result = Integer.toString(minSteps);
            }

            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}