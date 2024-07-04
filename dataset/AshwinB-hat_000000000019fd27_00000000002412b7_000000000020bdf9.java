
import java.util.Arrays;
import java.util.Scanner;
class Interval implements Comparable<Interval>{
    int start,end,index;
    public Interval(int start, int end, int index){
        this.start = start;
        this.end = end;
        this.index=index;
    }
    @Override
    public int compareTo(Interval interval){
        if(this.start == interval.start){
            return this.end-interval.end;
        }
        return this.start-interval.start;
    }
}
public class Solution{
    public static String solve(Interval[] arr){
        Arrays.sort(arr);
        String[] ans = new String[arr.length];
        
        Interval a=null,b=null;

        for(int i=0; i<arr.length; i++){
            Interval itr = arr[i];
            if(a==null){
                a=itr;
                ans[itr.index] = "C";
            } else if (b==null){
                b=itr;
                ans[itr.index] = "J";
            } else {
                //if no overlap with a
                if(itr.start>= a.end){
                    a = itr;
                    ans[itr.index] = "C";
                } else if(itr.start>=b.end){ // if no overlap with b
                    b = itr;
                    ans[itr.index] = "J";
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for(String itr: ans){
            str.append(itr);
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int it = 1;
        while(it<=t){
            int n = s.nextInt();
            Interval[] arr = new Interval[n];
            for(int i=0;i<n;i++){
                arr[i] = new Interval(s.nextInt(), s.nextInt(),i);
            }
            String ans = solve(arr);
            System.out.println("Case #"+it+": "+ans);
            it++;
        }
    }
}