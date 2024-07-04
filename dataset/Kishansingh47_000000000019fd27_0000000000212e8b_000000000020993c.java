import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int cse = 1;
        while(t-->0){
            int n = sc.nextInt();
            int trace=0;
            int nrows=0, ncols=0;
            int m[][] = new int[n][n];
            for(int i=0;i<n;i++) {
            	HashSet<Integer> rows = new HashSet<Integer>();
            	for(int j=0;j<n;j++) {
                	m[i][j] = sc.nextInt();
                	rows.add(m[i][j]);
                	if(i==j) {
                		trace=trace+m[i][j];
                	}
                }
            	if(rows.size()!=n) {
            		nrows++;
            	}
            }
            for(int i=0;i<n;i++) {
            	HashSet<Integer> columns = new HashSet<Integer>();
            	for(int j=0;j<n;j++) {
            		columns.add(m[j][i]);
                }
            	if(columns.size()!=n) {
            		ncols++;
            	}
            }
            sb.append("Case #"+cse+": "+trace+" "+nrows+" "+ncols);
        	sb.append("\n");
        	cse++;
        }
        System.out.print(sb.toString());
        sc.close();
	}
}