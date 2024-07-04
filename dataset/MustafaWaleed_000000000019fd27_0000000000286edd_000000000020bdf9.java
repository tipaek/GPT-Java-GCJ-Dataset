import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder output = new StringBuilder();
        int t = reader.nextInt();
        int caseNumber = 1;
        while (t-- > 0) {
            int numberOfActivities = reader.nextInt();
            ParentingPartneringReturns parentingPartneringReturns
                    = new ParentingPartneringReturns(reader, output, caseNumber, numberOfActivities);
            parentingPartneringReturns.solve();
            caseNumber++;
        }
        System.out.print(output);
    }
}

class ParentingPartneringReturns {
    final String CANT = "IMPOSSIBLE";
    final String CAMERON = "C";
    final String JAMIE = "J";
    final int DAY = 24 * 60 + 1;
    FastReader reader;
    StringBuilder output;
    StringBuilder schedule;
    int caseNumber;
    int numberOfActivities;
    Activitie[] activities;
    boolean jamieSchedule[] = new boolean[DAY];
    boolean cameronSchedule[] = new boolean[DAY];


    public ParentingPartneringReturns(FastReader reader, StringBuilder output, int caseNumber, int numberOfActivities) {
        this.reader = reader;
        this.output = output;
        this.caseNumber = caseNumber;
        this.numberOfActivities = numberOfActivities;
        this.activities = new Activitie[numberOfActivities];
        this.schedule = new StringBuilder();
    }

    public void solve() {
        this.readActivities();
        this.sortActivities();
        this.setSchedule();
        output.append("Case #")
                .append(caseNumber).append(": ")
                .append(schedule)
                .append("\n");
    }

    void readActivities() {
        for (int i = 0; i < numberOfActivities; i++) {
            activities[i] = new Activitie(reader.nextInt(), reader.nextInt());
        }
    }


    void sortActivities(){
        Arrays.sort(activities);
    }

    void setSchedule() {
        int startTime = 0;
        int endTime = 0;
        for (int i = 0; i < numberOfActivities; i++) {
            startTime = activities[i].start;
            endTime = activities[i].end;
            if(!cameronSchedule[startTime] || !cameronSchedule[endTime]) {
                setCameronScheduleFull(startTime,endTime);
                schedule.append(CAMERON);
            }else if(!jamieSchedule[startTime] || !jamieSchedule[endTime]) {
                setJamieScheduleFull(startTime,endTime);
                schedule.append(JAMIE);
            }else {
             schedule = new StringBuilder(CANT);
             break;
            }
        }
    }

    void setCameronScheduleFull(int start,int end) {
        for(int minute = start; minute < end; minute++){
            cameronSchedule[minute] = true;
        }
    }

    void setJamieScheduleFull(int start,int end) {
        for(int minute = start; minute < end; minute++){
            jamieSchedule[minute] = true;
        }
    }


}

class Activitie implements Comparable<Activitie> {
    int start;
    int end;

    Activitie(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activitie o) {
        if (this.start != o.start) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
