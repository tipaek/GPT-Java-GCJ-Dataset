import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];

            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }

            ArrayList<Character> assignments = new ArrayList<>();
            ArrayList<Integer> cStart = new ArrayList<>();
            ArrayList<Integer> cEnd = new ArrayList<>();
            ArrayList<Integer> jStart = new ArrayList<>();
            ArrayList<Integer> jEnd = new ArrayList<>();

            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (canAssign(cStart, cEnd, start[i], end[i])) {
                    assignments.add('C');
                    cStart.add(start[i]);
                    cEnd.add(end[i]);
                } else if (canAssign(jStart, jEnd, start[i], end[i])) {
                    assignments.add('J');
                    jStart.add(start[i]);
                    jEnd.add(end[i]);
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.print("Case #" + t + ": ");
                for (char ch : assignments) {
                    System.out.print(ch);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }

    private static boolean canAssign(ArrayList<Integer> startList, ArrayList<Integer> endList, int start, int end) {
        for (int i = 0; i < startList.size(); i++) {
            if ((start >= startList.get(i) && start < endList.get(i)) || (end > startList.get(i) && end <= endList.get(i))) {
                return false;
            }
        }
        return true;
    }
}