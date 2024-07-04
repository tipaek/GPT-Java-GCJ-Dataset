
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            ArrayList<Node> c = new ArrayList<>();
            ArrayList<Node> j = new ArrayList<>();
            boolean flag = true;
            for (int j2 = 0; j2 < n; j2++) {
                Node m = new Node(j2, in.nextInt(), in.nextInt());
                if (flag) {
                    if (!isOverLap(m, c)) {
                        m.type = 0;
                        c.add(m);
                    } else if (!isOverLap(m, j)) {
                        m.type = 1;
                        j.add(m);
                    } else {
                        flag = false;
                    }
                }

            }
            String res = "IMPOSSIBLE";
            if (flag) {
                res = "";
                c.addAll(j);
                Collections.sort(c);
                
                for (int k = 0; k < c.size(); k++) {
                    if (c.get(k).type == 0)
                        res += "C";
                    else
                        res += "J";
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }

    public static boolean isOverLap(Node m, ArrayList<Node> data) {
        for (int i = 0; i < data.size(); i++) {
            Node p = data.get(i);

            if (m.s >= p.s && m.s < p.e){
                // System.out.println("A  " + m.toString()+"  "+p.toString());
                return true;
            }
             

            if (m.e > p.s && m.e <= p.e){
                // System.out.println("B");
                return true;
            }

        }
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

        return ""+idx;
    }
}