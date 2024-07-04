import java.util.*;

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
        Endpoint[] ep = new Endpoint[2*n];
        for(int i = 0; i<n; i++) {
            ep[2*i] = new Endpoint(S[i],false,i);
            ep[2*i+1] = new Endpoint(E[i],true,i);
        }
        char[] ans = new char[n];
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
        Set<Character> available = new HashSet<>(Arrays.asList('C', 'J'));
        Set<Character> busy = new HashSet<>();
        for(Endpoint p : ep) {
            if(!p.isEnd) {
                if(available.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
                char person = available.iterator().next();
                available.remove(person);
                busy.add(person);
                ans[p.id]=person;
            } else {
                char person = ans[p.id];
                busy.remove(person);
                available.add(person);
            }
        }
        System.out.println(String.valueOf(ans));
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