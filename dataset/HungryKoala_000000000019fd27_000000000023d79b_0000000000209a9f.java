import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt();
        in.nextLine();

        for (int x = 1; x <= T; ++x) {

            final String S = in.nextLine();

            final Node root = new Node(true, false, -1);

            final Node[] levelNodes = new Node[10]; // level = 0 ... 9
            levelNodes[0] = root;

            int prevDigit = -1;
            for (char c : S.toCharArray()) {
                final int digit = c - '0';  // digit is in [0, 9]
                if (prevDigit == -1) {
                    for (int i = 1; i <= digit; ++i) {
                        levelNodes[i] = new Node(false, true, -1);
                        levelNodes[i - 1].addChild(levelNodes[i]);
                    }
                    levelNodes[digit].addChild(new Node(false, false, digit));
                } else {
                    for (int i = 1; i <= digit - prevDigit; ++i) {
                        levelNodes[prevDigit + i] = new Node(false, true, -1);
                        levelNodes[prevDigit + i - 1].addChild(levelNodes[prevDigit + i]);
                    }
                    levelNodes[digit].addChild(new Node(false, false, digit));
                }
                prevDigit = digit;
            }

            System.out.println("Case #" + x + ": " + root.traverse());
            System.out.flush();
        }
    }

    private static final class Node {

        private final boolean isBracket;
        private final boolean isRoot;
        private final int digit;
        private final List<Node> children;

        public Node(final boolean isRoot, final boolean isBracket, final int digit) {
            this.isRoot = isRoot;
            this.isBracket = isBracket;
            this.digit = digit;
            this.children = new ArrayList<>();
        }

        public void addChild(final Node child) {
            children.add(child);
        }

        public String traverse() {
            final StringBuilder sb = new StringBuilder();
            visit(this, sb);
            return sb.toString();
        }

        private static void visit(final Node node, final StringBuilder sb) {
            if (node == null) {
                return;
            } else if (node.isRoot) {
                for (Node child : node.children) {
                    visit(child, sb);
                }
            } else if (node.isBracket) {
                sb.append("(");
                for (Node child : node.children) {
                    visit(child, sb);
                }
                sb.append(")");
            } else {    // node is a digit
                sb.append(node.digit);
            }
        }
    }
}
