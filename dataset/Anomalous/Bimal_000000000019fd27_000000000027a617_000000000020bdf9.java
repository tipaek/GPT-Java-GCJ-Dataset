import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];

            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
            }

            ArrayList<Character> schedule = new ArrayList<>();
            ArrayList<Integer> cStart = new ArrayList<>();
            ArrayList<Integer> cEnd = new ArrayList<>();
            ArrayList<Integer> jStart = new ArrayList<>();
            ArrayList<Integer> jEnd = new ArrayList<>();

            schedule.add('C');
            cStart.add(start[0]);
            cEnd.add(end[0]);

            if (n > 1) {
                schedule.add('J');
                jStart.add(start[1]);
                jEnd.add(end[1]);
            }

            boolean impossible = false;

            for (int i = 2; i < n; i++) {
                boolean canAssignToC = true, canAssignToJ = true;

                for (int j = 0; j < cStart.size(); j++) {
                    if (isOverlapping(start[i], end[i], cStart.get(j), cEnd.get(j))) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    schedule.add('C');
                    cStart.add(start[i]);
                    cEnd.add(end[i]);
                } else {
                    for (int j = 0; j < jStart.size(); j++) {
                        if (isOverlapping(start[i], end[i], jStart.get(j), jEnd.get(j))) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        schedule.add('J');
                        jStart.add(start[i]);
                        jEnd.add(end[i]);
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (char c : schedule) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}