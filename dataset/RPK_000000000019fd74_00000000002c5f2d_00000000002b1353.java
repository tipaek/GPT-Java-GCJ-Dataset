import java.util.*;
import java.io.*;
public class Solution {
  public static void solve(Scanner in, int index) {
    int num = in.nextInt();
    int r = 0;
    int c = 1;
    while(c < num) {
        c <<= 1;
        ++r;
    }
    int w = num - r;
    r = 0;
    c = 1;
    while(c < w) {
        c <<= 1;
        ++r;
    }
    int a = r;
    System.out.println("Case #" + index + ":");
    boolean d = true;
    for(int i = 0; i <= r; ++i) {
        if((w & (1 << i)) > 0) {
            int s = d ? 1 : i + 1;
            int t = i + 2 - s;
            int q = d ? 1 : -1;
            for(int k = s; k != t + q; k += q) {
                System.out.println((i + 1) + " " + k);
            }
            d = !d;
        } else {
            System.out.println((i + 1) + " " + (d ? 1 : (i + 1)));
            --a;
        }
    }
    for(int i = r + 2; i <= r + a + 1; ++i) {
        System.out.println(i + " " + (d ? 1 : i));
    }
  }    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      solve(in, i);
    }
  }
}