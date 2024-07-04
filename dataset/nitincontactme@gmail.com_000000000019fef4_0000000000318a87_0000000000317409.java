
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

 class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            int[] pos = new int[]{in.nextInt(),  in.nextInt()};
            String path = in.next();
            int ans = pos[0]==0&&pos[1]==0?0:-1, counter = 1;
            for(char c: path.toCharArray()) {
                if (ans!=-1)break;
                pos = get(pos, c);
                if (Math.abs(pos[0])+Math.abs(pos[1])<=counter) {
                    ans = counter;
                    break;
                }
                counter++;
            }
            System.out.print("Case #"+(i11+1)+": " + (ans==-1?"IMPOSSIBLE":ans)+"\n");
        }
        in.close();
    }

    private static int[] get(int[] pos, char c) {
        switch (c) {
            case 'S':
                pos[1]--;
                break;
            case 'N':
                pos[1]++;
                break;
            case 'E':
                pos[0]++;
                break;
            case 'W':
                pos[0]--;
                break;
        }
        return pos;
    }
}
