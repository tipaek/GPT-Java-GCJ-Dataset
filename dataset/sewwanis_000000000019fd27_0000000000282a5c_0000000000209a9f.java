
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int t = 0; t < T; t++) {
            String S = scan.nextLine();
            if (Objects.equals(S, "")) {
                S = scan.nextLine();
            }
            StringBuilder result = new StringBuilder();
            int preValue = 0;
            for (int i = 0; i < S.length(); i++) {
                int value = Integer.parseInt(String.valueOf(S.charAt(i)));

                if (preValue == value) {
                    
                } else if (preValue > value) {
                    for (int j = 0; j < preValue - value; j++) {
                        result.append(")");
                    }
                } else if (preValue < value) {
                    for (int j = 0; j < value - preValue; j++) {
                        result.append("(");
                    }
                }
                result.append(value);
                preValue = value;
            }
            for(int j=0;j<preValue;j++) {
                result.append(")");
            }
            int j = t + 1;
            System.out.println("Case #" + j + ": " + result);
        }
    }
}
