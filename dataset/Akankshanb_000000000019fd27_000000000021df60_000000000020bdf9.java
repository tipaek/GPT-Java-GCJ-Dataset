import java.util.*;
import java.io.*;
class Solution{
    static int len = 0;
    public static String schedule(List<int[]> times){
        List<String> res = new ArrayList<>();
        len = times.size();
        Collections.sort(times, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               return a[0] - b[0];
           }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        boolean JFull = false, CFull = false;
        //0 is J and 1 is C
        for(int[] time: times){
            if(pq.isEmpty()){
                int[] item = new int[]{time[0], time[1], 0};
                pq.add(item);
                JFull = true;
                res.add("J");
                continue;
            }
            int[] top = pq.peek();
            if(top[1] <= time[0]){
                int[] item = pq.poll();
                if(item[2]==0){
                    JFull = false;
                }
                else if(item[2]==1){
                    CFull = false;
                }
            }
            int whichItem = 0;
            if(!JFull) {
                whichItem = 0;
                JFull = true;
                res.add("J");
            }
            else if(!CFull) {
                whichItem = 1;
                CFull = true;
                res.add("C");
            }
            int[] item = new int[]{time[0], time[1], whichItem};
            pq.add(item);

        }
        return parseList(res);

    }
    public static String parseList(List<String> res){
        StringBuilder sb = new StringBuilder();
        if(res.size()!=len) return "IMPOSSIBLE";
        for(String s: res){
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<int[]> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                int start = in.nextInt();
                int end = in.nextInt();
                list.add(new int[]{start, end});
            }
            System.out.println("Case #" + i + ": " + schedule(list));
        }
    }

}