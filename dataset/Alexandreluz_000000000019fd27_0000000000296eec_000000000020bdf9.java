import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class TimePair implements Comparable<TimePair>{
        int start;
        int end;
        public TimePair(int s, int e) {this.start = s; this.end = e;}
        
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
                    String[] s = br.readLine().split(" ");
                    int start = Integer.valueOf(s[0]);
                    int end = Integer.valueOf(s[1]);
                    times.add(new TimePair(start, end));
                }
                solution(i+1, times);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void solution(int testNumber, List<TimePair> times) {
        Collections.sort(times);

        StringBuilder sb = new StringBuilder();
        int endC = -1, endJ = -1;

        for (TimePair pair : times) {
            if (endC <= pair.start) {
                sb.append("C");
                endC = pair.end;
            } else if (endJ <= pair.start) {
                sb.append("J");
                endJ = pair.end;
            } else {
                System.out.println("Case #"+testNumber+": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #"+testNumber+": " + sb.toString());
    }
}