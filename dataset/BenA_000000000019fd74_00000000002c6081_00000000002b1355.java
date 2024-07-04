import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String[] lis;
        int[][] dan;
        for (int q = 1; q <= cases; q++) {
            lis = s.nextLine().split(" ");
            dan = new int[Integer.parseInt(lis[0])][Integer.parseInt(lis[1])];
            for (int x = 0; x < dan.length; x++) {
                lis = s.nextLine().split(" ");
                for (int i = 0; i < dan[x].length; i++) {
                    dan[x][i] = Integer.parseInt(lis[i]);
                }
            }
            int ans = dance(dan);
            System.out.println("Case #" + q + ": " + ans);
        }
    }
    public static int dance(int[][] dan) {
        int[][] next = new int[dan.length][dan[0].length];
        boolean out = false;
        int sum;
        int num;
        int tot = 0;
        for (int x = 0; x < dan.length; x++) {
            for (int i = 0; i < dan[x].length; i++) {
                if (dan[x][i] != 0) {
                    next[x][i] = dan[x][i];
                    tot += dan[x][i];
                    sum = 0;
                    num = 0;
                    for (int z = x-1; z >= 0; z--) {
                        if (dan[z][i] != 0) {
                            num++;
                            sum += dan[z][i];
                            break;
                        }
                    }
                    for (int z = x+1; z < dan.length; z++) {
                        if (dan[z][i] != 0) {
                            num++;
                            sum += dan[z][i];
                            break;
                        }
                    }
                    for (int z = i-1; z >= 0; z--) {
                        if (dan[x][z] != 0) {
                            num++;
                            sum += dan[x][z];
                            break;
                        }
                    }
                    for (int z = i+1; z < dan[x].length; z++) {
                        if (dan[x][z] != 0) {
                            num++;
                            sum += dan[x][z];
                            break;
                        }
                    }
                    if (num != 0) {
                        if ((0.0 + sum)/num > dan[x][i]) {
                            next[x][i] = 0;
                            out = true;
                        }
                    }
                }
            }
        }
        if (out) {
            return tot + dance(next);
        }
        else {
            return tot;
        }
    }
}