import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Dupla implements Comparable {
        int pos;
        char type;
        int activityId;

        public Dupla (int pos, char type, int activityId) {
            this.pos = pos;
            this.type = type;
            this.activityId = activityId;
        }

        @Override
        public int compareTo(Object o) {
            Dupla another = (Dupla)o;
            return this.pos-another.pos;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int prob = 1; prob <= N; ++prob) {
            int numCases = in.nextInt();
            List<Dupla> positions = new ArrayList<Dupla>();
            for (int i=0; i<numCases; i++) {
                positions.add(new Dupla(in.nextInt(),'s', i));
                positions.add(new Dupla(in.nextInt(),'e', i));
            }
            Collections.sort(positions);
            int countPes = 0;
            char[] output = new char[numCases];
            boolean valid = true;
            for (Dupla atual : positions) {
                if (atual.type == 's') {
                    if (countPes == 0) {
                        output[atual.activityId] = 'C';
                    }
                    if (countPes == 1) {
                        output[atual.activityId] = 'J';
                    }
                    if (countPes > 1) {
                        valid = false;
                        break;
                    }

                    countPes++;
                }
                if (atual.type == 'e') countPes--;
            }
            if (valid)
                System.out.println("Case #" + prob + ": " + String.copyValueOf(output));
            else
                System.out.println("Case #" + prob + ": INVALID");
        }


    }
}
