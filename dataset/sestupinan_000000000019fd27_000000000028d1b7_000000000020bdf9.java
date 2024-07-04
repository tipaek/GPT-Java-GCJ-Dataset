import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			String res = "";
			boolean imp=false;
			int[] st = new int[n];
			int[] fi = new int[n];
			String[] w=new String[n];
			boolean[] hay = new boolean[n];
			for (int j = 0; j < n && !imp; j++) {
				int hays=0;
				boolean yaadd=false;
				int nst=in.nextInt();
				int nfi=in.nextInt();
				if(j!=0)
				{
					for (int k = 0; k < j; k++) {
						if(nst>st[k] && nst<fi[k])
						{
							if(hay[j]||hays==1)
							{
								if(hays==1)
								{
									res="IMPOSSIBLE";
									imp=true;
									break;
								}
								else
								{
									hays++;
								}
							}
							else
							{
								hay[j]=true;
								if(w[k]==null)
								{
									w[j]="J";
									res+="J";
								}
								else if (w[k].equals("J"))
								{
									w[j]="C";
									res+="C";
								}
								else
								{
									w[j]="J";
									res+="J";
								}
								hays++;
								yaadd=true;
							}
						}
						else if(nfi>st[k] && nfi<fi[k])
						{
							if(hay[j]||hays==1)
							{
								if(hays==1)
								{
									res="IMPOSSIBLE";
									imp=true;
									break;
								}
								else
								{
									hays++;
								}
							}
							else
							{
								hay[j]=true;
								if(w[k]==null)
								{
									w[j]="J";
									res+="J";
								}
								else if (w[k].equals("J"))
								{
									w[j]="C";
									res+="C";
								}
								else
								{
									w[j]="J";
									res+="J";
								}
								hays++;
								yaadd=true;
							}
						}
						else if(k==j-1 && !yaadd)
						{
							res+="C";
							w[j]="C";
						}
					}
				}
				if(j==0)
				{
					res+="C";
					w[j]="C";
				}
				st[j]=nst;
				fi[j]=nfi;
				hay[j]=false;
			}
			
			System.out.println("Case #" + i + ": " + res);
		}
	}
}