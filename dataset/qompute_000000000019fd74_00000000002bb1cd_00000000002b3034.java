import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scan.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = scan.next();
            }
            String leading = "";
            String trailing = "";
            List<String> middle = new ArrayList<>();
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                String[] chunks = patterns[i].split(Pattern.quote("*"), -1);
                if (chunks[0].startsWith(leading)) {
                    leading = chunks[0];
                } else if (!leading.startsWith(chunks[0])) {
                    possible = false;
                }
                if (chunks[chunks.length - 1].endsWith(trailing)) {
                    trailing = chunks[chunks.length - 1];
                } else if (!trailing.endsWith(chunks[chunks.length - 1])) {
                    possible = false;
                }
                for (int j = 1; j < chunks.length - 1; j++) {
                    middle.add(chunks[j]);
                }
            }
            if (!possible) {
                System.out.println("Case #" + caseNum + ": *");
            } else {
                String s = leading + String.join("", middle) + trailing;
                System.out.println("Case #" + caseNum + ": " + s);
            }
        }
    }
}
