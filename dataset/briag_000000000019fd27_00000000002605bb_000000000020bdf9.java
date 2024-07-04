import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Case
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {

            // Read size of data
            int  n = in.nextInt();

            List<Activity> activityList = new ArrayList<Activity>();

            for(int j = 0; j < n; j++) {
                Integer start = in.nextInt();
                Integer end = in.nextInt();

                activityList.add(new Activity(start, end, j));
            }

            Collections.sort(activityList, new Comparator<Activity>() {
                @Override
                public int compare(final Activity o1, final Activity o2) {
                    return o1.getFirst().compareTo(o2.getFirst());
                }
            });

            boolean possible = true;
            String result = "";


            int cEnd = 0;
            int jEnd = 0;

            for (Activity activity : activityList) {


                int startTime = activity.getFirst();
                int endTime = activity.getSecond();


                System.err.println(startTime + " " + endTime);

                if(cEnd <= startTime) {
                    cEnd = endTime;
                    activity.setAffectation("C");
                } else if (jEnd <= startTime) {
                    jEnd = endTime;
                    activity.setAffectation("J");
                } else {
                    result = "IMPOSSIBLE";
                    possible = false;
                    break;
                }

            }

            if(possible) {
                Collections.sort(activityList, new Comparator<Activity>() {
                    @Override
                    public int compare(final Activity o1, final Activity o2) {
                        return o1.getI().compareTo(o2.getI());
                    }
                });


                result = "";

                for (Activity activity: activityList
                     ) {
                    result += activity.getAffectation();
                }
            }



            System.out.println("Case #" + i + ": " + result);
        }
    }

     static class Activity {
        private Integer start;
        private Integer end;
        private Integer i;
        String affectation;

        public Activity(Integer first, Integer second, Integer i) {
            this.start = first;
            this.end = second;
            this.i = i;
        }

        public Integer getFirst() {
            return start;
        }

        public Integer getSecond() {
            return end;
        }

         public Integer getI() {
             return i;
         }

         public void setAffectation(String c) {
             affectation = c;
         }

         public String getAffectation() {
             return affectation;
         }

    }
}
  