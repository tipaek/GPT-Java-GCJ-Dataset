import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static class Triplet {
        int start;
        int end;
        int position;

        public Triplet(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getPosition() {
            return position;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for (int inputNumber = 1; inputNumber <= cases; ++inputNumber) {
            int activitiesCount = scanner.nextInt();
            int cameronEnd = 0;
            int jamieEnd = 0;
            char[] result = new char[activitiesCount];
            boolean isPossible = true;
            List<Triplet> triplets = new ArrayList<>();
            for (int i = 0; i < activitiesCount; i++) {
                int activityStart = scanner.nextInt();
                int activityEnd = scanner.nextInt();
                triplets.add(new Triplet(activityStart, activityEnd, i));
            }
            triplets.sort(Comparator.comparing(Triplet::getStart));

            for (Triplet triplet : triplets) {
                if (cameronEnd <= triplet.getStart()) {
                    cameronEnd = triplet.getEnd();
                    result[triplet.getPosition()] = 'C';
                } else if (jamieEnd <= triplet.getStart()) {
                    jamieEnd = triplet.getEnd();
                    result[triplet.getPosition()] = 'J';
                } else {
                    isPossible = false;
                }
            }
            System.out.println(String.format("Case #%d: %s", inputNumber, isPossible ? new String(result) : "IMPOSSIBLE"));
        }
    }
}
