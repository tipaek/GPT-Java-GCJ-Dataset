import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < T; i++) {
            String str1 = scan.nextLine();
            char[] ar1 = str1.toCharArray();
            ArrayList<Character> ar2 = new ArrayList<>();
            int depth = 0;
            for (int j = 0; j < str1.length(); j++) {
                int curr = Integer.parseInt(String.valueOf(ar1[j]));
                if (depth < curr) {
                    ar2.add('(');
                    depth = depth + 1;
                    j = j - 1;
                    continue;
                }
                if (depth == curr) {
                    ar2.add(ar1[j]);
                }
                if (depth > curr) {
                    ar2.add(')');
                    depth = depth - 1;
                    j = j - 1;
                    continue;
                }
            }
            for (; depth > 0; depth--)
                ar2.add(')');
            String str2 = ar2.toString().substring(1, 3*ar2.size()-1).replaceAll(", ", "");
            System.out.println("Case #" + (i + 1) + ": " + str2);
        }
    }
}