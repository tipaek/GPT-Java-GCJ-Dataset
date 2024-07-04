import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

class Interval implements Comparable<Interval> {
    int start;
    int end;

    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval interval){
        return this.start - interval.start;
    }
}

class Solution{
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
                intervals.add(new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            char timeSlots[][] = new char[1441][2];
            boolean isEnd[] = new boolean[1441];
            boolean isStart[] = new boolean[1441];
            String output = "";
            boolean isPossible;
            for(int i = 0; i < n ; i++){
                isPossible = updateTimeSlots(timeSlots, intervals.get(i).start, intervals.get(i).end, 0, isEnd, isStart);
                if(isPossible){
                    output +="C";
                    continue;
                }
                isPossible = updateTimeSlots(timeSlots, intervals.get(i).start, intervals.get(i).end, 1, isEnd, isStart);
                if(isPossible){
                    output += "J";
                    continue;
                }
                output = "IMPOSSIBLE";
                break;
            }
            System.out.println("Case #" + caseNumber + ": " + output);
            caseNumber++;
        }
    }

    private static boolean updateTimeSlots(char timeSlots[][], int start, int end, int k, boolean isEnd[], boolean isStart[]) {
        if(k == 0){
            for(int i = start; i <= end; i++){
                if(i == start && isEnd[i] && timeSlots[i][0] == 'E'){
                    continue;
                }
                else if(i == start && isEnd[i] && timeSlots[i][0] == 'C')
                    return false;
                if(i == end && isStart[i] && timeSlots[i][0] == 'S')
                    continue;
                else if(i == end && isStart[i] && timeSlots[i][0] == 'C')
                    return false;
                if(timeSlots[i][0] == 'C')
                    return false;
            }
            for(int i = start; i <= end; i++){
                timeSlots[i][0] = 'C';
            }
            timeSlots[start][0] = 'S';
            timeSlots[end][0] = 'E';
            isEnd[end] = true;
            isStart[start] = true;
            return true;
        }
        for(int i = start; i <= end; i++){
            if(i == start && isEnd[i] && timeSlots[i][1] == 'E'){
                continue;
            }
            else if(i == start && isEnd[i] && timeSlots[i][1] == 'J'){
                return false;
            }
            if(i == end && isStart[i] && timeSlots[i][1] == 'S')
                continue;
            if(i == end && isStart[i] && timeSlots[i][1] == 'J')
                return false;

            if(timeSlots[i][1] == 'J')
                return false;
        }
        for(int i = start; i <= end; i++){
            timeSlots[i][1] = 'J';
        }
        timeSlots[start][1] = 'S';
        timeSlots[end][1] = 'E';
        isEnd[end] = true;
        isStart[start] = true;
        return true;
    }
}