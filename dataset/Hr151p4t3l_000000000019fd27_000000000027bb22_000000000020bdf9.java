import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
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

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();

        int T = 0;
        T = input.nextInt();
        if(T > 100 || T < 1) {
            return;
        }

        outer :
            for(int i = 0; i < T; i++) {
                int N = 0;
                N = input.nextInt();
                if(N < 2 || N > 1000) {
                    throw new Exception("G");
                }

                int startTime = 0;
                int endTime = 0;
                List<Activity> activities = new ArrayList<>();
                Person J = new Person('J');
                Person C = new Person('C');

                for (int j = 0; j < N; j++) {
                    startTime = input.nextInt();
                    endTime = input.nextInt();

                    if(startTime > endTime) {
                        break outer;
                    }
                    Activity newAct = null;
                    try {
                         newAct = new Activity(startTime, endTime);
                    } catch (Exception e) {
                        System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
                    }

                    if(j == 0) {
                        assert newAct != null;
                        newAct.setPerson((i % 2 == 0 ? J : C));
                        J.assignedActivities.add(newAct);
                    }
                    else {
                        assert newAct != null;
                        if(!newAct.doesConflictWithActivitiesOf(J)) {
                            newAct.setPerson(J);
                            J.assignedActivities.add(newAct);
                        }
                        else if(!newAct.doesConflictWithActivitiesOf(C)){
                            newAct.setPerson(C);
                            C.assignedActivities.add(newAct);
                        }
                        else if(newAct.doesConflictWithActivitiesOf(J) && newAct.doesConflictWithActivitiesOf(C)) {
                            System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
                            continue outer;
                        }
                    }
                    activities.add(newAct);
                }
                StringBuilder s = new StringBuilder();
                for(Activity act : activities) {
                    s.append(act.getPerson().getName());
                }
                System.out.println("Case #" + (i+1) + ": " + s);
            }
    }
}

class Person {
    private char name;
    List<Activity> assignedActivities;

    public Person(char name) {
        this.name = name;
        this.assignedActivities = new ArrayList<>();
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public List<Activity> getAssignedActivities() {
        return assignedActivities;
    }

    public void setAssignedActivities(List<Activity> assignedActivities) {
        this.assignedActivities = assignedActivities;
    }

    public boolean equals(Person p) {
        return (this.name == p.getName());
    }
}

class Activity {
    private int startTime;
    private int endTime;
    private Person person;

    public Activity(int startTime, int endTime) throws Exception {
        if(startTime > endTime) {
            throw new Exception("EventStartingAfterItEnds");
        }
        if(startTime > (24*60) || endTime > (24*60)) {
            throw new Exception("ActivityStartOrEndTimeGreaterThan24hrs");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean doesConflictWithActivitiesOf(Person p) {
        if(p == null) {
            return false;
        }

        List<Activity> activitiesOfP = p.getAssignedActivities();
        for(Activity act : activitiesOfP) {
            if(this.doesConflictWith(act)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesConflictWith(Activity a) {
        if(a == null) {
            return false;
        }
        if(a.startTime > this.startTime && a.startTime < this.endTime) {
            return true;
        }
        if(a.startTime < this.startTime && a.startTime > this.endTime) {
            return false;
        }
        if(a.endTime < this.endTime && a.endTime > this.startTime) {
            return true;
        }
        if(a.endTime > this.endTime && a.endTime < this.startTime) {
            return false;
        }
        if(a.startTime < this.startTime && a.endTime > this.startTime) {
            return true;
        }
        if(a.startTime > this.startTime && a.endTime < this.startTime) {
            return true;
        }
        return false;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
