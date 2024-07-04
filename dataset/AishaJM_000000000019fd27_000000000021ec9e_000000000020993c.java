import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		    Scanner input=new Scanner (System.in);
	        int N,T,k= 0;
	        //int sum=0,c=0,r=0;
	        int flag1 = 0;
	        int flag2=0;
	       
	        T=input.nextInt();
	        int r[]=new int[T+1];
        	int c[]=new int[T+1];
        	int sum[]=new int[T+1];
	        for(int i=1;i<=T;i++)
	        {  
	        	N= input.nextInt();
	        	int mat[][]=new int[N][N];
		        for(int row=0;row<N;row++) {
		           for(int col=0;col<N;col++){
		              mat[row][col]=input.nextInt();
		              if(!((col==0)&&(row==0))){
		                  for(int f=0;f<col;f++){
		                      if(mat[row][col]==mat[row][f]){
		                          flag1=1;
		                      }
		                  }
		              }
		           }if(flag1==1){r[i]++; flag1=0;}
		        }
		        //columns
		        for(int col=0;col<N;col++) {
			           for(int row=0;row<N;row++){
			              if(!((col==0)&&(row==0))){
			                  for(int f=0;f<row;f++){
			                      if(mat[row][col]==mat[f][col]){
			                          flag2=1;
			                      }
			                  }
			              }
			           }if(flag2==1){c[i]++; flag2=0;}
			        }
			        for(int row=0;row<N;row++) {
				           for(int col=0;col<N;col++){
				              if(row==col){
				                  sum[i]+=mat[row][col];
				              }
				           }
				        }
			        flag1=0; flag2=0;
	        }
	       for(int i=1;i<=T;i++) {
	    	   System.out.printf("Case #%d: %d %d %d \n", i,sum[i],r[i],c[i]);
	       }
	       
	}

}
