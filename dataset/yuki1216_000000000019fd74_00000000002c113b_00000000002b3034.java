import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        T: for (int i = 1; i <= T; ++i) {

            int N = in.nextInt();
            String head = "";
            String foot = "";
            List<String> headList = new ArrayList<String>();
            List<String> footList = new ArrayList<String>();

            for (int j = 0; j < N; ++j) {
                String input = in.next();
                String splitInput[] = new String[2];

                if (input.startsWith("*")) {
                    splitInput[0] = "";
                    splitInput[1] = input.replace("*", "");
                    footList.add(splitInput[1]);
                    if (foot.length() < splitInput[1].length()) {
                        foot = splitInput[1];
                    }

                } else if (input.endsWith("*")) {
                    splitInput[0] = input.replace("*", "");
                    splitInput[1] = "";
                    headList.add(splitInput[0]);
                    if (head.length() < splitInput[0].length()) {
                        head = splitInput[0];
                    }

                } else {
                    splitInput = input.split("\\*", 0);
                    headList.add(splitInput[0]);
                    footList.add(splitInput[1]);

                    if (head.length() < splitInput[0].length()) {
                        head = splitInput[0];
                    }
                    if (foot.length() < splitInput[1].length()) {
                        foot = splitInput[1];
                    }
                }

                if (foot.length() < splitInput[1].length()) {
                    foot = splitInput[1];
                }
                /*
                System.out.println("headList : " + headList);
                System.out.println("head : " + head);
                System.out.println("footList : " + footList);
                System.out.println("foot : " + foot);
                */
            }

            for (String h : headList) {
                if (!head.startsWith(h)) {
                    System.out.println("Case #" + i + ": *");
                    continue T;
                }
            }
            for (String f : footList) {
                if (!foot.endsWith(f)) {
                    System.out.println("Case #" + i + ": *");
                    continue T;
                }
            }
            System.out.println("Case #" + i + ": " + head + foot);
        }
        in.close();
    }

}
