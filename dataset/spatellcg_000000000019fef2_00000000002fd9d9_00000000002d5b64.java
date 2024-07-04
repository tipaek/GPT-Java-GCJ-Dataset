import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int r = in.nextInt();
        int s = in.nextInt();
        int num = (r-1)*(s-1);
        System.out.println("Case #" + i + ": " + num);
        int m = 1;
        for (int j = 0; j<num; j++) {
        	int a = r*s-r-j;
        	int b = r - 1- j/(s-1);
        	System.out.println(a + " " + b);
        }
    }
  }
}