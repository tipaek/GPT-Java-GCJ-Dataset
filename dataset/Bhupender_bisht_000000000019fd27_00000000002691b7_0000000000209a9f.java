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
        int k = 1;
        while(t-->0){
            int n = sc.nextInt();
            int tr=0;
            int row=0, col=0;
            int m[][] = new int[n][n];
            for(int i=0;i<n;i++) {
            	HashSet<Integer> rows = new HashSet<Integer>();
            	for(int j=0;j<n;j++) {
                	m[i][j] = sc.nextInt();
                	rows.add(m[i][j]);
                	if(i==j) {
                		tr=tr+m[i][j];
                	}
                }
            	if(rows.size()!=n) {
            		row++;
            	}
            }
            for(int i=0;i<n;i++) {
            	HashSet<Integer> columns = new HashSet<Integer>();
            	for(int j=0;j<n;j++) {
            		columns.add(m[j][i]);
                }
            	if(columns.size()!=n) {
            		col++;
            	}
            }
            sb.append("Case #"+k+": "+tr+" "+row+" "+col);
        	sb.append("\n");
        	k++;
        }
        System.out.print(sb.toString());
        sc.close();
	}
}