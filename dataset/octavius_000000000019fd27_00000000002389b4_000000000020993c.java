
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
public static void main(String[] args) {
Scanner o=new Scanner(System.in);
int t=o.nextInt();
int m=1;
while(m<=t) {
		int n=o.nextInt();
		int ar[][]=new int[n][n];
		int rows=0;
		boolean rowp=false;
		for(int i=0;i<n;i++) {
			HashSet<Integer>h=new HashSet<>();
			for(int j=0;j<n;j++) {
				ar[i][j]=o.nextInt();
				if(h.contains(ar[i][j])) {
					rowp=true;
					
				}
				else
					h.add(ar[i][j]);
			}
			if(rowp) {
				rows++;
			}
			rowp=false;
		}
		int col=0;
		boolean colr=false;
		for(int i=0;i<n;i++) {
			HashSet<Integer>h1=new HashSet<>();
			for(int j=0;j<n;j++) {
			if(h1.contains(ar[j][i])){
				colr=true;
				break;
			}
			else {
				h1.add(ar[j][i]);
			}
			}
			if(colr) {
				col++;
			}
			colr=false;
		}
		int trace=0;
		for(int i=0;i<n;i++) {
			trace=trace+ar[i][i];
		}
		System.out.println("Case "+"#"+m+": "+trace+" "+rows+" "+col);
		m++;
}
	}
}