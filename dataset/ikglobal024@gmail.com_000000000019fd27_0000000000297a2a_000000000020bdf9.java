import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        int min = 24*60;

        for (int t=1; t<=T; t++) {
            int tasks = in.nextInt();
            LinkedList<Integer> cl = new LinkedList<>();
            LinkedList<Integer> jl = new LinkedList<>();
            for (int i=0; i<= min; i++) {
                cl.add(i);
                jl.add(i);
            }
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            for (int i=1; i <= tasks; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

               if (isImpossible) continue;

                if (isAvailable(cl, start, end)) {
                    remove(cl, start, end);
                    result.append("C");
                } else if (isAvailable(jl, start, end)) {
                    remove(jl, start, end);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + t +": " + result.toString());
        }
    }

    private static boolean isAvailable(LinkedList<Integer> person, int start, int end) {
        return  (person.contains(start) && person.contains(end));
    }

    private static void remove(LinkedList<Integer> person, int start, int end) {
        for (int i=start; i<end; i++) {
            person.removeFirstOccurrence(i);
        }
    }

}
