import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N;
        ArrayList<Schedule> S;
        int C = 0;
        int J = 0;
        int start = 0;int end = 0;
        Boolean isPos = true;
        StringBuilder ans = new StringBuilder();
        for(int i =0; i<T; i++){
            S = new ArrayList<Schedule>();
            N = sc.nextInt();
            ans.append("Case #" + (i + 1) + ": ");
            for(int j =0; j<N;j++){
                start = sc.nextInt();
                end = sc.nextInt();
                S.add(new Schedule(j, start, end));
            }
            Collections.sort(S, new SortByStart());
            for(int k = 0; k<N;k++){
                if(C<=S.get(k).s){
                    S.get(k).p = "C";
                    C = S.get(k).e;
                } else if(J<=S.get(k).s){
                    S.get(k).p = "J";
                    J = S.get(k).e;
                } else {
                    ans.append("IMPOSSIBLE\n");
                    isPos = false;
                    break;
                }
            }
            if(isPos){
                Collections.sort(S, new SortByNo());
                for(int k = 0; k < N; k++){
                    ans.append(S.get(k).p);
                }
                ans.append("\n");
            }
            isPos = true;
            C=0;
            J=0;
        }
        System.out.print(ans.toString());
    }

}
class Schedule {
    int no;
    int s;
    int e;
    String p;
    public Schedule(int no, int s, int e){
        this.no = no;
        this.s = s;
        this.e = e;

    }
}

class SortByStart implements Comparator<Schedule> {
    public int compare(Schedule a, Schedule b) {
        return a.s - b.s;
    }
};

class SortByNo implements Comparator<Schedule> {
    public int compare(Schedule a, Schedule b) {
        return a.no - b.no;
    }
};