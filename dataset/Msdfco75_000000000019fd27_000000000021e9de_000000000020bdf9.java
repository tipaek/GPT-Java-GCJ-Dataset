
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            ArrayList<Node> d = new ArrayList<>();

            for (int j2 = 0; j2 < n; j2++) {
                d.add(new Node(j2, in.nextInt(), in.nextInt()));

            }

            boolean found = false;
            ArrayList<Node> ca = new ArrayList<>();
            ArrayList<Node> je = new ArrayList<>();
            for (int j = 1; j <= Math.pow(2, n); j++) {
                String m = Integer.toBinaryString(j);
                ca.clear();
                je.clear();
                for (int k = 0; k < n; k++) {
                    if (m.length() <= k || m.charAt(k) == '0') {
                        d.get(k).type = 0;
                        ca.add(d.get(k));
                    } else {
                        d.get(k).type = 1;
                        je.add(d.get(k));
                    }
                }
                // System.out.println("---------  " + m);
                if (!isOverlap(ca) && !isOverlap(je)) {
                    found = true;
                    break;
                }

            }
            String res = "IMPOSSIBLE";
            if (found) {
                res = "";
                ca.addAll(je);
                Collections.sort(ca);

                for (int k = 0; k < ca.size(); k++) {
                    if (ca.get(k).type == 0)
                        res += "C";
                    else
                        res += "J";
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + res);
            // System.out.println(isBipartite(g));
        }
    }

    static boolean isOverlap(ArrayList<Node> arr) {
        int n = arr.size();

        int max_ele = 0;

        // Find the overall maximum element
        for (int i = 0; i < n; i++) {
            if (max_ele < arr.get(i).e)
                max_ele = arr.get(i).e;
        }

        // Initialize an array of size max_ele
        int[] aux = new int[max_ele + 1];
        for (int i = 0; i < n; i++) {

            // starting point of the interval
            int x = arr.get(i).s;

            // end point of the interval
            int y = arr.get(i).e;
            aux[x]++;
            aux[y]--;
        }
        for (int i = 1; i <= max_ele; i++) {
            // Calculating the prefix Sum
            aux[i] += aux[i - 1];

            // Overlap
            if (aux[i] > 1)
                return true;
        }

        // If we reach here, then no Overlap
        return false;
    }

}

class Node implements Comparable<Node> {
    int idx = -1;
    int s = 0;
    int e = 0;
    byte type = -1;

    public Node(int idx, int s, int e) {
        this.idx = idx;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Node f) {
        return this.idx - f.idx;
    }

    @Override
    public String toString() {

        return "" + idx;
    }
}