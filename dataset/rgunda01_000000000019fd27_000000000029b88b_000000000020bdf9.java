import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0; i<T; i++) {
            int N=sc.nextInt();
            Pairs[] interval = new Pairs[N];
            char[] order = new char[N];
            for(int x=0; x<N; x++) {

                int start = sc.nextInt();
                int end = sc.nextInt();
                interval[x] = new Pairs(x, start, end);
            }
            Arrays.sort(interval);
            int J = 0;
            int C = 0;
            boolean possible = true;

            for(int x=0; x<N; x++) {
                if(interval[x].start>=J) {
                    J = interval[x].end;
                    order[interval[x].num] = 'J';
                }
                else if(interval[x].start>=C) {
                    C = interval[x].end;
                    order[interval[x].num] = 'C';
                }
                else {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                    possible  = false;
                    break;
                }
            }
            if(possible) {
                String output = "";
                for(char ch:order) output+=ch+"";
                System.out.println("Case #"+(i+1)+": "+output);
            }
        }
    }
}
class Pairs implements Comparable<Pairs>{
    int num, start, end;
    public Pairs(int n, int s, int e) {
        num = n;
        start = s;
        end = e;
    }
    public int compareTo(Pairs t) {
        if(start==t.start) {
            return Integer.compare(end, t.end);
        }
        return Integer.compare(start, t.start);
    }
}