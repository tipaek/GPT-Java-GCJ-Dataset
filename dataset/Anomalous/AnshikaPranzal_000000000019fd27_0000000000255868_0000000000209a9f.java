import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline after the integer input

        for (int i = 0; i < t; i++) {
            String a = sc.nextLine();
            char[] chArray = a.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (char ch : chArray) {
                int num = Character.getNumericValue(ch);
                for (int j = 0; j < num; j++) {
                    sb.append('(');
                }
                sb.append(ch);
                for (int j = 0; j < num; j++) {
                    sb.append(')');
                }
            }

            String result = sb.toString();
            while (result.contains(")(")) {
                result = result.replace(")(", "");
            }

            System.out.println(result);
        }
    }
}