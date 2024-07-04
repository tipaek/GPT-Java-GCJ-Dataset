import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            Job[] jobs = new Job[n];
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                jobs[i] = new Job(start, end);
            }
            Arrays.sort(jobs);
            char[] persons = {'C', 'J'};
            int[] freeTime = new int[2];
            int personIndex = 0;
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (freeTime[personIndex] <= jobs[i].start) {
                    freeTime[personIndex] = jobs[i].end;
                    result.append(persons[personIndex]);
                } else {
                    personIndex = (personIndex + 1) % 2;
                    if (freeTime[personIndex] > jobs[i].start) {
                        result = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                        break;
                    } else {
                        freeTime[personIndex] = jobs[i].end;
                        result.append(persons[personIndex]);
                    }
                }
            }
            System.out.println("Case #" + tc + ": " + result);
        }
    }

    static class Job implements Comparable<Job> {
        int start, end;

        Job(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Job other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}