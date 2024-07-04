import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Endpoint {
    int time;
    boolean isEnd;
    int id;
    public Endpoint(int time, boolean isEnd, int id) {
        this.time = time;
        this.isEnd = isEnd;
        this.id=id;
    }
}
public class Solution {
    public static void solve(int[] S, int[] E) {
        int n = S.length;
        int J = -1;
        int C = -1;
        int id = 0;
        Endpoint[] ep = new Endpoint[2*n];
        for(int i = 0; i<n; i++) {
            ep[2*i] = new Endpoint(S[i],false,id);
            ep[2*i+1] = new Endpoint(E[i],true,id++);
        }
        Arrays.sort(ep,new Comparator<Endpoint>() {
           @Override
           public int compare(Endpoint a, Endpoint b) {
               if(a.time==b.time) {
                   if(a.isEnd==b.isEnd) return 0;
                   if(a.isEnd) return -1;
                   else return 1;
               }
               return Integer.compare(a.time,b.time);
           }
        });
//        for(var p : ep) System.out.println(p.time + " " + p.id);
        StringBuilder ans = new StringBuilder();
        for(Endpoint p : ep) {
            if(!p.isEnd) {
                if(J>=0 && C>=0) {
                    ans.append("IMPOSSIBLE");
                    break;
                }
                if(C==-1) {
                    C=p.id;
                    ans.append('C');
                } else {
                    J=p.id;
                    ans.append('J');
                }
            } else {
                if(J==p.id) J=-1;
                else C=-1;
            }
        }
        System.out.println(ans.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
            int N = sc.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];
            for(int i = 0; i<N; i++) {
                S[i] = sc.nextInt();
                E[i] = sc.nextInt();
            }
            System.out.print("Case #"+t+": ");
            solve(S,E);
        }
    }
}
