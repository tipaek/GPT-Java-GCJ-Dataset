import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Parenting Partnering Returns
public class Solution {

    public static void main(String[] args) {
        Comparator<Activity> comparator = new Comparator<Activity>() {
            public int compare(Activity a1, Activity a2) {
                int diff = a1.start - a2.start;
                return (diff == 0) ? (a1.id - a2.id) : diff;
            }
        };
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            Activity[] A = new Activity[N];
            for (int n=0; n<N; n++) {
                Activity a = new Activity();
                a.id = n;
                a.start = in.nextInt();
                a.end = in.nextInt();
                A[n] = a;
            }
            Arrays.sort(A, comparator);
            int J = 0;
            int C = 0;
            boolean impossible = false;
            for (Activity a : A) {
                int start = a.start;
                int end = a.end;
                if (start >= J) {
                    a.owner = 'J';
                    J = end;
                } else if (start >= C) {
                    a.owner = 'C';
                    C = end;
                } else {
                    impossible = true;
                    break;
                }
            }
            String answer;
            if (impossible) {
                answer = "IMPOSSIBLE";
            } else {
                char[] S = new char[N];
                for (Activity a : A) {
                    S[a.id] = a.owner;
                }
                answer = new String(S);
            }
            System.out.printf("Case #%d: %s\n", t, answer);
        }
    }

    static class Activity {
        int start;
        int end;
        int id;
        char owner;
    }

}
