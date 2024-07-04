import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split("");
            StringBuilder result = new StringBuilder();
            int opened = 0;

            for (int j = 0; j < input.length; j++) {
                int num = Integer.parseInt(input[j]);
                int diff = num - opened;
                if (diff > 0) {
                    for (int k = 0; k < diff; k++) {
                        result.append("(");
                    }
                } else if (diff < 0) {
                    for (int k = 0; k < -1 * diff; k++) {
                        result.append(")");
                    }
                }

                result.append(num);
                opened += diff;
            }

            for (int k = 0; k < opened; k++) {
                result.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}
