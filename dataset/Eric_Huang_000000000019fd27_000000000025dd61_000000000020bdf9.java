

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static HashMap<Integer, LinkedList<Integer>> graph;
    static HashMap<Integer, Integer> colour; // 0 for none, 1 for c, 2 for j
    static int[][]times;

       public static boolean timeOverlap(int start1, int end1, int start2, int end2){

        return (end1 > start2 && end1 < end2) || (end2 > start1 && end2 < end1)
                || (start1 > start2 && start1 < end2) || (start2 > start1 && start2 < end1);

    }

    public static boolean bfs(int size){

        colour = new HashMap<>();
        boolean[] unsettled = new boolean[size];
        int ptr = 0;

        while(ptr < size){

            if(!unsettled[ptr]){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(ptr);
                colour.put(ptr, 0);
                while (!queue.isEmpty()) {

                    int next = queue.poll();
                    int vertexColour = colour.get(next);

                    for (Integer a : graph.get(next)) {
                        unsettled[a] = true;

                        if(colour.get(a) == null){
                            queue.add(a);
                            colour.put(a, (vertexColour + 1) % 2);
                            continue;
                        }

                        if(colour.get(a) == vertexColour){
                            return false;
                        }

                    }

                }


            }
            ptr++;
        }

        return true;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {

            int activities = scan.nextInt();
            times = new int[activities][2];

            graph = new HashMap<>();
            colour = new HashMap<>();

            for (int j = 0; j < activities; j++) {

                times[j][0] = scan.nextInt();
                times[j][1] = scan.nextInt();

                graph.put(j, new LinkedList<>());
                colour.put(j, 0);

                for (int k = 0; k < j; k++) {
                    if(timeOverlap(times[k][0], times[k][1], times[j][0], times[j][1])){
                        graph.get(k).add(j);
                        graph.get(j).add(k);
                    }
                }

            }

            boolean bfs = bfs(activities);
            String out = "";

            if(bfs){

                for (int j = 0; j < activities; j++) {
                    out += colour.get(j) == 0 ? "C" : "J";
                }

            } else {
                out = "IMPOSSIBLE";
            }
            System.out.printf("Case #%d: %s\n", i + 1, out);
        }

    }

}
