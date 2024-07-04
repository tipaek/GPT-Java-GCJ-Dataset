import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) solve(reader, i + 1);
    }

    static void solve(BufferedReader reader, int caseNum) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        System.out.printf("Case #%d:%n", caseNum);
        if (N == 1) {
            System.out.printf("%d %d");
        } else {
            int to =7;
            Set<Integer> flip = new HashSet<>();
            boolean done = false;
            for (int ii = 1; ii <= Math.min(N, 40) && !done; ii++) {
                for (int numFlips = 0; numFlips <= ii && !done; numFlips++) {
                    int target = N - ii + numFlips;
                    if (target < 0) continue;
                    flip.clear();
                    int copy = target;
                    int curbit = 1;
                    while (copy > 0) {
                        if (copy % 2 == 1) {
                            flip.add(curbit);
                        }
                        copy /= 2;
                        curbit++;
                    }
                    if (flip.size() == numFlips && curbit < ii) {
                        // for (int num : flip) {
                        //     System.out.printf("LOL %d%n", num);
                        // }
                        to = ii;
                        boolean left = true;
                        for (int i = 1; i <= to; i++) {
                            if (flip.contains(i)) {
                                if (left) {
                                    for (int j = 1; j <= i; j++) {
                                        System.out.printf("%d %d%n", i, j);
                                    }
                                } else {
                                    for (int j = i; j >= 1; j--) {
                                        System.out.printf("%d %d%n", i, j);
                                    }
                                }
                                left = !left;
                            } else if (left) {
                                System.out.printf("%d %d%n", i, 1);
                            } else {
                                System.out.printf("%d %d%n", i, i);
                            }
                        }
                        done = true;
                    }
                }
            }

            
        }
    }
}