import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        ArrayList<String> s = new ArrayList<>(), r = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            s.add(scanner.next());
        }

        for (int i = 0; i < cases; i++) {
            for (int j = 0; j < s.get(i).length(); j++) {
                if (s.get(i).charAt(j) == '1') {
                    if (j == 0) {
                        r.add("(1");
                    } else {
                        if (r.get(i).charAt(r.get(i).length() - 1) == '1') {
                            r.set(i, r.get(i) + "1");
                        }

                        if (r.get(i).charAt(r.get(i).length() - 1) == '0') {
                            r.set(i, r.get(i) + "(1");
                        }
                    }
                } else {
                    if (j == 0) {
                        r.add("0");
                    } else {
                        if (r.get(i).charAt(r.get(i).length() - 1) == '1') {
                            r.set(i, r.get(i) + ")0");
                        } else {
                            r.set(i, r.get(i) + "0");
                        }
                    }
                }
            }

            if (r.get(i).charAt(r.get(i).length() - 1) == '1') {
                r.set(i, r.get(i) + ")");
            }
            System.out.println("Case #" + (i + 1) + ": " + r.get(i));
        }
    }
}
