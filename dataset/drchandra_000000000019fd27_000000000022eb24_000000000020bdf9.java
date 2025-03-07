import java.util.*;
import java.lang.*;

class Time implements Comparable<Time>{
    int start;
    int end;
    Time(int s, int e){
        start = s;
        end = e;
    }

    @Override
    public int compareTo(Time t) {
        if(start > t.start) return 1;
        if(start < t.start) return -1;
        return 0;
    }
    
}

public class Solution{
    public static String schedule(Time[] times){
        StringBuffer sb = new StringBuffer();
        Arrays.sort(times);
        //printTime(times);
        int n = times.length;
        int j = 0;
        int c = 0;
        for(int i=0;i<n;i++){
            if(c <= times[i].start){
                sb.append("C");
                c = times[i].end;
            }
            else if(j <= times[i].start){
                sb.append("J");
                j = times[i].end;
            }
            else{
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int tc = Integer.parseInt(scan.nextLine());
        for(int t = 1; t <= tc; t++){
            int n = Integer.parseInt(scan.nextLine());
            Time[] times = new Time[n];
            for(int i=0;i < n; i++){
                String[] words = scan.nextLine().split(" ");
                int start = Integer.parseInt(words[0]);
                int end = Integer.parseInt(words[1]);
                times[i] = new Time(start, end);
            }
            if(t != tc)
                System.out.println("Case #" + t + ": " + schedule(times));
            else
                System.out.print("Case #" + t + ": " + schedule(times));
        }
    }
}