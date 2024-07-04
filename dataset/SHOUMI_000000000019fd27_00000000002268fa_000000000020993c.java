import java.util.*;
public class Solution {
   public static void main(String[] args) {
	   int matrix_trace=0;
		int no_of_repeated_rows = 0;
		 int no_of_repeated_colms =0;
		 int counter =0;
		 int noOfRows = 1;
		 int colm_no =0;
	   ArrayList<Integer> list = new ArrayList<Integer>();
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   for(int x=1;x<=t;x++) {
	   int givenNumber = in.nextInt();
	     for(int i=0;i<givenNumber*givenNumber;i++) {
		   list.add(in.nextInt());
	   }
	   //calculating matrix trace
	   for(int j=0;j<givenNumber*givenNumber;j +=givenNumber+1) {
		   matrix_trace += list.get(j);
		   
	   }
//calculating no. of rows containing repeated elements of matrix
	   
	   
	   
	   for(int n=0;n<givenNumber*givenNumber;n +=givenNumber) {
		   
	   for(int k=n;k<givenNumber*noOfRows ;k++) {
		   for(int l=k+1;l<givenNumber*noOfRows;l++) {
		   if(list.get(k) == list.get(l)) {
				   counter += 1;
			   }
		     }
	   }
	   if(counter>0) {
		   no_of_repeated_rows +=1;
		   counter=0;
	   }
	   noOfRows +=1;
	   
	   }
	  
	 
	   //calculating no. of columns containing repeated values
	  
	   
	   for(int b=0;b<givenNumber;b++) {
		   for(int c=b;c<givenNumber*givenNumber;c +=givenNumber) {
			for(int d=c+givenNumber;d<givenNumber*givenNumber;d +=givenNumber) {
				    if(list.get(c) == list.get(d)) {
					   counter += 1;
				   }
			   }
		   }
		   if(counter>0) {
			   no_of_repeated_colms +=1;
			   counter=0;
		   }
		   colm_no +=1;
		  }
	 System.out.println("Case #" + x +": " + matrix_trace + " " + no_of_repeated_rows + " " + no_of_repeated_colms); 
	 matrix_trace=0;
     no_of_repeated_rows = 0;
		  no_of_repeated_colms =0;
		  counter =0;
		  noOfRows = 1;
		 colm_no =0;
		 list.clear();
	   }
}
}