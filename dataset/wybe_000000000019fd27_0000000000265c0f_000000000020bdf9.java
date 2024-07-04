import java.util.*;
import java.io.*;
public class Solution {
   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int[] N = new int[t];
        ArrayList<int[]> starting_times = new ArrayList<int[]>();
        ArrayList<int[]> ending_times = new ArrayList<int[]>();
        ArrayList<String> answers = new ArrayList<String>();


        for (int i = 0; i < t; i++) {
            N[i] = in.nextInt();
            int[] start = new int[N[i]];
            int[] end = new int[N[i]];
            for (int j = 0; j < N[i]; j++) {
                start[j] = in.nextInt();
                end[j] = in.nextInt();
            }
            starting_times.add(start);
            ending_times.add(end);
        }
        for (int i = 0; i < t; i++) {
            ArrayList<Interval> intervals = new ArrayList<Interval>();
            for (int j = 0; j < N[i]; j++) {
                intervals.add(new Interval(starting_times.get(i)[j], ending_times.get(i)[j], j));
            }
            intervals.sort((x, y) -> Integer.compare(x.startTime, y.startTime));

//            for (int m = 0; m < intervals.size(); m++) {
//                System.out.println(intervals.get(m).toString());
//            }

            int J = 0;
            int C = 0;
            HashSet<Integer> C_list = new HashSet<Integer>();
            HashSet<Integer> J_list = new HashSet<Integer>();


            String sol = "";
            boolean skip2 = true;
            for(int j = 0; j < intervals.size(); j++){
                if(J > intervals.get(j).startTime && C > intervals.get(j).startTime){
                    sol = "IMPOSSIBLE";
                    skip2 = false;
                    answers.add(sol);
                    break;
                }
                if(J <= intervals.get(j).startTime){
                    J = intervals.get(j).endTime;
                    J_list.add(intervals.get(j).index);
                    continue;
                }
                if(C <= intervals.get(j).startTime){
                    C = intervals.get(j).endTime;
                    C_list.add(intervals.get(j).index);

                    continue;
                }
            }
            if(skip2) {
                String actualsol = "";
                for (int j = 0; j < intervals.size(); j++) {
                    if (C_list.contains(j)) {
                        actualsol += "C";
                    }
                    if (J_list.contains(j)) {
                        actualsol += "J";
                    }
                }
                answers.add(actualsol);

            }


        }

        for(int i = 0; i < t; i ++){
            int cas = i + 1;
            System.out.println("Case #" + cas + ": " + answers.get(i));
        }

    }

    public static class Interval{
        public int startTime;
        public int endTime;
        public int index;

        public Interval(int start, int end, int i){
            this.startTime = start;
            this.endTime = end;
            this.index = i;
        }

        public String toString(){
            String s = "Interval " + startTime + " " + endTime;
            return s;
        }

    }

}