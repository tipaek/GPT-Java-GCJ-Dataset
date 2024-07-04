import java.util.*;
public class Solution {
    public static class Time implements Comparable<Time> {
        public int start;
        public int end;
        public int index;
        public Time(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
        @Override
        public int compareTo(Time other){
            return this.start - other.start;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        for (int i = 0; i < cases; i++){
            int activities = sc.nextInt();
            Time[] arr = new Time[activities];
            for (int j = 0; j < arr.length; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                arr[j] = new Time(start,end,j);
            }
            Arrays.sort(arr);
            results[i] = "Case #" + (i+1) + ": " + arrange(arr);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static String arrange(Time[] arr){
        char[] getString = new char[arr.length];
        int J = -1;
        int C = -1;
        for (int i = 0; i < arr.length; i++){
            if (J <= arr[i].start){
                J = arr[i].end;
                getString[arr[i].index] = 'J';
            }
            else if (C <= arr[i].start) {
                C = arr[i].end;
                getString[arr[i].index] = 'C';
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        String result = new String(getString);
        return result;
    }
}