import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);


        int t = in.nextInt();
        int id = 1;
        while (t-- != 0) {
            int n = in.nextInt();
            List<StringBuilder> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l.add(new StringBuilder(in.next()));
            }
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            boolean inccorect = false;
            char c;
            while(true) {
                c = getLeft(l);
                if (c == 0)
                    break;
                if (c == 1) {
                    inccorect = true;
                    break;
                }
                left.append(c);
            }

            while (true) {
                c = getRight(l);
                if (c == 0)
                    break;
                if (c == 1) {
                    inccorect = true;
                    break;
                }
                right.append(c);
            }
            if (inccorect) {
                    out.println("Case #" + id + " *");
            } else {

                for (int i = 0; i < l.size(); i++) {
                    for (int j = 0; j < l.get(i).length(); j++) {
                        if (l.get(i).charAt(j) != '*') {
                            left.append(l.get(i).charAt(j));
                        }
                    }
                }
                out.println("Case #" + id + " " + new String(left) + new String(right.reverse()));
            }

            id++;
        }
        out.close();
    }

    private static char getLeft(List<StringBuilder> l) {
        Set<Character> s = new HashSet<>();
        char c = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).length() == 0) {
                s.add((char)0);
                continue;
            }
            if (l.get(i).charAt(0) != '*') {
                s.add(l.get(i).charAt(0));
                c = l.get(i).charAt(0);
            }
        }
        if (s.size() == 1) {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).length() == 0) {
                    continue;
                }
                if (l.get(i).charAt(0) == c) {
                    l.get(i).deleteCharAt(0);
                }
            }
            return c;
        }
        if (s.size() > 1) {
            return 1;
        }
        return 0;
    }

    private static char getRight(List<StringBuilder> l) {
        Set<Character> s = new HashSet<>();
        char c = 1;
        int nul = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).length() == 0) {
                s.add((char)0);
                continue;
            }
            int len = l.get(i).length() - 1;
            if (l.get(i).charAt(len) != '*') {
                s.add(l.get(i).charAt(len));
                c = l.get(i).charAt(len);
            }
        }
        if (s.size() == 1) {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).length() == 0) {
                    continue;
                }
                int len = l.get(i).length() - 1;
                if (l.get(i).charAt(len) == c) {
                    l.get(i).deleteCharAt(len);
                }
            }
            return c;
        }
        if (s.size() > 1) {
            return 1;
        }
        return 0;
    }
}
