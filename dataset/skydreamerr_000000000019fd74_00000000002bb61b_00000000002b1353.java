import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            System.out.printf("Case #%d:\n", x);
            solve(n);
        }
    }

    static private void solve(int n) {
        System.out.printf("%d %d\n",1,1);
        int s = 1;
        int r = 2;
        int k = 2;
        int next = 1;
        while (s + next <= n) {
            System.out.printf("%d %d\n",r,k);
            r++;
            s += next;
            next++;
        }
        k = 1;
        while(s<n){
            s++;
            System.out.printf("%d %d\n",r,k);
            r--;
        }

    }
}