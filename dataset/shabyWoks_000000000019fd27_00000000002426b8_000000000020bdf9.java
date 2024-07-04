import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        
        for(int t=0; t<T; t++) {
            int N = in.nextInt();
            
            ArrayList<Pair> list = new ArrayList<>();
            for(int i=0; i<N; i++) {
                list.add(new Pair(in.nextInt(), in.nextInt(), i));
            }
            
            Collections.sort(list);
            
            // for(int i=0; i<N; i++) {
            //     System.out.println(list.get(i).s + " " + list.get(i).e);
            // }
            // System.out.println("");
            
            int J = -1;
            int C = -1;
            
            boolean flag = false;
            
            for(int i=0; i<N; i++) {
                Pair p = list.get(i);
                if (J == -1 && C == -1) {
                    // s += "J";
                    p.str = "J"; 
                    J = p.e;
                } else if (J != -1 && C == -1) {
                    p.str = "C";
                    C = p.e;
                } else if (J == -1 && C != -1) {
                    p.str = "J";
                    J = p.e;
                } else {
                    if (p.s < J && p.s < C) {
                        flag = true;
                        System.out.println("Case #" + (t+1) + ": " + "IMPOSSIBLE");
                        break;
                    } else if (p.s < J && p.s >= C) {
                        p.str = "C";
                        C = p.e;
                    } else if (p.s >= J && p.s < C) {
                        p.str = "J";
                        J = p.e;
                    } else {
                        p.str = "J";
                        J = p.e;
                    }
                }
            }
            if (flag == false) {
                String[] s = new String[N];
                for(int i=0; i<N; i++) {
                    s[list.get(i).idx] = list.get(i).str;
                }
                String ss = "";
                for(int i=0; i<N; i++) {
                    ss += s[i];
                }
                System.out.println("Case #" + (t+1) + ": " + ss);    
            }
            
        }
        
    }
    
    
}

class Pair implements Comparable<Pair> {
    int s;
    int e;
    int idx;
    String str;
    
    public Pair(int s, int e, int idx) {
        this.s = s;
        this.e = e;
        this.idx = idx;
    }
    
    public int compareTo(Pair p) {
        if (this.s > p.s) return 1;
        if (this.s < p.s) return -1;
        if (this.e > p.e) return 1;
        if (this.e < p.e) return -1;
        return 0;
    }
}
