
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
                timeList.add(new Time(start,end,i));
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
            char[] ans = new char[timeList.size()];
            for (Time time : timeList) {
                if (lastTimeForC==null) {
                    lastTimeForC = time;
                    ans[time.index]='C';
                } else if (lastTimeForJ==null) {
                    lastTimeForJ=time;
                    ans[time.index]='J';
                } else {
                    if (time.start>=lastTimeForC.end) {
                        lastTimeForC=time;
                        ans[time.index]='C';
                    } else if (time.start>=lastTimeForJ.end) {
                        lastTimeForJ=time;
                        ans[time.index]='J';
                    } else {
                        error=true;
                        break;
                    }

                }
            }
            if (error) {
                System.out.println("Case #"+(total-t)+ ": " +"IMPOSSIBLE");
            } else {
                System.out.println("Case #"+(total-t)+ ": " + String.valueOf(ans));
            }
        }

    }

    static class Time{
        Integer start;
        Integer end;
        Integer index;

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

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Time(Integer start, Integer end, Integer index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}
