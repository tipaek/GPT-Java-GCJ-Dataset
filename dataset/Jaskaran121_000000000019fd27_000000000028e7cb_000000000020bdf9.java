import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Time{
        int start;
        int end;
    }

    public static boolean isoverlap(Time t1, Time t2)
    {
        if (t1.start<=t2.start && t1.end>t2.start) return true;
        if (t1.start<t2.end && t1.end>=t2.end) return true;
        if (t1.start>=t2.start && t1.end<=t2.end) return true;
        return false;
    }

    public static boolean calculate(List<Time> myList,Time time){
        for(int i=0;i<myList.size();i++){
            if(isoverlap(myList.get(i),time))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] result = new String[t];

        for (int i = 0; i <t; i++) {
            int size = in.nextInt();
            result[i] ="";
            Time time = null;
            List<Time> myListC = new ArrayList<>();
            List<Time> myListJ = new ArrayList<>();
            for(int j=0;j<size;j++){
                time = new Time();
                time.start = in.nextInt();
                time.end = in.nextInt();
                boolean flag = true;
                if(j == 0){
                    myListC.add(time);
                    result[i] = result[i] + "C";
                } else {
                    if(calculate(myListC,time)){
                        myListC.add(time);
                        result[i] = result[i] + "C";
                        continue;
                    }
                    if(calculate(myListJ,time)){
                        myListJ.add(time);
                        result[i] = result[i] + "J";
                    }else{
                        result[i] = "IMPOSSIBLE";
                        break;
                    }
                }
            }
        }
        for(int i=1;i<=t;i++){
            System.out.print("Case #" + i + ": " + result[i-1].replaceAll("[^a-zA-Z0-9]", ""));
            if(i!=t)
                System.out.println("");
        }
    }
}
