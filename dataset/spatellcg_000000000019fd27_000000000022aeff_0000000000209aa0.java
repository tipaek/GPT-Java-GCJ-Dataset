import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int k = in.nextInt();
        if (n==2) {
        	if (k==2) {
        		System.out.println("Case #"+i+": POSSIBLE");
        		System.out.println("1 2");
        		System.out.println("2 1");
        	}
        	if (k==4) {
        		System.out.println("Case #"+i+": POSSIBLE");
        		System.out.println("2 1");
        		System.out.println("1 2");
        	}
        	if (k==3) {
        		System.out.println("Case #"+i+": IMPOSSIBLE");
        	}
        }
        if (n==3) {
           	if (k==3) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("1 2 3");
           		System.out.println("3 1 2");
           		System.out.println("2 3 1");
           	}
           	if (k==4) {
           		System.out.println("Case #"+i+": IMPOSSIBLE");
           	}
           	if (k==5) {
           		System.out.println("Case #"+i+": IMPOSSIBLE");
           	}
           	if (k==6) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 3 1");
           		System.out.println("1 2 3");
           		System.out.println("3 1 2");
           	}
           	if (k==7) {
           		System.out.println("Case #"+i+": IMPOSSIBLE");
           	}
           	if (k==8) {
           		System.out.println("Case #"+i+": IMPOSSIBLE");
           	}
           	if (k==9) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 3 1");
           		System.out.println("1 2 3");
           		System.out.println("3 1 2");
           	}
        }
        if (n==4) {
           	if (k==4) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("1 2 3 4");
           		System.out.println("4 1 2 3");
           		System.out.println("3 4 1 2");
           		System.out.println("2 3 4 1");
           	}
           	if (k==5) {
           		System.out.println("Case #"+i+": IMPOSSIBLE");
           	}
           	if (k==6) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 1 3 4");
           		System.out.println("1 2 4 3");
           		System.out.println("3 4 1 2");
           		System.out.println("4 3 2 1");
           	}
           	if (k==7) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("1 2 4 3");
           		System.out.println("3 1 2 4");
           		System.out.println("2 4 3 1");
           		System.out.println("4 3 1 2");
           	}
           	if (k==8) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 3 4 1");
           		System.out.println("1 2 3 4");
           		System.out.println("4 1 2 3");
           		System.out.println("3 4 1 2");
           	}
           	if (k==9) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 1 3 4");
           		System.out.println("4 2 1 3");
           		System.out.println("1 3 4 2");
           		System.out.println("3 4 2 1");
           	}
           	if (k==10) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 3 4 1");
           		System.out.println("3 2 1 4");
           		System.out.println("4 1 3 2");
           		System.out.println("1 4 2 3");
           	}
           	if (k==11) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("3 1 2 4");
           		System.out.println("4 3 1 2");
           		System.out.println("1 2 4 3");
           		System.out.println("2 4 3 1");
           	}
           	if (k==12) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("3 4 1 2");
           		System.out.println("2 3 4 1");
           		System.out.println("1 2 3 4");
           		System.out.println("4 1 2 3");
           	}
           	if (k==13) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("4 2 1 3");
           		System.out.println("3 4 2 1");
           		System.out.println("2 1 3 4");
           		System.out.println("1 3 4 2");
           	}
           	if (k==14) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("4 3 2 1");
           		System.out.println("3 4 1 2");
           		System.out.println("2 1 3 4");
           		System.out.println("1 2 4 3");
           	}
           	if (k==15) {
           		System.out.println("Case #"+i+": IMPOSSIBLE");
           	}
           	if (k==16) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("4 1 2 3");
           		System.out.println("3 4 1 2");
           		System.out.println("2 3 4 1");
           		System.out.println("1 2 3 4");
           	}
        }
        if (n==5) {
           	if (k==5) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("1 2 3 4 5");
           		System.out.println("5 1 2 3 4");
           		System.out.println("4 5 1 2 3");
           		System.out.println("3 4 5 1 2");
           		System.out.println("2 3 4 5 1");
           	}
           	if (k==6) {
           		System.out.println("Case #"+i+": IMPOSSIBLE");
           	}
           	if (k==7) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("1 5 2 3 4");
           		System.out.println("2 1 4 5 3");
           		System.out.println("3 2 1 4 5");
           		System.out.println("5 4 3 2 1");
           		System.out.println("4 3 5 1 2");
           	}
           	if (k==8) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 4 1 3 5");
           		System.out.println("1 2 5 4 3");
           		System.out.println("3 1 2 5 4");
           		System.out.println("4 5 3 1 2");
           		System.out.println("5 3 4 2 1");
           	}
           	if (k==9) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("1 5 3 2 4");
           		System.out.println("3 1 4 5 2");
           		System.out.println("2 3 1 4 5");
           		System.out.println("5 4 2 3 1");
           		System.out.println("4 2 5 1 3");
           	}
           	if (k==10) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 3 4 5 1");
           		System.out.println("1 2 3 4 5");
           		System.out.println("5 1 2 3 4");
           		System.out.println("4 5 1 2 3");
           		System.out.println("3 4 5 1 2");
           	}
           	if (k==11) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("3 4 1 2 5");
           		System.out.println("1 3 5 4 2");
           		System.out.println("2 1 3 5 4");
           		System.out.println("4 5 2 1 3");
           		System.out.println("5 2 4 3 1");
           	}
           	if (k==12) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("2 5 3 1 4");
           		System.out.println("3 2 4 5 1");
           		System.out.println("1 3 2 4 5");
           		System.out.println("5 4 1 3 2");
           		System.out.println("4 1 5 2 3");
           	}
           	if (k==13) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("3 4 2 1 5");
           		System.out.println("2 3 5 4 1");
           		System.out.println("1 2 3 5 4");
           		System.out.println("4 5 1 2 3");
           		System.out.println("5 1 4 3 2");
           	}
           	if (k==14) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("4 3 1 2 5");
           		System.out.println("1 4 5 3 2");
           		System.out.println("2 1 4 5 3");
           		System.out.println("3 5 2 1 4");
           		System.out.println("5 2 3 4 1");
           	}
           	if (k==15) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("3 4 5 1 2");
           		System.out.println("2 3 4 5 1");
           		System.out.println("1 2 3 4 5");
           		System.out.println("5 1 2 3 4");
           		System.out.println("4 5 1 2 3");
           	}
           	if (k==16) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("4 3 2 1 5");
           		System.out.println("2 4 5 3 1");
           		System.out.println("1 2 4 5 3");
           		System.out.println("3 5 1 2 4");
           		System.out.println("5 1 3 4 2");
           	}
           	if (k==17) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("5 3 1 2 4");
           		System.out.println("1 5 4 3 2");
           		System.out.println("2 1 5 4 3");
           		System.out.println("3 4 2 1 5");
           		System.out.println("4 2 3 5 1");
           	}
           	if (k==18) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("4 5 3 1 2");
           		System.out.println("3 4 2 5 1");
           		System.out.println("1 3 4 2 5");
           		System.out.println("5 2 1 3 4");
           		System.out.println("2 1 5 4 3");
           	}
           	if (k==19) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("5 3 2 1 4");
           		System.out.println("2 5 4 3 1");
           		System.out.println("1 2 5 4 3");
           		System.out.println("3 4 1 2 5");
           		System.out.println("4 1 3 5 2");
           	}
           	if (k==20) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("4 5 1 2 3");
           		System.out.println("3 4 5 1 2");
           		System.out.println("2 3 4 5 1");
           		System.out.println("1 2 3 4 5");
           		System.out.println("5 1 2 3 4");
           	}
           	if (k==21) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("5 4 3 1 2");
           		System.out.println("3 5 2 4 1");
           		System.out.println("1 3 5 2 4");
           		System.out.println("4 2 1 3 5");
           		System.out.println("2 1 4 5 3");
           	}
           	if (k==22) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("4 3 5 1 2");
           		System.out.println("5 4 2 3 1");
           		System.out.println("1 5 4 2 3");
           		System.out.println("3 2 1 5 4");
           		System.out.println("2 1 3 4 5");
           	}
           	if (k==23) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("5 3 4 1 2");
           		System.out.println("4 5 2 3 1");
           		System.out.println("1 4 5 2 3");
           		System.out.println("3 2 1 4 5");
           		System.out.println("2 1 3 5 4");
           	}
           	if (k==24) {
           		System.out.println("Case #"+i+": IMPOSSIBLE");
           	}
           	if (k==25) {
           		System.out.println("Case #"+i+": POSSIBLE");
           		System.out.println("5 1 2 3 4");
           		System.out.println("4 5 1 2 3");
           		System.out.println("3 4 5 1 2");
           		System.out.println("2 3 4 5 1");
           		System.out.println("1 2 3 4 5");
           	}
        } 	
    }
  }
}