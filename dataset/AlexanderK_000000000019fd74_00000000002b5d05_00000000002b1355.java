import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author alexk
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            process(r);
        }
    }

    private static class Input {

        int[][] s;

        public Input(BufferedReader br) throws IOException {
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);            
//            System.out.println("r = " + r + ", c = " + c);
            s = new int[r][c];
            for (int i = 0; i < r; i++) {
                line = br.readLine().split(" ");
                for (int j = 0; j < c; j++) {
                    s[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
    }

    private static class Output {

        BigInteger il;

        public Output(BigInteger il) {
            this.il = il;
        }

        @Override
        public String toString() {            
            return il + "";
        }
    }

    public static void process(BufferedReader r) throws IOException {
        int t = Integer.parseInt(r.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new Input(r)));
        }
    }
    
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    
    private static class Dancer {
        int i, j, level;
        Dancer[] compass = new Dancer[4];
        boolean eliminated;
    }

    static Output solve(Input in) {
        Set<Dancer> s = new HashSet<>(in.s.length * in.s[0].length);
        Dancer[] pr = new Dancer[in.s[0].length];
        Dancer[] pc = new Dancer[in.s.length];
        for (int i = 0; i < in.s.length; i++) {
            for (int j = 0; j < in.s[0].length; j++) {
                Dancer d = new Dancer();
                d.i = i;
                d.j = j;
                d.level = in.s[i][j];
                if (i > 0) {
                    d.compass[NORTH] = pr[j];
                    pr[j].compass[SOUTH] = d;
                }
                if (j > 0) {
                    d.compass[WEST] = pc[i];
                    pc[i].compass[EAST] = d;
                }
                pr[j] = d;
                pc[i] = d;
                s.add(d);
            }
        }
        BigInteger levelOfInterest = BigInteger.ZERO;
        while(true) {
            long interest = 0;
            Set<Dancer> nextRound = new HashSet<>();
            int eliminated = 0;
            for (Dancer d : s) {
                interest += d.level;
                int sum = 0;
                int count = 0;
                for(Dancer c : d.compass) {
                    if (c != null) {
                        sum += c.level;
                        count++;
                    }
                }
                if (d.level < (double) sum / count) {
                    d.eliminated = true;
                    eliminated++;
                }
            }
            levelOfInterest = levelOfInterest.add(BigInteger.valueOf(interest));
            if (eliminated == 0) {
                break;
            }
            for(Iterator<Dancer> iter = s.iterator(); iter.hasNext();) {
                Dancer d = iter.next();
                if (d.eliminated) {
                    if (d.compass[NORTH] != null) {
                        d.compass[NORTH].compass[SOUTH] = d.compass[SOUTH];
                    }
                    if (d.compass[SOUTH] != null) {
                        d.compass[SOUTH].compass[NORTH] = d.compass[NORTH];
                    }
                    if (d.compass[EAST] != null) {
                        d.compass[EAST].compass[WEST] = d.compass[WEST];
                    }
                    if (d.compass[WEST] != null) {
                        d.compass[WEST].compass[EAST] = d.compass[EAST];
                    }
                    iter.remove();
                }
            }
        }
        return new Output(levelOfInterest);
    }
}