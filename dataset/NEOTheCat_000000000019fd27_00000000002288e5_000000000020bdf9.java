
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static String PATTEN = "Case #%d: %s";

    public static void main(String [] args) {
        class Interval{
            private Integer start;
            private Integer end;
            private Integer index;
            private Interval(Integer start, Integer end, Integer index){
                this.start = start;
                this.end = end;
                this.index = index;
            }
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p =1;p<=t;p++) {
            int n = sc.nextInt();
            List<Interval> list = new ArrayList<>();
            for (int i=0;i<n;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(new Interval(x,y,i));
            }
            list.sort(Comparator.comparing((x->x.start)));
            int j= Integer.MIN_VALUE;
            int c = Integer.MIN_VALUE;
            StringBuilder ans = new StringBuilder();
            char[] ansChar = new char[list.size()];
            for (Interval interval:list){
                if (interval.start>=j){
                    j = interval.end;
                    ansChar[interval.index] = 'J';
                } else if (interval.start>=c) {
                    c = interval.end;
                    ansChar[interval.index] = 'C';
                } else {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            if (ans.toString().isEmpty()){
                ans.append(ansChar);
            } 
            System.out.println(String.format(PATTEN, p, ans.toString()));
        }
    }
}