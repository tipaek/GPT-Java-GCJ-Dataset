import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.println("Case #" + t + ": ");
            solve(sc);
        }
    }
    private static void solve(Scanner sc) {
        int N = sc.nextInt();
        List<String> Ps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Ps.add(sc.next());
        }
        helper(Ps);
    }
    private static void helper(List<String> Ps){
        int N = Ps.size();
        char[] ret = new char[10000];
        int ri=0;
        int[] ind = new int[N];
        Collections.sort(Ps, Comparator.comparingInt(p->-p.length()));
        for(int i=0;i<N;i++){
            ind[i] = Ps.get(i).length()-1;
        }
        for(int k=0;k<Ps.get(0).length()-1;k++) {
            for (int i = 0; i < N; i++) {
                if(ind[i] == 0){continue;}
                if (i == 0) {
                    ret[ri] = Ps.get(0).charAt(ind[i]);
                }
                if (Ps.get(i).charAt(ind[i]) != '*') {
                    if (Ps.get(i).charAt(ind[i]) == ret[ri]) {
                        ind[i]--;
                    } else {
                        System.out.println("*");
                        return;
                    }
                }
            }
            ri++;
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<ri;k++){
            sb.append(ret[ri-1-k]);
        }
        System.out.println(sb);
    }
    private static void printChar(char[] r){
        for(int i=0;i<r.length;i++){
            System.out.print(r[i]);
        }
        System.out.println();
    }
}
