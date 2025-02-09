import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int cases = 0; cases < n; cases++) {
            sb.append("Case #").append(cases + 1).append(": ");
            char[] input = reader.readLine().toCharArray();
            Node[] nodes = new Node[input.length];

            // Initialize nodes
            for (int i = 0; i < input.length; i++) {
                nodes[i] = new Node(Character.getNumericValue(input[i]));
            }

            // Link nodes
            for (int i = 0; i < nodes.length; i++) {
                if (i > 0) nodes[i].prev = nodes[i - 1];
                if (i < nodes.length - 1) nodes[i].next = nodes[i + 1];
            }

            NDLinked linked = new NDLinked(nodes[0]);
            linked.size = nodes.length;

            Node current = nodes[0];
            current.isHead = true;

            while (linked.size > 1) {
                if (current.prev == null) { // At head
                    while (current.next.val < current.val) {
                        current.reduce();
                    }
                    if (current.next.val == current.val) {
                        linked.combineAfter(current);
                    } else {
                        current = current.next;
                    }
                } else if (current.next == null) { // At tail
                    while (current.prev.val < current.val) {
                        current.reduce();
                    }
                    if (current.prev.val == current.val) {
                        linked.combineBefore(current);
                    } else {
                        current = current.prev;
                    }
                } else { // Neither head nor tail
                    if (current.val == current.prev.val) {
                        while (current.val == current.prev.val) {
                            linked.combineBefore(current);
                        }
                    }
                    if (current.val == current.next.val) {
                        while (current.val == current.next.val) {
                            linked.combineAfter(current);
                        }
                    }
                    if (current.val > current.next.val && current.val > current.prev.val) {
                        if (current.prev.val == current.next.val) {
                            while (current.prev.val < current.val) {
                                current.reduce();
                            }
                            linked.combineAfter(current);
                            linked.combineBefore(current);
                        } else if (current.prev.val > current.next.val) {
                            while (current.prev.val < current.val) {
                                current.reduce();
                            }
                            linked.combineBefore(current);
                        } else {
                            while (current.next.val < current.val) {
                                current.reduce();
                            }
                            linked.combineAfter(current);
                        }
                    } else if (current.val > current.prev.val) {
                        while (current.prev.val < current.val) {
                            current.reduce();
                        }
                        linked.combineBefore(current);
                    } else if (current.val > current.next.val) {
                        while (current.next.val < current.val) {
                            current.reduce();
                        }
                        linked.combineAfter(current);
                    } else {
                        current = current.next;
                    }
                }
            }

            while (linked.head.val > 0) {
                linked.head.reduce();
            }

            sb.append(linked.head.rep).append('\n');
        }

        System.out.println(sb.toString());
    }

    static class NDLinked {
        Node head;
        int size;

        NDLinked(Node head) {
            this.head = head;
        }

        void combineAfter(Node current) {
            size--;
            Node tempNode = current.next;
            current.next = tempNode.next;
            if (tempNode.next != null) {
                tempNode.next.prev = current;
            }
            current.rep += tempNode.rep;
        }

        void combineBefore(Node current) {
            size--;
            Node tempNode = current.prev;
            boolean isHead = tempNode.isHead;
            current.prev = tempNode.prev;
            if (tempNode.prev != null) {
                tempNode.prev.next = current;
            }
            current.rep = tempNode.rep + current.rep;
            if (isHead) {
                head = current;
            }
        }
    }

    static class Node {
        Node prev;
        Node next;
        int val;
        String rep;
        boolean isHead = false;

        Node(int val) {
            this.val = val;
            this.rep = Integer.toString(val);
        }

        void reduce() {
            val--;
            rep = "(" + rep + ")";
        }
    }
}