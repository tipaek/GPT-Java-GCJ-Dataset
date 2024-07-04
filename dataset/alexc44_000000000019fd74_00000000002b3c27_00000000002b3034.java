import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int cases = 0;
        if(scanner.hasNextLine()) {
            cases = Integer.parseInt(scanner.nextLine());
        }
        for(int i = 0; i < cases; i++) {
            int curr = scanner.nextInt();
            System.out.println("Case #" + Integer.toString(i+1) + ": " + output(scanner, curr));
        }
    }

    public static String output(Scanner scanner, int len) {
        String pattern = "";
        boolean valid = true;

        for(int i = 0; i < len; i++) {
            String curr = scanner.nextLine().substring(1, curr.length());
            if (pattern.equals("")) {
                pattern = curr;
            }
            else {
                String s = "";
                String l = "";
                if(curr.length() > pattern.length()) {
                    l = curr;
                    s = pattern;
                }
                else {
                    s = curr;
                    l = pattern;
                }
                for(int j = 0; j < s.length(); j++) {
                    if(s.charAt(s.length()-j-1) != l.charAt(l.length()-j-1)) {
                        return "*";
                    }
                }
                pattern = l;
            }
        }
        return pattern;
    }
}