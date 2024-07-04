import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        int i = 0 ;

        while(i < t) {

            int n = in.nextInt();

            List<TimeObj> timeObjs = new ArrayList<>();

            for(int j = 0 ; j < n ; ++j) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                timeObjs.add(new TimeObj(startTime,endTime,j));
            }

            Collections.sort(timeObjs, Comparator.comparing(TimeObj::getStartTime));

            int cameronStartTime = -1;
            int cameronEndTime = -1;
            int jamieStartTime = -1;
            int jamieEndTime = -1;

            int ind = 0;
            String res = "";
            while(ind < n) {
                res += 'a';
                ++ind;
            }

            StringBuilder output = new StringBuilder(res);

            boolean outPutImpossible = false;

           for(int j = 0 ; j < timeObjs.size() && !outPutImpossible ; ++j) {

               int startTime = timeObjs.get(j).getStartTime();
               int endTime = timeObjs.get(j).getEndTime();
               int index = timeObjs.get(j).getIndex();

               if((cameronStartTime == -1) || (cameronEndTime <= startTime)) {
                   cameronStartTime = startTime;
                   cameronEndTime = endTime;
                   output.setCharAt(index,'C');
               }
               else if((jamieStartTime == -1) || (jamieEndTime <= startTime)) {
                   jamieStartTime = startTime;
                   jamieEndTime = endTime;
                   output.setCharAt(index,'J');
               }
               else {
                   outPutImpossible=true;
               }
           }

           if(outPutImpossible) {
               output = new StringBuilder("IMPOSSIBLE");
           }

            System.out.println("Case #"+(i+1)+": "+output);

            ++i;
        }
    }
}

class TimeObj {
    Integer startTime;
    Integer endTime;
    Integer index;
    public TimeObj(Integer startTime, Integer endTime,Integer index) {
        this.startTime=startTime;
        this.endTime=endTime;
        this.index = index;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }
    public Integer getIndex() {
        return index;
    }
}