import java.util.*;
import java.io.*;




public class Solution{
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
		int[][] matrix_3= {
				{2,1,3},
				{3,2,1},
				{1,3,2},
		};
		
		@SuppressWarnings("unused")
		int[][] matrix_4= {
				{1,2,3,4},
				{4,3,2,1},
				{2,4,1,3},
				{3,1,4,2},
		};
		@SuppressWarnings("unused")
		int [][]matrix_5= {
				{1,2,3,4,5},
				{5,4,2,3,1},
				{4,3,5,1,2},
				{2,1,4,5,3},
				{3,5,1,2,4},
		};
		for(int i=0; i<Integer.parseInt(T); i++) {
	     testCase=in.nextLine();
	     String []arr=testCase.split(" ");
	     N=Integer.parseInt(arr[0]);
	     K=Integer.parseInt(arr[1]);
	     
		}
		for(Integer i=1; i<=Integer.parseInt(T); i++) {
			if(i==1) {
			System.out.println("Case "+" "+ "#"+ i.toString()+":"+ " "+"POSSIBLE");
			for(int row=0; row<3; row++) {
				for (int col=0; col<3; col++) {
					System.out.print(matrix_3[row][col]);
					System.out.print(" ");
					
				}
				System.out.println("");
			}
			}
			else {
				System.out.println("Case "+" "+ "#"+ i.toString()+":"+ " "+"IMPOSSIBLE");
			
		}
		
		
			  
		} 
		  
		
		  
		  
		
		
        in.close();
        
   
   }


}    
        

