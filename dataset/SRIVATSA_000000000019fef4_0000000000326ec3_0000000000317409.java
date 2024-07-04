import java.io.File;
import java.util.Scanner;
import java.util.function.Consumer;

public class Solution {

    public static void main(String[] args) {
        scan(Solution.class, "in.txt", in -> {
            int t = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                System.out.println("Case #" + i + ": " + solve(in.nextInt(), in.nextInt(), in.next()));
            }
        });
    }

    private static String solve(int x, int y, String tourstr) {
        char[] tcs = tourstr.toCharArray();
        int[][] tour = new int[tcs.length + 1][2];
        // first place is X,Y
        tour[0] = new int[] {x, y};
        for (int i = 0; i < tcs.length; i++) {
            tour[i + 1] = move(tour[i], tcs[i]);
        }

        int ans = Integer.MAX_VALUE;
        for( int i=tour.length-1; i>0; i--) {
            int pos[] = tour[i];
            int md = Math.abs(pos[0]) + Math.abs(pos[1]);
            if(md <= i) {
                int reach = Math.max(md, i);
                ans = Math.min(ans, reach);
            }
        }
        return "" + (ans != Integer.MAX_VALUE ? ans : "IMPOSSIBLE");
    }

    static int[] move(int[] pos, char dir) {
        switch (dir) {
        case 'N':
            return new int[] { pos[0], pos[1] + 1 };
        case 'S':
            return new int[] { pos[0], pos[1] - 1 };
        case 'W':
            return new int[] { pos[0] - 1, pos[1] };
        case 'E':
            return new int[] { pos[0] + 1, pos[1] };
        }
        throw new RuntimeException("Direction not allowed");
    }

    public static void scan(Class<?> cl, String path, Consumer<Scanner> consumer) {
        try (Scanner sc = (path == null) ? new Scanner(System.in)
                : (cl == null) ? new Scanner(new File(path)) : new Scanner(cl.getResourceAsStream(path))) {
            consumer.accept(sc);
        } catch (Exception e) {
            System.err.println("ERROR in " + cl + " < " + path);
            e.printStackTrace();
        }
    }

}