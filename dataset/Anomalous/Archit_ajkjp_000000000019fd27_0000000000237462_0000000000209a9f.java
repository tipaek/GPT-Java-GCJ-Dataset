import java.util.Scanner;

public class CodeJam2020_NestingDepth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            String k = sc.next();
            StringBuilder result = new StringBuilder();

            int currentDepth = 0;
            for (int j = 0; j < k.length(); j++) {
                int digit = Character.getNumericValue(k.charAt(j));
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digit);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println(result.toString());
        }

        sc.close();
    }
}