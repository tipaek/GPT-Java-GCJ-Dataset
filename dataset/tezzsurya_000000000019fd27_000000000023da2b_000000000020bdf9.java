import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            int n = Integer.parseInt(br.readLine().trim());
            PriorityQueue<node> pq = new PriorityQueue<>(n, new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    if(o1.s == o2.s) return 0;
                    if(o1.s < o2.s) return -1;
                    return 1;
                }
            });

            for(int i=0;i<n;i++) {
                String[] sar = br.readLine().trim().split(" ");
                int s1 = Integer.parseInt(sar[0]);
                int e1 = Integer.parseInt(sar[1]);
                node x = new node(i, s1, e1);
                pq.add(x);
            }
            boolean aFree = true;
            boolean bFree = true;
            boolean[] res = new boolean[n];
            int aLast = -1;
            int bLast = -1;
            boolean imp = false;
            while(!pq.isEmpty()) {
                node top = pq.poll();
                
                if(top.s >= aLast) {
                    aLast = top.e;
                    res[top.idx] = true;
                } else {
                    if(top.s >= bLast) {
                        bLast = top.e;
                    } else {
                        // no one can take the job
                        imp = true;
                        break;
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            if(imp) {
                result.append("IMPOSSIBLE");
            } else {
                for(boolean b : res) {
                    if(b) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            }
            sb.append("Case #").append(t).append(": ").append(result.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}

class node {
    int s;
    int e;
    int idx;

    node(int idx, int s, int e) {
        this.idx = idx;
        this.s = s;
        this.e = e;
    }
}