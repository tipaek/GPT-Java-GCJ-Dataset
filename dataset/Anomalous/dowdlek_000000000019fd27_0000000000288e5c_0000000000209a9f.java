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

            for (int i = 0; i < input.length; i++) {
                nodes[i] = new Node(Character.getNumericValue(input[i]));
            }

            if (nodes.length > 1) {
                for (int i = 0; i < nodes.length - 1; i++) {
                    nodes[i].next = nodes[i + 1];
                    nodes[i + 1].prev = nodes[i];
                }
            }

            NDLinked linked = new NDLinked(nodes[0], nodes.length);
            Node current = nodes[0];

            while (linked.size > 1) {
                if (current.prev == null) { // at head
                    while (current.next.val < current.val) {
                        current.reduce();
                    }
                    if (current.next.val == current.val) {
                        linked.combineAfter(current, current.next);
                    } else {
                        current = current.next;
                    }
                } else if (current.next == null) { // at tail
                    while (current.prev.val < current.val) {
                        current.reduce();
                    }
                    if (current.prev.val == current.val) {
                        linked.combineBefore(current, current.prev);
                    } else {
                        current = current.prev;
                    }
                } else { // neither head nor tail
                    if (current.val == current.prev.val) {
                        while (current.val == current.prev.val) {
                            linked.combineBefore(current, current.prev);
                        }
                    }
                    if (current.val == current.next.val) {
                        while (current.val == current.next.val) {
                            linked.combineAfter(current, current.next);
                        }
                    }
                    if (current.val > current.next.val && current.val > current.prev.val) {
                        if (current.prev.val == current.next.val) {
                            while (current.prev.val < current.val) {
                                current.reduce();
                            }
                            linked.combineAfter(current, current.next);
                            linked.combineBefore(current, current.prev);
                        } else if (current.prev.val > current.next.val) {
                            while (current.prev.val < current.val) {
                                current.reduce();
                            }
                            linked.combineBefore(current, current.prev);
                        } else {
                            while (current.next.val < current.val) {
                                current.reduce();
                            }
                            linked.combineAfter(current, current.next);
                        }
                    } else if (current.val > current.prev.val) {
                        while (current.prev.val < current.val) {
                            current.reduce();
                        }
                        linked.combineBefore(current, current.prev);
                    } else if (current.val > current.next.val) {
                        while (current.next.val < current.val) {
                            current.reduce();
                        }
                        linked.combineAfter(current, current.next);
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

        NDLinked(Node head, int size) {
            this.head = head;
            this.size = size;
        }

        void combineAfter(Node current, Node other) {
            size--;
            current.next = other.next;
            if (other.next != null) other.next.prev = current;
            current.rep = current.rep + other.rep;
        }

        void combineBefore(Node current, Node other) {
            size--;
            current.prev = other.prev;
            if (other.prev != null) other.prev.next = current;
            current.rep = other.rep + current.rep;
        }
    }

    static class Node {
        Node prev;
        Node next;
        int val;
        String rep;

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