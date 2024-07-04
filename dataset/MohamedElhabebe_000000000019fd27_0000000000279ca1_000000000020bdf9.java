import java.util.*;
import java.io.*;

class Triplet{
    int start;
    int end;
    int index;
}

class Sortbystart implements Comparator<Triplet>{
    public int compare(Triplet a , Triplet b){
        return a.start - b.start;
    }
}

public class Solution{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 1; i <= t; i ++){
            int n = sc.nextInt();
            Triplet[] acts = new Triplet[n];
            char[] sol = new char[n];
            int e1 = 0;
            int e2 = 0;
            boolean ended = true;
            for(int j = 0; j < n; j ++){
                Triplet tri = new Triplet();
                tri.start = sc.nextInt();
                tri.end = sc.nextInt();
                tri.index = j;
                acts[j] = tri;
            }
            Arrays.sort(acts , new Sortbystart());
            for(int j = 0; j < n; j ++){
                if(acts[j].start >= e1){
                    sol[acts[j].index] = 'C';
                    e1 = acts[j].end;
                }else if(acts[j].start >= e2){
                    sol[acts[j].index] = 'J';
                    e2 = acts[j].end;
                }else{
                    ended = false;
                    break;
                }
            }
            if(ended){
                String res = new String(sol);
                System.out.println("Case #" + i + ": " + res);
            }else{
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}