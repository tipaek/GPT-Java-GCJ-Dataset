import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();

        for (int j = 0; j < tests; j++) {
            int activities = in.nextInt();
            Hashtable<Integer, Integer> times = new Hashtable<>();
            Hashtable<Integer, Integer> index = new Hashtable<>();
            List<Integer> startTimes = new ArrayList<>();

            for (int i = 0; i < activities; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

                index.put(start, i);
                times.put(start, end);
                startTimes.add(start);
            }

            Collections.sort(startTimes);
            boolean[] person = new boolean[activities];
            int last = 0;

            person[index.get(startTimes.get(0))] = true;
            for (int i = 1; i < activities; i++) {
                if (startTimes.get(i) >= times.get(startTimes.get(last))) {
                    person[index.get(startTimes.get(i))] = true;
                    last = i;
                }
            }

            boolean possible = true;
            last = -1;
            for (int i = 0; i < activities; i++) {
                if (last == -1 && !person[index.get(startTimes.get(i))]) {
                    last = i;
                } else if (!person[index.get(startTimes.get(i))]) {
                    if (startTimes.get(i) < times.get(startTimes.get(last))) {
                        possible = false;
                    }
                }
            }

            System.out.print(String.format("Case #%d: ", j+1));

            if (possible) {
                for (int i = 0; i < activities; i++) {
                    if (person[i]){
                        System.out.print('C');
                    }else{
                        System.out.print('J');
                    }

                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

}