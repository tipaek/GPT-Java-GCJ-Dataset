package googlecodejam;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        ArrayList<String> outputList = new ArrayList<>();
        StringBuilder sb = new StringBuilder("testing");
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            inputList.add(in.next());
        }

        for (int i = 0; i < inputList.size(); i++) {
            String current = inputList.get(i);
            if (current.charAt(0) == '0' && isSame(current)) {
                outputList.add(current);
            } else {
                sb = new StringBuilder(current);
                for (int j = 0; j < current.length(); j++) {
                    if (current.charAt(j) == '1') {
                        sb.insert(j, "(");
                        if (j != current.length() - 1 && current.charAt(j) != current.charAt(j + 1)) {
                            sb.insert(j + 2, ")");
                        } else if (j == current.length() - 1) {
                            sb.insert(j + 2, ")");
                        }
                    }
                }
                outputList.add(sb.toString());
            }
        }

        for (int i = 0; i < outputList.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputList.get(i));
        }
    }

    static boolean isSame(String s) {
        char firstChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}