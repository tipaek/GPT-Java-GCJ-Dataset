import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
 
public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            String[] p = new String[n];
            for (int i2 = 0; i2 < n; i2++) {
            	p[i2] = in.next().substring(1);
            	for (int i3 = i2; i3 > 0; i3--) {
            		if (p[i3].length() < p[i3 - 1].length()) {
            			String s = p[i3 - 1];
            			p[i3 - 1] = p[i3];
            			p[i3] = s;
            		}
            	}
            }

            boolean b = true;
            for (int i2 = 1; i2 < n; i2++) {
            	if (!p[i2].matches(".*" + p[i2 - 1])) {
            		b = false;
            		break;
            	}
            }
            System.out.println("Case #" + i + ": " + (b ? p[n - 1] : "*"));
        }
        in.close();
	}
}