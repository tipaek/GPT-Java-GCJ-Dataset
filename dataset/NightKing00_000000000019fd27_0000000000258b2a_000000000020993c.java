import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
public static void main(String[]args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int t=Integer.parseInt(br.readLine());
	StringTokenizer st;
	for(int i=0;i<t;i++) {
		int n=Integer.parseInt(br.readLine());
		int a[][]=new int[n][n];
		int rows=0,cols=0,trace=0;
		for(int j=0;j<n;j++) {
			Set<Integer> myset=new HashSet();
			st=new StringTokenizer(br.readLine());
			for(int k=0;k<n;k++) {
				a[j][k]=Integer.parseInt(st.nextToken());
				if(j==k)trace+=a[j][k];
				myset.add(a[j][k]);
			}
			if(myset.size()<n)rows++;
		}
		for(int k=0;k<n;k++) {
			Set<Integer> myset=new HashSet();
			for(int j=0;j<n;j++) {
				myset.add(a[j][k]);
			}
			if(myset.size()<n)cols++;
		}
		out.println("Case #"+(i+1)+": "+trace+" "+rows+" "+cols);
	}
	out.close();
}
}
