import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.in")))));
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Node(scanner.nextInt(), scanner.nextInt(), i, false));
            }
            Node c = null;
            Node j = null;
            list.sort(Comparator.comparing(o -> o.s));
            boolean impossible = false;
            for (Node node : list) {
                if (c != null && c.e <= node.s) {
                    c = null;
                }
                if (j != null && j.e <= node.s) {
                    j = null;
                }
                if (c == null) {
                    c = node;
                    node.cj = true;
                } else if (j == null) {
                    j = node;
                    node.cj = false;
                } else {
                    impossible = true;
                    break;
                }
            }
            String r;
            if (impossible) {
                r = "IMPOSSIBLE";
            } else {
                list.sort(Comparator.comparing(o -> o.i));
                r = list.stream().map(n -> n.cj ? "C" : "J").collect(Collectors.joining());
            }
            System.out.println("Case #" + t + ": " + r);
        }
    }

    static class Node {
        int s;
        int e;
        int i;
        boolean cj;

        public Node(int s, int e, int i, boolean cj) {
            this.s = s;
            this.e = e;
            this.i = i;
            this.cj = cj;
        }
    }
}
