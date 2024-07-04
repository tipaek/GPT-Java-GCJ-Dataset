import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            int openPar = 0;
            ArrayList<Character> list = new ArrayList<>();
            String num = input.next();
            String solution = "";
            int digitsleft = num.length();
            // System.out.println("digits: " + digitsleft);

            if (num.charAt(0) - '0' != 0) {
                for (int k = 0; k < num.charAt(0) - '0'; k++) {
                    list.add('(');
                    openPar++;
                    // System.out.println("1: " + solution + " " + openPar);
                }
                list.add(num.charAt(0));
                digitsleft--;
            } else {
                list.add('0');
                digitsleft--;
            }
            if (digitsleft == 0) {
                for (int k = 0; k < openPar; k++) {
                    list.add(')');
                    // System.out.println(solution + " " + openPar);
                }
            }
            for (int j = 1; j < num.length(); j++) {
                if (num.charAt(j) > num.charAt(j - 1)) {
                    for (int k = 0; k < num.charAt(j) - num.charAt(j - 1); k++) {
                        list.add('(');
                        openPar++;
                        // System.out.println("2: " + solution + " " + openPar);

                    }
                    list.add(num.charAt(j));
                    digitsleft--;

                } else if (num.charAt(j) <= num.charAt(j - 1)) {
                    for (int k = 0; k < num.charAt(j - 1) - num.charAt(j); k++) {
                        list.add(')');
                        openPar--;
                        // System.out.println("3: " + solution + " " + openPar);

                    }
                    list.add(num.charAt(j));
                    digitsleft--;

                }
                if (digitsleft == 0) {
                    for (int k = 0; k < openPar; k++) {
                        list.add(')');
                        // System.out.println(solution + " " + openPar);
                    }
                }
            }
            for (int j = 0; j < list.size(); j++) {
                solution += list.get(j);
            }
            System.out.println("Case #" + (i + 1) + ": " + solution);

        }

    }
}