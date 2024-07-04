import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    int T = Integer.parseInt(scanner.nextLine());
	    for (int i = 0; i < T; i++) {
	        int N = Integer.parseInt(scanner.nextLine());
	        int[][] activities = new int[N][3];
	        String[] persons = new String[N];
	        for (int j = 0; j < N; j++) {
	            String[] row = scanner.nextLine().split(" ");
	            activities[j][0] = Integer.parseInt(row[0]);
	            activities[j][1] = Integer.parseInt(row[1]);
	            activities[j][2] = j;
            }
            Arrays.sort(activities, Comparator.comparingInt((int[] a) -> a[0]));

	        boolean impossible = false;
	        int C = activities[0][1];
	        int J = -1;
	        persons[0] = "C";
	        for (int j = 1; j < N; j++) {
	            if (activities[j][0] >= C) {
	                persons[j] = "C";
	                C = activities[j][1];
                } else if (activities[j][0] >= J) {
	                persons[j] = "J";
	                J = activities[j][1];
                } else {
	                impossible = true;
                }
            }
	        if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
	            String[] res = new String[N];
	            for (int j = 0; j < N; j++) {
	                res[activities[j][2]] = persons[j];
                }
                System.out.print("Case #" + (i + 1) + ": ");
                for (String uu: res) {
                    System.out.print(uu);
                }
                System.out.print("\n");
            }
        }

    }
}