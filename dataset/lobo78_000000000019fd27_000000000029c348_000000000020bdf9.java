import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    LinkedList<Character> assigment = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= x; i++) {
            int n = Integer.parseInt(sc.nextLine());
            LinkedList<int[]> jobs = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                String string = sc.nextLine();
                String[] arr = string.split(" ");
                int[] job = new int[2];
                job[0] = Integer.parseInt(arr[0]);
                job[1] = Integer.parseInt(arr[1]);
                jobs.add(job);
            }
            Collections.sort(jobs, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0] - t1[0];
                }
            });
            int endC = 0;
            int endJ = 0;
            boolean notPossible = false;
            StringBuilder str = new StringBuilder();
            for (int[] arr : jobs) {
                if (arr[0] >= endC) {
                    str.append('C');
                    endC = arr[1];
                } else if (arr[0] >= endJ) {
                    str.append('J');
                    endJ = arr[1];
                } else {
                    notPossible = true;
                    break;
                }
            }
            if (notPossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": "+str.toString());
            }
        }
    }
}