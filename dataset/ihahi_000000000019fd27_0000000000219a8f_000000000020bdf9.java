import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #"+t+": ");
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int N = sc.nextInt();
        List<Task> ts = new ArrayList<>();
        for(int i=0;i<N;i++){
            int s=sc.nextInt();
            int e = sc.nextInt();
            ts.add(new Task(s, e, i));
        }
        Collections.sort(ts, Comparator.comparing(tsk->tsk.s));
        int je=0;
        int ce=0;
        char[] ans = new char[N];
        for(int i=0;i<N;i++){
            Task tgt = ts.get(i);
            if(je > tgt.s){
                if(ce > tgt.s){
                    System.out.println("IMPOSSIBLE");
                    return;
                }else{
                    ce = tgt.e;
                    ans[tgt.num]='J';
                }
            }else{
                je = tgt.e;
                ans[tgt.num]='C';
            }
        }
        System.out.println(ans);
    }

    private static class Task{
        final int s, e, num;
        Task(int s, int e, int num){
            this.s = s;
            this.e = e;
            this.num = num;
        }
    }
}
