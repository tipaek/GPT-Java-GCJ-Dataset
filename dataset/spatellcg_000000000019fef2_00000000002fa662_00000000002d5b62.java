import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int x = in.nextInt();
        int y = in.nextInt();
        if ((x+y)%2==0) {
        	System.out.println("Case #" + i + ": IMPOSSIBLE");
        	continue;
        }
        int minpower = (int) (Math.log10(Math.abs(x)+Math.abs(y))/Math.log10(2));
        int posx = x;
        int posy = y;
        int m = minpower;
        String ans = new String();
        while ((posx != 0) || (posy != 0)) {
        	if (Math.abs(posx) > Math.abs(posy)) {
        		if (posx>0) {
        			posx = (int) (posx - Math.pow(2,m));
        			ans = "E".concat(ans);
        		}
        		else if (posx<0) {
        			posx = (int) (posx + Math.pow(2, m));
        			ans = "W".concat(ans);
        		}
        	} else {
        		if (posy>0) {
        			posy = (int) (posy - Math.pow(2,m));
        			ans = "N".concat(ans);
        		} else if (posy<0) {
        			posy = (int) (posy + Math.pow(2, m));
        			ans = "S".concat(ans);
        		}
        	}
        	m = m-1;
        	if (m==-1) {
        		break;
        	}
        }
        System.out.println("Case #" + i + ": " + ans);
        }
    }
  }