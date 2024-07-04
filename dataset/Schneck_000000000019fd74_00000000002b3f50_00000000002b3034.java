import java.io.*;
import java.util.*;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        int N = scan.nextInt();
        List<String> starts = new ArrayList<>();
        List<String> middles = new ArrayList<>();
        List<String> ends = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = in.readLine().trim();
            StringBuilder sb = new StringBuilder();
            StringBuilder middle = new StringBuilder();
            boolean sawFirst = false;
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == '*') {
                    if (!sawFirst) {
                        starts.add(sb.toString());
                        sawFirst = true;
                    } else {
                        middle.append(sb);
                    }
                    sb = new StringBuilder();
                } else {
                    sb.append(ch);
                }
            }
            middles.add(middle.toString());
            ends.add(sb.toString());
        }
        starts.add("");
        ends.add("");
        starts.sort(Comparator.comparing(s -> s.length()));
        ends.sort(Comparator.comparing(s -> s.length()));
        String start = starts.get(starts.size() - 1);
        String end = ends.get(ends.size() - 1);
        if (!start.isEmpty()) {
            for (String shorterStart : starts) {
                if (start.indexOf(shorterStart) != 0) {
                    //System.err.println("start: " + start + " " + shorterStart);
                    System.out.println("*");
                    return;
                }
            }
        }
        if (!end.isEmpty()) {
            for (String shorterEnd : ends) {
                if (end.lastIndexOf(shorterEnd) != end.length() - shorterEnd.length()) {
                    //System.err.println("end: " + end + " " + shorterEnd);
                    System.out.println("*");
                    return;
                }
            }
        }
        System.out.print(start);
        for (String middle : middles) {
            System.out.print(middle);
        }
        System.out.println(end);
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
