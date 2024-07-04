import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            List<String> needed = new ArrayList<>();
            String beginning = "";
            String end = "";
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                String str = sc.next();
                if (!possible) continue;

                int ast = str.indexOf('*');
                String start = str.substring(0, ast);

                if (ast > 0) {
                    if (beginning.startsWith(start)) {
                        // beginning already matches start
                    } else if (start.startsWith(beginning)) {
                        beginning = start;
                    } else {
                        possible = false;
                    }
                }

                int prev = ast + 1;
                while ((ast = str.indexOf('*', prev)) >= 0) {
                    needed.add(str.substring(prev, ast));
                    prev = ast + 1;
                }

                if (prev < str.length()) {
                    String stop = str.substring(prev);
                    if (stop.endsWith(end)) {
                        end = stop.length() > end.length() ? stop : end;
                    } else if (end.endsWith(stop)) {
                        // end already matches stop
                    } else {
                        possible = false;
                    }
                }
            }

            if (possible) {
                StringBuilder ans = new StringBuilder(beginning);
                for (String s : needed) {
                    ans.append(s);
                }
                ans.append(end);
                System.out.println("Case #" + test + ": " + ans.toString());
            } else {
                System.out.println("Case #" + test + ": *");
            }
        }
    }
}