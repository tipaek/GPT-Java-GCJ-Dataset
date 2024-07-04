import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        for(int testcase = 0; testcase < testcases; testcase++) {
            List<TimeLimit> timeSchedule = buildTimeSchedule(scan);
            organizeActivities(timeSchedule);
            System.out.println("Case #"+ (testcase+1) + ": " +getOutput(timeSchedule));
        }
    }

    public static List<TimeLimit> buildTimeSchedule(Scanner scan) {
        int size = scan.nextInt();
        List<TimeLimit> timeSchecule = new ArrayList<TimeLimit>();
        for(int count = 0; count < size; count++) {
            int start = Integer.parseInt(scan.next());
            int end = Integer.parseInt(scan.next());
            TimeLimit time = new TimeLimit(count,start,end);
            timeSchecule.add(time);
        }
        return timeSchecule;
    }

    public static void organizeActivities(List<TimeLimit> timeSchedule) {
        Collections.sort(timeSchedule);
        int cTime = 0;
        int jTime = 0;
        for(int index = 0; index < timeSchedule.size(); index++) {
            TimeLimit  time = timeSchedule.get(index);
            if(time.startTime >= jTime) {
                jTime = time.endTime;
                time.setAssignee("J");
            } else if(time.startTime >= cTime) {
                cTime = time.endTime;
                time.setAssignee("C");
            }
            else {
                time.setAssignee(null);
            }
        }
    }

    public static String getOutput(List<TimeLimit> timeSchedule) {
        Collections.sort(timeSchedule, new Comparator<TimeLimit>() {
            @Override
            public int compare(TimeLimit o1, TimeLimit o2) {
                if(o1.index < o2.index) return -1;
                else if(o1.index > o2.index) return 1;
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(TimeLimit tl : timeSchedule) {
            if(tl.getAssignee() == null) return "IMPOSSIBLE";
            else sb.append(tl.getAssignee());
        }
        return sb.toString();       
    }
}

class TimeLimit implements Comparable<TimeLimit>{
    int index;
    int startTime;
    int endTime;
    String assignee;

    public TimeLimit(int index, int start, int end) {
        this.index = index;
        this.startTime = start;
        this.endTime = end;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssignee() {
        return this.assignee;
    }

    @Override
    public int compareTo(TimeLimit o) {
        if(this.startTime > o.startTime) {
            return 1;
        } else if(this.startTime < o.startTime) {
            return -1;
        }
        return 0;
    }
}


/*

 	
Output
 
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
*/