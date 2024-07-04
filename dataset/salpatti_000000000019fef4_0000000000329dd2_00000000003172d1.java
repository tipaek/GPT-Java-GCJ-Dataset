package salvo.codejam.round1c;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

//ROUND 1C
public class Solution {

    public static void main(String[] args) {
        solveProblem3(System.in, System.out);
    }


    public static void solveProblem3(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder sol = new StringBuilder();
            final int n = s.nextInt();
            final int d = s.nextInt();
            double[] as = new double[n];
            TreeSet<Double> mezzi = new TreeSet<Double>();
            for (int i = 0; i < n; i++) {
                as[i] = s.nextDouble();
                mezzi.add(as[i]/2);
            }

            int cuts = d-1;
            boolean mezc = false;
            boolean tag = false;
            if (d == 2 || d == 3) {
                if (as.length == 1) {
                    cuts = d - 1;
                } else {
                    Arrays.sort(as);
                    double last = as[0];
                    for (int i = 1; i < as.length; i++) {
                        if (last == as[i]) {
                            cuts--;
                            if(cuts==0) {
                                break;
                            }
                        } else {
                            if(mezzi.contains(last/2) && !mezc && d!=2){
                                mezc = true;
                                tag = true;
                                cuts--;
                                if(cuts==0){
                                    break;
                                }
                            }
                        }
                        last = as[i];
                    }
                }
            }
            ps.print("Case #" + t + ": " + cuts);
            if (t != T) ps.println();
        }
    }
}
