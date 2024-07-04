import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class TimePair implements Comparable<TimePair>{
        int start;
        int end;
        String s;
        public TimePair(int s, int e, String time) {this.start = s; this.end = e; this.s = time;}
        
        @Override
        public int compareTo(TimePair other) {
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        int numberTests;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            numberTests = Integer.valueOf(line);
            for (int i = 0; i < numberTests; i++) {
                int numTimes = Integer.valueOf(br.readLine());
                List<TimePair> times = new ArrayList<>();
                for (int j = 0; j < numTimes; j++) {
                    String time = br.readLine();
                    String[] s = time.split(" ");
                    int start = Integer.valueOf(s[0]);
                    int end = Integer.valueOf(s[1]);
                    times.add(new TimePair(start, end, time));
                }
                solution(i+1, times);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void solution(int testNumber, List<TimePair> times) {
        Map<String, String> map = new LinkedHashMap<>();
        for (TimePair pair : times)
            map.put(pair.s, "");

        Collections.sort(times);

        StringBuilder sb = new StringBuilder();
        int endC = -1, endJ = -1;

        for (TimePair pair : times) {
            if (endJ <= pair.start) {
                endJ = pair.end;
                map.replace(pair.s, "J");
            } else if (endC <= pair.start) {
                endC = pair.end;
                map.replace(pair.s, "C");
            } else {
                System.out.println("Case #"+testNumber+": IMPOSSIBLE");
                return;
            }
        }

        for (Map.Entry<String, String> eSet : map.entrySet()) {
            sb.append(eSet.getValue());
        }

        System.out.println("Case #"+testNumber+": " + sb.toString());
    }
}