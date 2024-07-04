import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int cases = 1; cases <= T; cases++) {
            System.out.print("Case #" + cases + ": ");
            int N = Integer.parseInt(br.readLine());
            String[] answers = new String[N];
            String start = "";
            String end = "";
            boolean printed = false;

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                if (!printed) {
                    String startString = s.substring(0, s.indexOf('*'));
                    for (int h = 0; h < Math.min(startString.length(), start.length()); h++) {
                        if (startString.charAt(h) != start.charAt(h)) {
                            System.out.println("*");
                            printed = true;
                            break;
                        }
                    }
                    if (printed) continue;

                    if (startString.length() > start.length()) {
                        start = startString;
                    }

                    String endString = s.substring(s.lastIndexOf('*') + 1);
                    for (int h = 0; h < Math.min(endString.length(), end.length()); h++) {
                        if (end.charAt(end.length() - h - 1) != endString.charAt(endString.length() - h - 1)) {
                            System.out.println("*");
                            printed = true;
                            break;
                        }
                    }
                    if (printed) continue;

                    if (endString.length() > end.length()) {
                        end = endString;
                    }

                    answers[i] = s.replaceAll("\\*", "");
                }
            }

            if (!printed) {
                System.out.print(start);
                for (String answer : answers) {
                    System.out.print(answer);
                }
                System.out.println(end);
            }
        }
    }
}