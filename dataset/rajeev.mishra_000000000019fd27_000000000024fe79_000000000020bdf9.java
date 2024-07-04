
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class TestTime {
        int startTime;
        int endTime;

        public boolean isNotOverlapping(TestTime time) {
            return (this.startTime < time.startTime && this.endTime <= time.startTime)
                    || (time.startTime < this.startTime && time.endTime <= this.startTime) ;
        }

        public TestTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TestTime time = (TestTime) o;

            if (startTime != time.startTime) return false;
            return endTime == time.endTime;
        }

        @Override
        public int hashCode() {
            int result = startTime;
            result = 31 * result + endTime;
            return result;
        }

        @Override
        public String toString() {
            return "TT{" +
                    "sT=" + startTime +
                    ",eT=" + endTime +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int noTestCases = in.nextInt();
            for (int i = 0; i < noTestCases; i++) {
                int n = in.nextInt();
                ArrayList<TestTime> timeOrder = new ArrayList<>();
                ArrayList<TestTime> tempList = new ArrayList<>();
                HashMap<TestTime, String> map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    int startTime = in.nextInt();
                    int endTime = in.nextInt();
                    timeOrder.add(new TestTime(startTime, endTime));
                }

                tempList.addAll(timeOrder);
                Collections.sort(tempList, Comparator.comparingInt(testTime -> testTime.startTime));
                TestTime time = tempList.get(0);
                map.put(tempList.get(0), "C");
                tempList.remove(0);
                for (int w = 0; w < tempList.size(); w++) {
                    if(time.isNotOverlapping(tempList.get(w))) {
                        TestTime newTime = tempList.remove(w);
                        map.put(newTime, "C");
                        time = newTime;
                    }
                }

                Collections.sort(tempList, Comparator.comparingInt(testTime -> testTime.startTime));
                if(tempList.size() > 0) {
                    time = tempList.get(0);
                    map.put(time, "J");
                    tempList.remove(0);
                    for (int w = 0; w < tempList.size(); w++) {
                        if(time.isNotOverlapping(tempList.get(w))) {
                            TestTime newTime = tempList.remove(w);
                            map.put(newTime, "J");
                            time = newTime;
                        }
                    }
                }

                //System.out.println(tempList);

                if(tempList.size() == 1) {
                    if(time.isNotOverlapping(tempList.get(0))) {
                        TestTime newTime = tempList.remove(0);
                        map.put(newTime, "J");
                    }
                }



                //System.out.println(map);
                String output = "";

                for (int j = 0; j < timeOrder.size() ; j++) {
                    output += map.getOrDefault(timeOrder.get(j), "");
                }

                if(tempList.size() > 0) {
                    output="IMPOSSIBLE";
                }

                System.out.println("Case #"+(i+1)+": "+output);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}