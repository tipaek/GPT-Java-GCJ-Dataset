import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();
        for (int i = 0; i < numCase; i++) {
            String numStr = in.next();

            StringBuilder result = new StringBuilder("");
            for (int j = 0; j < Integer.parseInt(numStr.charAt(0) + ""); j++) {
                result.append('(');
            }
            for (int j = 0; j + 1 < numStr.length(); j++) {
                result.append(numStr.charAt(j));

                if (Integer.parseInt(numStr.charAt(j + 1) + "") - Integer.parseInt(numStr.charAt(j) + "") >= 0) {
                    int difference = Integer.parseInt(numStr.charAt(j + 1) + "")
                            - Integer.parseInt(numStr.charAt(j) + "");

                    for (int k = 0; k < difference; k++)
                        result.append('(');
                } else {
                    int diff = Integer.parseInt(numStr.charAt(j) + "") - Integer.parseInt(numStr.charAt(j + 1) + "");

                    for (int k = 0; k < diff; k++)
                        result.append(')');
                }
            }
            result.append(numStr.charAt(numStr.length() - 1) + "");
            for (int j = 0; j < Integer.parseInt(numStr.charAt(numStr.length() - 1) + ""); j++)
                result.append(')');

            System.out.println("Case #" + (i + 1) + ": " + result);
        }

    }
}
