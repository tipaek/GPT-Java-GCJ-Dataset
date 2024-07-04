    import java.util.*;
    import java.io.*;
    public class Solution {
        static class Interval{
        int begin;
        int end;
        Interval(int begin, int end){
            this.begin= begin;
            this.end = end;
        }
    }

    static boolean checkOverlap(Interval t1, Interval t2) {
        return Math.max(t1.begin,t2.begin) < Math.min(t1.end,t2.end);
    }

    static boolean checkListOverlap(List<Interval> list2, Interval x){
        for (int k=0;k<list2.size();k++)
        {
            if (checkOverlap(x, list2.get(k)))
            {
               return false;
            }
        }
        return true;
    }
    static String divideIntervals(List<Interval> list)
    {
        ArrayList<Interval> cList = new ArrayList();
        ArrayList<Interval> jList = new ArrayList();
        String output="";
        if(list.size() > 0){
            cList.add(list.get(0));
            output+="C";
        }

        for (int j=1;j<list.size();j++)
        {
            if(checkListOverlap(cList, list.get(j)))
            {
                cList.add(list.get(j));
                output+="C";
                continue;
            }

            if(checkListOverlap(jList, list.get(j)))
            {
                jList.add(list.get(j));
                output+="J";
                continue;
            }
            return "IMPOSSIBLE";
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<n; i++){
            int count = scanner.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();
            for(int j=0; j<count; j++)
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            System.out.println("Case #"+(i+1)+": " +divideIntervals(intervals));
        }
    }
    }
      