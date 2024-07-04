import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      System.out.println("Case #" + i + ": " + Nest(s));
    }
  }

    public static String Nest(String input) {
		String nested = "";
		String[] str = input.split("");
		int[] num = new int[str.length];
		for(int i=0; i<num.length; i++)
			num[i]=Integer.parseInt(str[i]);
		for(int j=0; j<num.length; j++) {
			if(j == 0) {
				nested+=nester(num[0],num[0]);
			} else if(num[j]>num[j-1]) {
				int diff = num[j]-num[j-1];
				String first = nested.substring(0,nested.length()-num[j-1]);
				String last = nested.substring(nested.length()-num[j-1]);
				String mid = nester(num[j],diff);
				nested=first+mid+last;
			} else {
				String first = nested.substring(0,nested.length()-num[j]);
				String last = nested.substring(nested.length()-num[j]);
				nested=first+num[j]+last;
			}
		}
		return nested;
	}

	public static String nester(int num, int pars) {
		String s = "";
		for(int i=1; i<=pars; i++)
			s+='(';
		s+=num;
		for(int i=1; i<=pars; i++)
			s+=')';
		return s;
	}
}