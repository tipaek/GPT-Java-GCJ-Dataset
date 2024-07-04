import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Solution {
    private static int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    private static StreamTokenizer streamTokenizer;

    public static void main(String[] args) throws IOException {
        streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = nextInt();
        for (int i = 0; i < numTests; i++) {
            int activities = nextInt();
            List<Pair> activitiesList = new ArrayList<>();
            for(int m = 0; m < activities; m++) {
                Pair p = new Pair(nextInt(), nextInt(), m);
                activitiesList.add(p);
            }
            check(i + 1, activitiesList);
        }
    }

    private static void check(int caseNum, List<Pair> activitiesList) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.index));
        activitiesList.sort(Comparator.comparingInt(p -> p.start));
        Deque<Pair> c = new LinkedList<>();
        Deque<Pair> j = new LinkedList<>();
        c.add(new Pair(-1, -1, -1));
        j.add(new Pair(-1, -1, -1));
        for (int i = 0; i < activitiesList.size(); i++) {
                if (c.peekFirst().end <= activitiesList.get(i).start){
                    activitiesList.get(i).setAssignedTo("C");
                    pq.add(activitiesList.get(i));
                    c.push(activitiesList.get(i));
                } else if (j.peekFirst().end <= activitiesList.get(i).start){
                    activitiesList.get(i).setAssignedTo("J");
                    pq.add(activitiesList.get(i));
                    j.push(activitiesList.get(i));
                } else {
                    pq.clear();
                    res = new StringBuilder("IMPOSSIBLE");
                    break;
                }
        }

        while (!pq.isEmpty()){
            res.append(pq.poll().assignedTo);
        }

        System.out.println("Case #" + caseNum + ": " + res);

    }

    private static class Pair{
        int start;
        int end;
        int index;
        String assignedTo;

        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public void setAssignedTo(String assignedTo) {
            this.assignedTo = assignedTo;
        }
    }
}