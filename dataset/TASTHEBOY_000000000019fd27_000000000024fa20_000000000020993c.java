import java.util.*;
import java.io.*;


public class Solution{
	
	

	static class cases{
		Integer number;
		Integer trace;
		Integer row;
	    Integer column;
		public cases(Integer number,Integer trace, Integer row, Integer column){
			this.number=number;
			this.row=row;
			this.column=column;
			this.trace=trace;
		}
		public  Integer getNumber() {
			return this.number;
		}
		public Integer getRow() {
			return this.row;
		}
		public Integer getCol() {
			return this.column;
		}
		public Integer getTrace() {
			return this.trace;
		}
	}
   public static boolean checkRepeatedItems(String [] arr) {
	   boolean bool=false;
	   String checkItem;
	   
	   for(int i=0; i<arr.length; i++) {
		   checkItem=arr[i];
		   for(int j=0; j<arr.length; j++) {
			   if(i !=j && checkItem==arr[j]) {
				   bool=true;
			   }
		   }
		   if(bool==true) {
			   break;
		   }
	   }
	   return bool;
   }
	
   
   public static void main (String args []) {
      // Scanner in= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		Scanner in= new Scanner(System.in);
		/*T is the number of test case*/
		String T=in.nextLine();
		String N;
		String S;
		int number;
        Integer no_row=0;
        Integer no_col=0;
        Integer caseNumber;
        int t=Integer.parseInt(T);
        Integer n;
        Integer trace=0;
       
		ArrayList<cases>Cases=new ArrayList<cases>();
	
		/*N is the number of columns or rows in each matrix */
		
		for(int i=0; i<t; i++) {
		  N=in.nextLine();
		  n=Integer.parseInt(N);
		int [] checkNumber= new int [n];
		int [] checkCol=new int [n];
		int [][]matrix=new int[n][n];
		  for(int row=0; row<n; row++ ) {
			  S=in.nextLine();
			  String []arr=S.split(" ");
			  
			  for(int col=0; col<n; col++) {
				 number=Integer.parseInt(arr[col]);
				 if(col==row) {
					 trace=trace+number;
				 }
				
				 
				 }
				 
	}
			  
			 
		  
		
		  
		  caseNumber=i+1;
		  cases tmp=new cases(caseNumber,trace, no_row, no_col);
		  Cases.add(tmp);
		 // System.out.println("Case" + " "+"#"+caseNumber.toString()+":"+n.toString()+no_row.toString()+ " "+ no_col.toString());
		  no_row=0;
		  no_col=0;
		  trace=0;
			
		}
		
		for(int i=0; i<Cases.size(); i++) {
			cases curr=Cases.get(i);
			System.out.println("Case" + " "+"#"+curr.getNumber().toString()+":"+" " +curr.getTrace().toString()+" "+curr.getRow().toString()+ " "+ curr.getCol().toString());
		}
        in.close();
        
   
   }


}    
        

