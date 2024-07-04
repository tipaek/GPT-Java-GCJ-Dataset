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
        public String toString() {
            return "Dupla{" +
                    "pos=" + pos +
                    ", type=" + type +
                    ", activityId=" + activityId +
                    '}';
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
            boolean valid = true;
            boolean Cavailable = true;
            boolean Javailable = true;
            char[] whoLeft = new char[numCases];
            for (Dupla atual : positions) {
                if (atual.type == 's') {
                    if (Cavailable) {
                        whoLeft[atual.activityId] = 'C';
                        Cavailable = false;
                    } else if (Javailable){
                        whoLeft[atual.activityId] = 'J';
                        Javailable = false;
                    } else {
                        valid = false;
                    }
                }
                if (atual.type == 'e') {
                    if (whoLeft[atual.activityId] == 'C') Cavailable = true;
                    if (whoLeft[atual.activityId] == 'J') Javailable = true;
                }
            }
            if (valid)
                System.out.println("Case #" + prob + ": " + String.copyValueOf(whoLeft));
            else
                System.out.println("Case #" + prob + ": IMPOSSIBLE");
        }


    }
}
