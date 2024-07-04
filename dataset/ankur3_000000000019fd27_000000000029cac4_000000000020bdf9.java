
import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int total = t;
        while (t-- >0) {
            int n = in.nextInt();
            List<Time> timeList = new ArrayList<>();
            for (int i=0;i<n;i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                timeList.add(new Time(start,end));
            }

            Collections.sort(timeList, new Comparator<Time>() {
                @Override
                public int compare(Time time, Time t1) {
                    return time.start.compareTo(t1.start);
                }
            });

            Time lastTimeForC=null;
            Time lastTimeForJ=null;
            boolean error=false;
            String s="";
            for (Time time : timeList) {
                if (lastTimeForC==null) {
                    lastTimeForC = time;
                    s = s.concat("C");
                } else if (lastTimeForJ==null) {
                    lastTimeForJ=time;
                    s = s.concat("J");
                } else {
                    if (time.start>=lastTimeForC.end) {
                        lastTimeForC=time;
                        s = s.concat("C");
                    } else if (time.start>=lastTimeForJ.end) {
                        lastTimeForJ=time;
                        s = s.concat("J");
                    } else {
                        error=true;
                        break;
                    }

                }
            }
            if (error) {
                System.out.println("Case #"+(total-t)+ ": " +"IMPOSSIBLE");
            } else {
                System.out.println("Case #"+(total-t)+ ": " + s);
            }
        }

    }

    static class Time{
        Integer start;
        Integer end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
