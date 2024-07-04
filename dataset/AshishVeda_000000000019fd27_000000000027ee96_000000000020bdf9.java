import java.util.*;
import java.io.*;

public class Solution{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int xyz=1;
		while(n>0) {
			StringBuilder sb=new StringBuilder();
			int numT=in.nextInt();
			int[][] mat=new int[numT][2];
			
			for(int i=0;i<numT;i++) {
				mat[i][0]=in.nextInt();
				//System.out.println(i);
				mat[i][1]=in.nextInt();
				
			}
			//System.out.println(n);
			java.util.Arrays.sort(mat, new java.util.Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return Integer.compare(a[1], b[1]);
			    }
			});
			int cs=-1,ce=-1,js=-1,je=-1,count=0;
			for(int i=0;i<mat.length;i++) {
				if(mat[i][0]>=ce&&cs<mat[i][1]) {
					ce=mat[i][1];
					cs=mat[i][0];
					sb.append('C');
					//System.out.println("c "+mat[i][0]+"-"+mat[i][1]);
				}else {
					if(mat[i][0]>=je&&js<mat[i][1]) {
						je=mat[i][1];
						js=mat[i][0];
						sb.append('J');
						//System.out.println("j "+mat[i][0]+"-"+mat[i][1]);
					}else {
						count++;
					}
				}
			}
//			for(int i=0;i<mat.length;i++) {
//				for(int j:mat[i]) {
//					System.out.print(j);
//				}
//				System.out.println("");
//			}
			if(count>0) {
				System.out.println("Case #"+xyz+": IMPOSSIBLE");
			}else {
				System.out.println("Case #"+xyz+": "+sb);
			}
			xyz++;
			n--;
		}
	}

}