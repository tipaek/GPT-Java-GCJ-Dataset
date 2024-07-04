import java.util.Scanner;

public class Solution {

    private static String getResult(String s) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;
        int closedBrackets = 0;
        int i = 0;
        while(i < s.length()) {
            int num = Character.getNumericValue(s.charAt(i));
            if(openBrackets == closedBrackets) {
                for(int j = 0; j < num; j++) {
                    result.append("(");
                    openBrackets++;
                }
                i++;
                result.append(num);
            } else {
                int open = openBrackets - closedBrackets;
                if(num == open) {
                    result.append(num);
                    i++;
                } else if(num < open) {
                    result.append(")");
                    closedBrackets++;
                } else {
                    for(int j = 0; j < num - open; j++) {
                        result.append("(");
                        openBrackets++;
                    }
                    result.append(num);
                    i++;
                }
            }
        }
        // close remaining brackets
        for(int j = 0; j < openBrackets - closedBrackets; j++) {
            result.append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        s.nextLine();
        for(int i = 0; i < t; i++) {
            String string = s.nextLine();
            System.out.println(String.format("Case #%d: %s", i + 1, getResult(string)));
        }
    }
}
