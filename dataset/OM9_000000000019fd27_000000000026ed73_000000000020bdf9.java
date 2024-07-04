import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        FastReader ss = new FastReader();
        int testCases = ss.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = ss.nextInt();

            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                activities.add(new Activity(ss.nextInt(), ss.nextInt(), i, 'O'));
            }
            activities.sort((Activity a1, Activity a2) -> a1.getStart() - a2.getStart());

            activities.get(0).setPerson('C');
            activities.get(1).setPerson('J');

            int cj=0;
            int jj=1;
            for (int i = 2; i < n; i++) {
                if(activities.get(i).getStart() > activities.get(cj).getFinish()){
                    activities.get(i).setPerson('C');
                }else if(activities.get(i).getStart() > activities.get(jj).getFinish()){
                    activities.get(i).setPerson('J');
                }
            }

            boolean isImpossible = activities.stream().anyMatch( activity -> 'O' == activity.getPerson());
            if(!isImpossible){
                activities.sort((Activity a1, Activity a2) -> a1.getIndex() - a2.getIndex());
            }
            String activitySchedular = activities.stream().map(Activity::getPerson).map(person -> person.toString()).collect(Collectors.joining(""));
            System.out.println("Case #" + test + ": " + ((isImpossible) ? "IMPOSSIBLE" : String.valueOf(activitySchedular)));
        }
    }

    static class Activity {
        int start;
        int finish;
        int index;
        char person;


        public Activity(int start, int finish, int index, char person) {
            this.start = start;
            this.finish = finish;
            this.index = index;
            this.person = person;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setPerson(char person) {
            this.person = person;
        }

        public char getPerson() {
            return person;
        }

        public int getIndex() {
            return index;
        }

        public int getStart() {
            return start;
        }

        public int getFinish() {
            return finish;
        }
    }

    public static void printMaxActivities(int s[], int f[], int n, char[] activitySchedular, char cj) {
        int i, j;

        i = 0;
        activitySchedular[i] = cj;
        for (j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                activitySchedular[j] = cj;
                i = j;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
}
