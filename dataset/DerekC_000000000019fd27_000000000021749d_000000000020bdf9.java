import java.util.*;
import java.io.*;

class Solution {

    public static String parent(PriorityQueue<int[]> tasks, int length) {
        char[] c = new char[length];

        List<int[]> x = new ArrayList<>();
        List<int[]> y = new ArrayList<>();

        while(tasks.size() > 0) {
            int[] task = tasks.poll();
            System.out.println(task[0]);

            if(x.size() == 0) {
                x.add(task);
                continue;
            } else {
                int[] last = x.get(x.size()-1);
                if(task[0] >= last[1]) {
                    x.add(task);
                    continue;
                }
            }


            if(y.size() == 0) {
                y.add(task);
                continue;
            } else {
                int[] last = y.get(y.size()-1);
                if(task[0] >= last[1]) {
                    y.add(task);
                    continue;
                }
            }

            return "IMPOSSIBLE";
        }

        for(int[] i : x) {
            c[i[2]] = 'C';
        }
        for(int[] i : y) {
            c[i[2]] = 'J';
        }

        return String.valueOf(c);
    }
    public static void main(String[] args) throws Exception {
        // File file = new File("./input.txt");
        // Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt(); //# of testcases

        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();       
            PriorityQueue<int[]> pq = new PriorityQueue<>(N, (a, b) -> a[0] - b[0]);

            for(int j = 0; j < N; j++) {
                int[] tuple = new int[3];
                tuple[0] = in.nextInt();
                tuple[1] = in.nextInt();
                tuple[2] = j;
                pq.offer(tuple);
            }
            
            System.out.println("Case #" + i + ": " + parent(pq, N));
        }
        in.close();
    }
}