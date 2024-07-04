import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	//	System.out.println("enter");
		int no_test=sc.nextInt();
		for(int i=0;i<no_test;i++) {
			int size=sc.nextInt();
			int trace=0;
			int mat[][]=new int[size][size];
			for(int j=0;j<size;j++)
				for(int k=0;k<size;k++) {
					mat[j][k]=sc.nextInt();
					if(j==k)
					{
						trace+=mat[j][k];
					}
				}
			int rc=0,cc=0;
			for(int j=0;j<size;j++) {
				int row[]=new int[size+1];
				int col[]=new int[size+1];
				for(int k=0;k<size;k++) {
					if(row[mat[j][k]]==0)
						row[mat[j][k]]=1;
					else
					{
						rc++;
						break;
					}
				}
			for(int k=0;k<size;k++) {
				if(col[mat[k][j]]==0) {
					col[mat[k][j]]=1;
				}
				else
				{
					cc++;
					break;
				}
			}
			}
			System.out.println("Case #"+(i+1)+": " +trace+" "+rc+" "+cc);
		    	
		}

	}

}
