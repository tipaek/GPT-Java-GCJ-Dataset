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
        public String toString(){
            return "["+begin + " "+ end+"]";
        }
    }

    static boolean checkOverlap(Interval t2, Interval t1)
    {
        if (t1.begin<=t2.begin && t1.end>t2.begin) return true;
        if (t1.begin<t2.begin && t1.end>=t2.end) return true;
        if (t1.begin>=t2.begin && t1.end<=t2.end) return true;
        return false;
    }

    static String divideIntervals(List<Interval> list)
    {
        ArrayList<Interval> cList = new ArrayList();
        ArrayList<Interval> jList = new ArrayList();
        String output="";
        for (int j=0;j<list.size();j++)
        {
            if (j==0)
            {
                cList.add(list.get(j));
                output+="C";
                continue;
            }

            boolean canAdd = true;

            for (int k=0;k<cList.size();k++)
            {
                if (checkOverlap(list.get(j), cList.get(k)))
                {
                    canAdd = false;
                    break;
                }
            }

            if(canAdd)
            {
                cList.add(list.get(j));
                output+="C";
                continue;
            }

            canAdd = true;
            for (int k=0;k<jList.size();k++)
            {
                if (checkOverlap(list.get(j), jList.get(k)))
                {
                    canAdd = false;
                    break;
                }
            }

            if(!canAdd) {
                return "IMPOSSIBLE";
            }
            
            jList.add(list.get(j));
            output+="J";

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
      