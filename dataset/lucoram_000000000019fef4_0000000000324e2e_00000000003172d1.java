import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        outer: for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();

            Map<Long, Integer> sliceOccs = new HashMap<>();

            int maxOccs = 0;

            for (int j = 0; j < n; j++) {
                long slice = in.nextLong();
                int occs = 1;

                if (sliceOccs.containsKey(slice)) {
                    occs += sliceOccs.get(slice);
                }

                sliceOccs.put(slice, occs);
                maxOccs = Math.max(occs, maxOccs);
            }

            if (maxOccs < d) {
                // try whole cuts
                if (d == 3) {

                    // multiple
                    for (Long keyl : sliceOccs.keySet()) {
                        for (long keyr : sliceOccs.keySet()) {
                            if (keyl != keyr && (keyl % keyr == 0 || keyr % keyl == 0)) {
                                System.out.println("Case #" + i + ": 1");
                                continue outer;
                            }
                        }
                    }

                    // 
                    if(maxOccs == 1) {
                        System.out.println("Case #" + i + ": 2");
                    } else {
                        
                        for (Long keyl : sliceOccs.keySet()) {
                            if(sliceOccs.get(keyl) == 2) {
                                for (long keyr : sliceOccs.keySet()) {
                                    if(keyr > keyl) {
                                        System.out.println("Case #" + i + ": 1");
                                        continue outer;
                                    }
                                }
                            }
                        }

                        System.out.println("Case #" + i + ": 2");
                    }
                    
                    // else
                } else {
                    System.out.println("Case #" + i + ": 1");
                }

            } else {
                System.out.println("Case #" + i + ": 0");
                continue outer;
            }
        }
    }
}