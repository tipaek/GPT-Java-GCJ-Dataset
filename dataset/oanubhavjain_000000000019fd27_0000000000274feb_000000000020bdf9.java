import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Interval {
        int st;
        int end;
        int idx;
        String owner;

        Interval(int st,int end, int idx) {
            this.st = st;
            this.end = end;
            this.idx = idx;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for(int i=1;i<=T;i++){
            int N = in.nextInt();
            ArrayList<Interval> input = new ArrayList<>();
            for(int j=1;j<=N;j++){
                int st = in.nextInt();
                int end = in.nextInt();
                Interval interval = new Interval(st,end,j);
                input.add(interval);
            }
            printOutput(i,input);
        }
    }
    private static void printOutput(int T,ArrayList<Interval> input) {
        StringBuilder sb =new StringBuilder();
        ArrayList<Interval> res = new ArrayList<>();
        Collections.sort(input,(Interval o1, Interval o2)-> o1.st - o2.st);
        int cs=0,ce=0,js=0,je=0;
        for(Interval i : input){
            if(i.st>=ce){
                i.owner="C";
                ce=i.end;
            } else if(i.st>=je){
                i.owner="J";
                je=i.end;
            } else {
                System.out.println("Case #" + T + ": " + "IMPOSSIBLE");
                return;
            }
        }
        Collections.sort(input,(Interval o1, Interval o2)-> o1.idx - o2.idx);
        input.stream().forEach(x->sb.append(x.owner));
        System.out.println("Case #" + T + ": " + sb.toString());
    }
}
