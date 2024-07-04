import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int cases;
        try {
            cases = Integer.parseInt(br.readLine().trim());
            for (int j = 0; j < cases; j++) {
                int n = Integer.parseInt(br.readLine());

                Pair[] tasks = new Pair[n];
                Map<Pair,Integer> origin = new HashMap<>();

                for (int task = 0; task < n; task++) {
                    String[] strTime = br.readLine().split(" ");
                    int s = Integer.parseInt(strTime[0]);
                    int e = Integer.parseInt(strTime[1]);
                    tasks[task] = new Pair(s,e);
                    origin.put(tasks[task], task);
                }


                char[] sequence = new char[n];

                Arrays.sort(tasks);
                int i = 0;

                Pair[] CJ = new Pair[2];
                CJ[0] = new Pair(0,0);
                CJ[1] = new Pair(0,0);
                boolean impossible = false;

                while (i < tasks.length) {
                    if (tasks[i].start < CJ[0].end &&
                        tasks[i].start < CJ[1].end) {
                            impossible = true;
                            break;
                    } else {
                        if (CJ[0].end <= CJ[1].end) {
                            CJ[0] = tasks[i];
                            sequence[origin.get(tasks[i])] = 'C';
                        } else {
                            CJ[1] = tasks[i];
                            sequence[origin.get(tasks[i])] = 'J';
                        }
                        i++;
                    }
                }
                String output = impossible ? "IMPOSSIBLE" : new String(sequence) ;
                System.out.println(String.format("Case #%d: %s", j+1, output));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Pair implements Comparable<Pair>{
    int start;
    int end;
    Pair(int x, int y) {
        this.start = x;
        this.end = y;
    }

    public int compareTo(Pair p1) {
        return this.start - p1.start;
    }
}