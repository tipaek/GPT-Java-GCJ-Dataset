
import java.util.*;
import java.io.*;
public class Solution {

    static class Interval{
        int start;
        int end;
        int index;
        char parent;
        public Interval(int _start, int _end, int _index){
            start = _start;
            end = _end;
            index = _index;
        }
    }

    static class SortByStart implements Comparator<Interval>
    {
        public int compare(Interval intervalOne, Interval intervalTwo)
        {
            return intervalOne.start - intervalTwo.start;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            ArrayList intervals = new ArrayList<Interval>(n);
            for(int j=0; j<n;j++){
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Interval(start,end,j));
            }

            intervals.sort(new SortByStart());

            ArrayList listWithParents = findNonOverlapOrder(intervals);

            Interval firstInterval = (Interval) listWithParents.get(0);
            if(firstInterval.start == -1 && firstInterval.end == -1 ){
                System.out.println("Case #" +i + ": IMPOSSIBLE");
                continue;
            }

            char[] order = new char[listWithParents.size()];

            for(Object iv: listWithParents){
                Interval interval = (Interval) iv;
                order[interval.index] = interval.parent;
            }

            String output = new String(order);

            System.out.println("Case #" +i + ": "+output);
        }
    }

    // Input is a list of intervals sorted by start times
    public static ArrayList<Interval> findNonOverlapOrder(ArrayList<Interval> sortedList) {
        /*
        parent array denotes when the parents are free
        parent[0] => C
        parent[1] => J
         */
        int[] parent =  {-1, -1};
        
        for(int i=0; i<sortedList.size();i++){
            int start = sortedList.get(i).start;
            int end = sortedList.get(i).end;

            if(parent[0] <= start){
                parent[0] = end;
                sortedList.get(i).parent = 'C';
            }else if(parent[1]<= start){
                parent[1] = end;
                sortedList.get(i).parent = 'J';
            }else{
                ArrayList impossible = new ArrayList<Interval>();
                impossible.add(new Interval(-1,-1,0));
                return impossible;
            }
        }
        return sortedList;
    }
}