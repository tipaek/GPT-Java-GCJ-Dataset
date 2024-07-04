import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String [] args) {
        Read read = new Read();
        Integer t = read.nextInt();

        for (int i = 1; i <= t; i++) {
            Integer n = read.nextInt();
            List<Activity> activityList = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                Integer s = read.nextInt();
                Integer e = read.nextInt();
                Activity activity = new Activity(j, s, e);
                activityList.add(activity);
            }

            activityList.sort(Activity::compareTo);

//            System.out.println(activityList);
            Integer c = 0, j = 0;
            for (Activity activity: activityList) {
                if(activity.getStart() >= c) {
                    c = activity.getEnd();
                    activity.setCh("C");
                } else if(activity.getStart() >= j) {
                    j = activity.getEnd();
                    activity.setCh("J");
                } else {
                    break;
                }
            }
//            System.out.println(activityList);
            activityList.sort(Comparator.comparingInt(Activity::getIndex));
            StringBuilder ans = new StringBuilder();

            for (Activity activity: activityList) {
                ans.append(activity.getCh());
            }

            if(ans.length() < n) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + ans.toString());
            }
        }
    }

    static class Read {

        BufferedReader br;
        StringTokenizer st;

        private Read() {
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

class Activity {
    Integer start;
    Integer end;
    Integer index;
    String ch;

    public Activity(Integer index, Integer start, Integer end) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.ch = "";
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", end=" + end +
                ", index=" + index +
                ", ch=" + ch +
                '}';
    }

    public int compareTo(Activity a) {
        if(start == a.start) {
            return end - a.end;
        } else {
            return start - a.start;
        }
    }
}