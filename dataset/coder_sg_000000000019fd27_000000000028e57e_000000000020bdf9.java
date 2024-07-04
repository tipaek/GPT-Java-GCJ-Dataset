import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Activity {
    int id;
    int startTime;
    int endTime;

    public Activity(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }
    
    public int getStartTime() {
        return startTime;
    }
    
    public int getEndTime() {
        return endTime;
    }
}

class Solution {

        public static void main( String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int tC = 1; tC <= t; tC++) {
                int n = Integer.parseInt(br.readLine());
                List<Activity> start = new ArrayList<>();
                List<Activity> end = new ArrayList<>();
                
                for(int i = 0; i < n; i ++) {
                    String[] activity = br.readLine().split(" ");
                    Activity act = new Activity(i, Integer.parseInt(activity[0]), Integer.parseInt(activity[1]));
                    start.add(act);
                    end.add(act);
                }
                
                Collections.sort(start, new Comparator<Activity>() {
                    @Override
                    public int compare(Activity a1, Activity a2) {
                        return a1.getStartTime() - a2.getStartTime();
                    }
                });
                
                Collections.sort(end, new Comparator<Activity>() {
                    @Override
                    public int compare(Activity a1, Activity a2) {
                        return a1.getEndTime() - a2.getEndTime();
                    }
                });
                
                char[] assignment = new char[n];
                
                int startIndex = 1;
                int endIndex = 0;
                
                boolean[] available = new boolean[2];
                available[0] = false;
                available[1] = true;

                assignment[start.get(0).getId()] = 'C';

                boolean flag = true;

                while(startIndex < n && endIndex < n) {
                    if(start.get(startIndex).getStartTime() < end.get(endIndex).getEndTime()) {
                        if(available[0]) {
                            assignment[start.get(startIndex).getId()] = 'C';
                            available[0] = false;
                        }
                        else if(available[1]) {
                            assignment[start.get(startIndex).getId()] = 'J';
                            available[1] = false;
                        }
                        else {
                            flag = false;
                        }
                        startIndex++;
                    }
                    else if(start.get(startIndex).getStartTime() > end.get(endIndex).getEndTime()) {
                        char c = assignment[end.get(endIndex).getId()];
                        if(c == 'C')
                            available[0] = true;
                        else
                            available[1] = true;
                        endIndex++;
                    }
                    else {
                        char c = assignment[end.get(endIndex).getId()];
                        if(c == 'C')
                            available[0] = true;
                        else
                            available[1] = true;
                        endIndex++;
                        
                        if(available[0]) {
                            assignment[start.get(startIndex).getId()] = 'C';
                            available[0] = false;
                        }
                        else if(available[1]) {
                            assignment[start.get(startIndex).getId()] = 'J';
                            available[1] = false;
                        }
                        startIndex++;
                    }
                }

                StringBuilder result = new StringBuilder();
                if(!flag)
                    result.append("IMPOSSIBLE");
                else
                    for(char c : assignment)
                        result.append(c);
                    
                sb.append("Case #"+tC+": "+result+"\n");
            }
            System.out.println(sb);
    } 
}
