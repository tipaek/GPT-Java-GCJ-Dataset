import java.util.*;
import java.io.*;

class Target {
    int x;
    int y;

    public Target(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Target target = (Target) o;
        return x == target.x &&
                y == target.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Solution {
    public static final char[] map = new char[]{ 'N', 'E', 'S', 'W' };
    
    public static Target getTarget(String solution) {
        char[] sol = solution.toCharArray();
        int x = 0;
        int y = 0;
        for (int i = 0; i < sol.length; i++) {
            int distance = (int) Math.pow(2, i);
            if (sol[i] == 'N') {
                y += distance;
            }
            if (sol[i] == 'S') {
                y -= distance;
            }
            if (sol[i] == 'E') {
                x += distance;
            }
            if (sol[i] == 'W') {
                x -= distance;
            }
        }
        return new Target(x, y);
    }

    public static String getSolution(int[] perm) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < perm.length; i++) {
            sb.append(map[perm[i]]);
        }
        return sb.toString();
    };

    public static void incrementPermutation(int[] perm) {
        for (int i = perm.length - 1; i >= 0; i--) {
            if (perm[i] <= 2) {
                perm[i]++;
                break;
            } else {
                perm[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        HashMap<Target, String> targetMap = new HashMap<>();
        int[] permutation = new int[8];
        for (int i = 0; i < Math.pow(4, 8); i++) {
            String solution = getSolution(permutation);

            for (int partialLength = 1; partialLength <= solution.length(); partialLength++) {
                String pSolution = solution.substring(0, partialLength);
                Target t = getTarget(pSolution);

                String existing = targetMap.get(t);
                if (existing != null) {
                    if (existing.length() >= pSolution.length()) {
                        targetMap.put(t, pSolution);
                    }
                } else {
                    targetMap.put(t, pSolution);
                }
            }
            incrementPermutation(permutation);
        }
        
        for (int i = 0; i < T; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String s = targetMap.get(new Target(x, y));
            if (s == null) {
                s = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + s);
        }
    }
}