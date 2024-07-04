
import java.util.Arrays;
import java.util.Scanner;
class Interval implements Comparable<Interval>{
    int start,end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
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
        StringBuilder ans = new StringBuilder();
        
        Interval a=null,b=null;

        for(int i=0; i<arr.length; i++){
            Interval itr = arr[i];
            if(a==null){
                a=itr;
                ans.append("C");
            } else if (b==null){
                b=itr;
                ans.append("J");
            } else {
                //if no overlap with a
                if(itr.start>= a.end){
                    a = itr;
                    ans.append("C");
                } else if(itr.start>=b.end){ // if no overlap with b
                    b = itr;
                    ans.append("J");
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int it = 1;
        while(it<=t){
            int n = s.nextInt();
            Interval[] arr = new Interval[n];
            for(int i=0;i<n;i++){
                arr[i] = new Interval(s.nextInt(), s.nextInt());
            }
            String ans = solve(arr);
            System.out.println("Case #"+it+": "+ans);
            it++;
        }
    }
}