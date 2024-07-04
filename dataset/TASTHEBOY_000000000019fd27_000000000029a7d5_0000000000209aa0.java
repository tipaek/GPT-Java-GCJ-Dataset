import java.util.*;
import java.io.*;




public class Solution{
	static class Pair{
		Integer N;
		Integer K;
		 public Pair(Integer N, Integer K){
			 this.N=N;
			 this.K=K;
		 }
		 public Integer getN() {
			 return this.N;
		 }
		 public Integer getK() {
			 return this.K;
		 }
	}
	static class cases{
		Integer number;
		int [][] arr;
		public cases(Integer number,String string){
			this.number=number;
			
		}
		public  Integer getNumber() {
			return this.number;
		}
		
		
	}
	 
	
	public static void main (String args []) {
      // Scanner in= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	   Scanner in= new Scanner(System.in);
		/*T is the number of test case*/
		String T=in.nextLine();
		String testCase;
		Integer N,K;
		Pair [] pair=new Pair [Integer.parseInt(T)];
		
		for(int i=0; i<Integer.parseInt(T); i++) {
	     testCase=in.nextLine();
	     String []arr=testCase.split(" ");
	     N=Integer.parseInt(arr[0]);
	     K=Integer.parseInt(arr[1]);
	     Pair tmp=new Pair(N, K);
	     pair[i]=tmp;
	     
		}
		 in.close();
		for(int i=0; i<Integer.parseInt(T); i++) {
			Pair tmp=pair[i];
			int n=tmp.getN();
			int k=tmp.getK();
			int [][] matrix=new int [n][n];
			int x;
			if(k==n) {
				x=1;
			}
			else if(k==Math.pow(n, 2)) {
				x=k;
			}
			else {
				x=k/n;
			}
			for(int row=0; row<n; row++) {
				int [] row_arr=new int [row];
				int [] col_arr=new int [row];
				
				for(int col=0; col<n; col++) {
					if(row==col) {
						matrix[row][col]=x;
					}
					else {
						
					}
				}
			}
			
			
		}
			  
		
		  
		
		  
		  
		
		
       
        
   
   }


}    
        

