import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);

        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            String s = in.next();

            int[] arr  = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i) - '0';
            }

            int openP = 0;
            String result = "";
            for (int i = 0; i < arr.length; i++) {
                while (openP - arr[i] > 0) { // i have more open than i need
                    result += ")";
                    openP--;
                }

                while (openP - arr[i] < 0) { // i need more open parenthesis
                    result += "(";
                    openP++;
                }

                result += arr[i];

            }

            while (openP > 0) { // i have more open than i need
                result += ")";
                openP--;
            }

            System.out.println(String.format("Case #%d: %s", (t+1), result));

        }
    }
}
