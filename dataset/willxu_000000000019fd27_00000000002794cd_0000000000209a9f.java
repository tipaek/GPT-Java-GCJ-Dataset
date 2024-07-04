
import java.io.InputStream;
import java.util.Scanner;
import java.util.Vector;

class Solution {

    private static class Node {
        int digit;
        int n;
    }

    public String solve(String line) {
        Vector<Node> data = buildData(line);
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (int i = 0; i < data.size(); i++) {
            Node node = data.get(i);
            if (node.digit > depth) {
                appendChars(sb, '(', node.digit - depth);
                depth = node.digit;
            } else if (node.digit < depth) {
                appendChars(sb, ')', depth - node.digit);
                depth = node.digit;
            }
            appendChars(sb, (char) (node.digit + '0'), node.n);
        }
        if (depth > 0) {
            appendChars(sb, ')', depth);
            depth = 0;
        }
        return sb.toString();
    }

    private static void appendChars(StringBuilder sb, char chr, int num) {
        for (int i = 0; i < num; i++) {
            sb.append(chr);
        }
    }

    private Vector<Node> buildData(String line) {
        Vector<Node> stack = new Vector<>();
        Node last = null;
        for (int i = 0; i < line.length(); i++) {
            char chr = line.charAt(i);
            int id = chr - '0';
            if (last != null && last.digit == id) {
                last.n++;
            } else {
                last = new Node();
                last.digit = id;
                last.n = 1;
                stack.add(last);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        processInputStream(System.in);
    }

    public static void processInputStream(InputStream in) {
        Scanner scanner = new Scanner(in);
        try {
            int T = scanner.nextInt();
            for (int t = 1; t <= T; t++) {
                String line = scanner.next();
                Solution s = new Solution();
                String result = s.solve(line);
                System.out.printf("Case #%d: %s\n", t, result);
            }
        } finally {
            scanner.close();
        }
    }
}
