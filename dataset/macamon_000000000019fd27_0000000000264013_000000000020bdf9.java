import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.*;
public class Solution {
    
    static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        for(int casenum = 1; casenum <= n; casenum++) {
            solve(casenum);
         }
    }
    
    private final static String JAMIE = "J";
    private final static String CAMERON = "C";
    private final static String IMPOSSIBLE = "IMPOSSIBLE";
    
    private static void solve(int casenum) {
        Integer numActivities = sc.nextInt();
        StringBuilder result = new StringBuilder();
        
        List<LocalTime[]> timetableJamie = new ArrayList<LocalTime[]>();
        List<LocalTime[]> timetableCameron = new ArrayList<LocalTime[]>();
        
        for (int i=0; i<numActivities; i++) {
            Integer startOffset = sc.nextInt();
            Integer endOffset = sc.nextInt();
            
            LocalTime start = LocalTime.MIDNIGHT.plusMinutes(startOffset);
            LocalTime end = LocalTime.MIDNIGHT.plusMinutes(endOffset);
            if (is24hoursTask(start, end)) {
                result = new StringBuilder();
                result.append(IMPOSSIBLE);
            }
        
            if (!isBusy(start, end, timetableJamie)) {
                result.append(JAMIE);
                timetableJamie.add(new LocalTime[] {start, end});
            } else if (!isBusy(start, end, timetableCameron)) {
                result.append(CAMERON);
                timetableCameron.add(new LocalTime[] {start, end});
            } else {
                result = new StringBuilder();
                result.append(IMPOSSIBLE);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(casenum);
        sb.append(": ");
        sb.append(result.indexOf(IMPOSSIBLE)>=0 ? IMPOSSIBLE : result.toString());
        System.out.println(sb);
    }
    
    private static boolean isBusy(LocalTime start, LocalTime end, List<LocalTime[]> timetable){
        for (LocalTime[] range : timetable) {
            
            if (start.isBefore(range[1]) && end.isAfter(range[0]) ||
            end.isAfter(range[0]) && end.isBefore(range[1]) ||
            start.isAfter(range[0]) && start.isBefore(range[1])) {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean is24hoursTask(LocalTime start, LocalTime end){
        
        return start.compareTo(end) == 0;
    }
    
   
    
}