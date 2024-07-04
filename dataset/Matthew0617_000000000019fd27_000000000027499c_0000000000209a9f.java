import java.util.*;

public class q2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt(); //
        ArrayList<Character> list = new ArrayList<>();
        int openPar = 0;

        for (int i = 0; i < T; i++) {
            String num = input.next();
            String solution = "";
            int digitsleft = num.length() - 1;
            if (num.charAt(0) - '0' != 0) {
                for (int k = 0; k < num.charAt(0) - '0'; k++) {
                    list.add('(');
                    openPar++;
                }
                list.add(num.charAt(0));
            } else {
                list.add('0');
            }
            for (int j = 1; j < num.length(); j++) {
                digitsleft--;
                if (num.charAt(j) > num.charAt(j - 1)) {
                    for (int k = 0; k < num.charAt(j) - num.charAt(j - 1); k++) {
                        list.add('(');
                        openPar++;
                    }
                    list.add(num.charAt(j));

                } else if (num.charAt(j) <= num.charAt(j - 1)) {
                    for (int k = 0; k < num.charAt(j - 1) - num.charAt(j); k++) {
                        list.add(')');
                        openPar--;
                    }
                    list.add(num.charAt(j));

                }
                if (digitsleft == 0) {
                    for (int k = 0; k < openPar; k++) {
                        list.add(')');
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