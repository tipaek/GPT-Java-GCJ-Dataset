
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCases = input.nextInt();

        for(int i = 0; i < testCases; i++){
            int N = input.nextInt();
            char[] schedule = new char[N];
            int cEnd = 0, jEnd = 0;
            boolean works = true;
            List<Time> scheduleArr = new ArrayList<>();
            for(int j = 0; j < N; j++){
                int start = input.nextInt();
                int end = input.nextInt();
                scheduleArr.add(new Time(start, end, j));
            }
            Collections.sort(scheduleArr);
            for(Time t : scheduleArr){
                if(cEnd <= t.start){
                    schedule[t.index] = 'C';
                    cEnd = t.end;
                }
                else if(jEnd <= t.start){
                    schedule[t.index] = 'J';
                    jEnd = t.end;
                }
                else{
                    works = false;
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", i+1, works ? String.valueOf(schedule) : "IMPOSSIBLE");
        }
    }

    static class Time implements Comparable<Time>{
        public int start;
        public int end;
        public int index;

        public Time(int s, int e, int i){
            start = s;
            end = e;
            index = i;
        }

        @Override
        public int compareTo(Time t){
            if(start < t.start){
                return -1;
            }
            else if(start > t.start){
                return 1;
            }
            else{
                return 0;
            }
        }

    }
}
