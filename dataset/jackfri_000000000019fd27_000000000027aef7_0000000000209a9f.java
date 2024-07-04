import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            String s = in.next();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int ind = 0; ind < s.length(); ind++) {
                list.add(Integer.parseInt(Character.toString(s.charAt(ind))));
            }
            String output = "";
            for (int ind = 0; ind < s.length(); ind++) {
                for (int ind2 = list.get(ind); ind2 > 0; ind2--) {
                    if (output.length() != 0 && output.charAt(output.length() - 1) == ')')
                        output = output.substring(0, output.length() - 1);
                    else
                        output += "(";
                }
                output += list.get(ind);
                for (int ind2 = list.get(ind); ind2 > 0; ind2--) {
                    output += ")";
                }
            }
            System.out.println("Case #" + (i+1) + ": " + output);
        }
    }
}