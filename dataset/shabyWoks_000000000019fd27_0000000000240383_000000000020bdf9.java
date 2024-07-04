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
                list.add(new Pair(in.nextInt(), in.nextInt()));
            }
            
            Collections.sort(list);
            
            // for(int i=0; i<N; i++) {
            //     System.out.println(list.get(i).s + " " + list.get(i).e);
            // }
            // System.out.println("");
            
            int J = -1;
            int C = -1;
            String s = "";
            for(int i=0; i<N; i++) {
                Pair p = list.get(i);
                if (J == -1 && C == -1) {
                    s += "J";
                    J = p.e;
                } else if (J != -1 && C == -1) {
                    s += "C";
                    C = p.e;
                } else if (J == -1 && C != -1) {
                    s += "J";
                    J = p.e;
                } else {
                    if (p.s < J && p.s < C) {
                        s = "IMPOSSIBLE";
                        break;
                    } else if (p.s < J && p.s >= C) {
                        s += "C";
                        C = p.e;
                    } else if (p.s >= J && p.s < C) {
                        s += "J";
                        J = p.e;
                    } else {
                        s += "J";
                        J = p.e;
                    }
                }
            }
            System.out.println("Case #" + (t+1) + ": " + s);
        }
        
    }
    
    
}

class Pair implements Comparable<Pair> {
    int s;
    int e;
    
    public Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
    
    public int compareTo(Pair p) {
        if (this.s > p.s) return 1;
        if (this.s < p.s) return -1;
        if (this.e > p.e) return 1;
        if (this.e < p.e) return -1;
        return 0;
    }
}
