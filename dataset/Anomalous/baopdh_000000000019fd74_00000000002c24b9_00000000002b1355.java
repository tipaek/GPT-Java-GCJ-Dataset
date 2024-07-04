import java.util.Scanner;

class Node {
    int val;
    Node left, right, top, bot;
    boolean isEliminated = false;

    Node(int val) {
        this.val = val;
    }
}

public class Solution {

    private static Node[] createGrid(int m, int n) {
        Node[] rows = new Node[m];

        for (int i = 0; i < m; ++i) {
            rows[i] = new Node(0);
            Node current = rows[i];
            for (int j = 1; j < n; ++j) {
                Node newNode = new Node(0);
                current.right = newNode;
                newNode.left = current;
                current = newNode;
            }
        }

        Node[] temp = new Node[m];
        for (int i = 0; i < m; ++i) {
            temp[i] = rows[i];
        }

        for (int j = 0; j < n; ++j) {
            for (int i = 1; i < m; ++i) {
                int prev = i - 1;
                temp[prev].bot = temp[i];
                temp[i].top = temp[prev];
                temp[prev] = temp[prev].right;
            }
            temp[m - 1] = temp[m - 1].right;
        }

        return rows;
    }

    private static void eliminate(Node[] rows, Node node, int rowIdx) {
        if (node == rows[rowIdx]) {
            rows[rowIdx] = node.right;
        }

        if (node.left != null) {
            node.left.right = node.right;
        }
        if (node.right != null) {
            node.right.left = node.left;
        }
        if (node.top != null) {
            node.top.bot = node.bot;
        }
        if (node.bot != null) {
            node.bot.top = node.top;
        }

        node.left = node.right = node.top = node.bot = null;
    }

    private static long process(Node[] rows, int m, int n, long sum) {
        long result = 0;
        boolean hasEliminated;

        do {
            hasEliminated = false;
            for (int i = 0; i < m; ++i) {
                Node current = rows[i];
                while (current != null) {
                    int avg = 0, count = 0;

                    if (current.left != null) {
                        avg += current.left.val;
                        ++count;
                    }
                    if (current.right != null) {
                        avg += current.right.val;
                        ++count;
                    }
                    if (current.top != null) {
                        avg += current.top.val;
                        ++count;
                    }
                    if (current.bot != null) {
                        avg += current.bot.val;
                        ++count;
                    }

                    if (current.val * count < avg) {
                        current.isEliminated = true;
                        hasEliminated = true;
                    }

                    current = current.right;
                }
            }

            long sumEliminated = 0;
            if (hasEliminated) {
                for (int i = 0; i < m; ++i) {
                    Node current = rows[i];
                    while (current != null) {
                        if (current.isEliminated) {
                            sumEliminated += current.val;
                            Node temp = current.right;
                            eliminate(rows, current, i);
                            current = temp;
                        } else {
                            current = current.right;
                        }
                    }
                }
            }

            result += sum;
            sum -= sumEliminated;
        } while (hasEliminated);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int k = 1; k <= t; ++k) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            Node[] rows = createGrid(m, n);

            long sum = 0;
            for (int i = 0; i < m; ++i) {
                Node current = rows[i];
                for (int j = 0; j < n; ++j) {
                    int value = scanner.nextInt();
                    sum += value;
                    current.val = value;
                    current = current.right;
                }
            }

            System.out.println("Case #" + k + ": " + process(rows, m, n, sum));
        }
        scanner.close();
    }
}