import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Interval {
    int start;
    int end;
    int originalIndex;
    char owner;
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
            boolean possible = intervalScheduling(intervals);
            if(possible){
                Collections.sort(intervals, new IntervalIndexComparator());
                for(Interval interval: intervals){
                    output += interval.owner;
                }
            }
            else{
                output = "IMPOSSIBLE";
            }
            System.out.println("Case #" + caseNumber + ": " + output);
            caseNumber++;
        }
    }

    private static boolean intervalScheduling(ArrayList<Interval> intervals) {
        ArrayList<Interval> results = new ArrayList<>();
        int latestCameroonJobTime = 0, latestJamieJobTime = 0;
        for(Interval currentInterval : intervals){
            int cameroonDiff = currentInterval.start - latestCameroonJobTime;
            int jamieDiff = currentInterval.start - latestJamieJobTime;
            if(cameroonDiff < 0 && jamieDiff >= 0){
                latestJamieJobTime = currentInterval.end;
                currentInterval.owner = 'J';
            }
            else if(jamieDiff < 0 && cameroonDiff >= 0){
                latestCameroonJobTime = currentInterval.end;
                currentInterval.owner = 'C';
            }
            else if(jamieDiff >= 0 && cameroonDiff >=0){
                if(jamieDiff < cameroonDiff){
                    latestJamieJobTime = currentInterval.end;
                    currentInterval.owner = 'J';
                }
                else{
                    latestCameroonJobTime = currentInterval.end;
                    currentInterval.owner = 'C';
                }
            }
            else{
                return false;
            }
        }

        return true;
    }
}