import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static class Time{
        int start;
        int end;
        int index;
        public int getStart() {
            return this.start;
        }
    }

    public static boolean isoverlap(Time t1, Time t2)
    {
        if(t2.end>t1.start && t1.end>t2.start) return true;
        return false;
    }

    public static boolean check_conflict(List<Time> myList, Time time){
        for(int i=0;i<myList.size();i++){
            if(isoverlap(myList.get(i),time))
                return false;
        }
        return true;
    }
    public static String calculate(List<Time> totalList){
        List<Time> Cameron_Sceh = new ArrayList<>();
        List<Time> Jamie_Sceh = new ArrayList<>();
        String[] result = new String[totalList.size()];
        result[totalList.get(0).index] = "C";
        Cameron_Sceh.add(totalList.get(0));

        for(int i=1;i<totalList.size();i++){
            Time time = totalList.get(i);
            int index = time.index;
            if(check_conflict(Cameron_Sceh,time)){
                result[time.index] = "C";
                Cameron_Sceh.add(time);
                continue;
            }
            if(check_conflict(Jamie_Sceh,time)){
                result[time.index] = "J";
                Jamie_Sceh.add(time);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return Arrays.toString(result);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        String[] result = new String[t];
        for (int i = 0; i <t; i++) {
            int size = in.nextInt();
            // Case starts
            List<Time> totaList = new ArrayList<>();
            Time time = null;
            for (int j = 0; j < size; j++) {
                time = new Time();
                time.start = in.nextInt();
                time.end = in.nextInt();
                time.index = j;
                totaList.add(time);
            }
            List<Time> sortedList= new ArrayList<>();
            sortedList = totaList.stream()
                    .sorted(Comparator.comparing(Time::getStart))
                    .collect(Collectors.toList());
            result[i] =calculate(sortedList);

        }



        for(int i=1;i<=t;i++){
            System.out.print("Case #" + i + ": " + result[i-1].replaceAll("[^a-zA-Z0-9]", ""));
            if(i!=t)
                System.out.println("");
        }
    }
}

