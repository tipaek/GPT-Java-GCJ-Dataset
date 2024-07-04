import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < T; t++) {
            String str = scanner.nextLine();
            String result = nestingDepth(str);
            System.out.println("Case #" + (t+1) + ": " + result);
        }
    }

    private static String nestingDepth(String str) {
        StringBuilder result = new StringBuilder();

        int lastChar = 0;
        for (int i = 0; i < str.length(); i++){
            int currChar = Character.getNumericValue(str.charAt(i));
            if (currChar > lastChar){
                int diff = currChar - lastChar;
                for (int j = 0; j < diff; j++){
                    result.append("(");
                }
            } else if (currChar < lastChar){
                int diff = lastChar - currChar;
                for (int j = 0; j < diff; j++){
                    result.append(")");
                }
            }
            lastChar = currChar;
            result.append(currChar);
        }
        for (int i = 0; i < lastChar; i++){
            result.append(")");
        }
        return result.toString();
    }
}
