import java.util.*;
import java.io.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int n = in.nextInt();
            solveParentingPartners(caseNo, n);
        }
    }

    private static class Task{
        int end;
        int person;
        public Task(int end, int person){
            this.end = end;
            this.person = person;
        }
    }

    public static void solveParentingPartners(int caseNo, int n){

        int[][] intervals = new int[n][];
        StringBuilder sb = new StringBuilder(n);
        char[] people = {'C', 'J'};


        for(int i = 0; i < n; i++){
            int[] interval = {in.nextInt(), in.nextInt()}; // start - end
            intervals[i] = interval;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        PriorityQueue<Task> heap = new PriorityQueue<>(2, (o1, o2) -> o1.end - o2.end);
        heap.add(new Task(-1, 0));
        heap.add(new Task(-1, 1));

        for(int[] interval : intervals){
            Task task= heap.poll(); // Get a person who should be free
            if(task.end > interval[0]) { // most free person is not free
                System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
                return;
            }
            sb.append(people[task.person]);
            task.end = interval[1];
            heap.add(task);
        }

        System.out.println("Case #"+ caseNo + ": " + sb.toString());

    }

    private static boolean isOverlapping(int[] o1, int[] o2){
        return o1[1] > o2[0]; // first end is later than second start
    }

    public static void solveNestingDepth(int caseNo, String line){
        StringBuilder sb = new StringBuilder(line.length());
        int openCount = 0;

        for(char ch : line.toCharArray()){
            int num = ch - '0';
            if (openCount > num){
                while (openCount != num){
                    sb.append(')');
                    openCount--;
                }
            }
            else { // openCount <= num
                while (openCount != num){
                    sb.append('(');
                    openCount++;
                }
            }
            sb.append(ch);
        }
        while (openCount > 0){
            sb.append(')');
            openCount--;
        }
        System.out.println("Case #"+ caseNo + ": " + sb.toString());
    }

    public static void solveVestigium(int caseNo, int n){
        HashSet<Integer> rows[] = new HashSet[n];
        HashSet<Integer> cols[] = new HashSet[n];

        for(int i = 0; i < n; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        HashSet<Integer> repeatedRow = new HashSet<>();
        HashSet<Integer> repeatedColumn = new HashSet<>();
        int trace = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int num = in.nextInt();
                if(!rows[i].add(num)) repeatedRow.add(i);
                if(!cols[j].add(num)) repeatedColumn.add(j);
                if(i == j) trace += num;
            }
        }

        System.out.println("Case #"+ caseNo + ": " + trace + " " + repeatedRow.size() + " " + repeatedColumn.size());
    }
}
