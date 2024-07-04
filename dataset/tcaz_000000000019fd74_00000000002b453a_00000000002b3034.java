import java.util.*;

public class Solution {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new Solution().start();
    }

    void start() {
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            System.out.println("Case #" + (i+1) +": " + getAnswer());
        }
    }

    String getAnswer() {
        int n = scan.nextInt();
        List<String> strs = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            strs.add(scan.next());
        }
        Map<String, String> starts = new HashMap<>();
        Map<String, String> ends = new HashMap<>();
        String largest_starts = "";
        String largest_ends = "";
        for (String s : strs) {
            if (s.startsWith("*")) {
                String end = s.substring(1);
                if (end.length() >= largest_ends.length()) {
                    largest_ends = end;
                }
                ends.put(s, end);
            } else if (s.endsWith("*")) {
                String start = s.substring(0, s.length()-1);
                if (start.length() >= largest_starts.length()) {
                    largest_starts = start;
                }
                starts.put(s, start);
            } else {
                String[] results = s.split("\\*");
                String start = results[0];
                if (start.length() >= largest_starts.length()) {
                    largest_starts = start;
                }
                String end = results[1];
                if (end.length() >= largest_ends.length()) {
                    largest_ends = end;
                }
                starts.put(s, start);
                ends.put(s, end);
            }
        }
        for (String s : strs) {
            if (starts.containsKey(s)) {
                if (!largest_starts.startsWith(starts.get(s))) {
                    return "*";
                }
            }
            if (ends.containsKey(s)) {
                if (!largest_ends.endsWith(ends.get(s))) {
                    return "*";
                }
            }
        }
       return largest_starts + largest_ends;
    }

}
