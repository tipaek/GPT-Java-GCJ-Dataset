import java.util.Scanner;

public class CodeJam2020_NestingDepth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = sc.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            int requiredDepth;

            for (char ch : input.toCharArray()) {
                requiredDepth = Character.getNumericValue(ch);
                
                while (currentDepth < requiredDepth) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > requiredDepth) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(ch);
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