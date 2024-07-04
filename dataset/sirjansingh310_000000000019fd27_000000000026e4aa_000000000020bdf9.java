import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Interval {
    int start;
    int end;
    int originalIndex;
    char owner = 'N'; // not assigned
    Interval(int start, int end, int originalIndex){
        this.start = start;
        this.originalIndex = originalIndex;
        this.end = end;
    }

    public String toString(){
        return this.start + " " + this.end;
    }
}

class FinishTimeComparator implements Comparator<Interval>{

    public int compare(Interval o1, Interval o2) {
        return o1.end - o2.end;
    }
}

class IntervalIndexComparator implements  Comparator<Interval>{

    public int compare(Interval o1, Interval o2) {
        return o1.originalIndex - o2.originalIndex;
    }
}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            ArrayList<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                intervals.add(new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
            }
            String output = "";
            Collections.sort(intervals, new FinishTimeComparator());
            ArrayList<Interval> cameronList = intervalScheduling(intervals, 'C');
            ArrayList<Interval> jamieList = intervalScheduling(intervals, 'J');
           if(cameronList.size() + jamieList.size() < n){
               output = "IMPOSSIBLE";
           }
           else if(cameronList.size() + jamieList.size() == n){
               Collections.sort(intervals, new IntervalIndexComparator());
               for(Interval current : intervals){
                   output += current.owner;
               }
           }
            System.out.println("Case #" + caseNumber + ": " + output);
           caseNumber++;
        }
    }

    private static ArrayList<Interval> intervalScheduling(ArrayList<Interval> intervals, char ch) {
        ArrayList<Interval> results = new ArrayList<>();

        for(Interval current : intervals){
            if(current.owner != 'N'){
                continue;
            }
            if(results.size() == 0){
                results.add(current);
                current.owner = ch;
            }
            else{
                if(current.start >= results.get(results.size() - 1).end) {
                    results.add(current);
                    current.owner = ch;
                }
            }
        }
        return results;
    }
}