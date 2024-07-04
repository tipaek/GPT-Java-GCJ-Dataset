import java.util.Scanner;

import java.util.*;
import java.io.*;
public class Solution {
     static void solution(int[] des, int t ) {
        List<Character> result = new ArrayList<>();
        List<Character> path = new ArrayList<>();
//        path.add(new int[]{0,0});
//        int[] location1 =
        dfs(1, des, new int[]{0,0}, result, path, new boolean[Integer.MAX_VALUE][Integer.MAX_VALUE]);
        System.out.print("Case #" + t + ": ");
        if (result.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            Character[] array  = result.toArray(new Character[0]);
            String s = Arrays.toString(array);
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            solution(new int[]{x,y}, i);
        }
    }

    private static void dfs(int n, int[] des, int[] location, List<Character> result, List<Character> path, boolean[][] set) {

        int length = (int) Math.pow(2, n-1);

        if (Math.abs(location[0] - des[0]) < length || Math.abs(location[1] - des[1]) < length) {
            return;
        }

        if (location[0] == des[0] && location[1] == des[1] ) {
            result.addAll(new ArrayList<>(path));
            return;
        }

        int[][] steps = {{length,0}, {-length,0}, {0,length}, {0,-length}};
        Character[] directions = {'E', 'W', 'N', 'S'};
        for (int i = 0; i< steps.length; i++) {

            int[] step = steps[i];
            int x = location[0] + step[0];
            int y = location[1] + step[1];

            int[] newIndex = {x,y};
            if (set[x+100][y+100] == true) {
                continue;
            }
            path.add(directions[i]);
            set[x+100][y+100] = true;

            dfs(n+1, des, newIndex, result, path, set);
            if (!result.isEmpty()) {
                return;
            }
            path.remove(path.size() - 1);
            set[x+100][y+100] = false;
        }
    }

}