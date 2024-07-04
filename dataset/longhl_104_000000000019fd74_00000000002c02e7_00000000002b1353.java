import java.util.*;

public class Solution{
	 public static int factorial(int n){    
		 if (n == 0)    
			 return 1;    
		 else    
			 return(n * factorial(n-1));    
	 }   
	public static int combination(int row, int col){
		return factorial(row) / (factorial(col) * factorial(row-col) );
	}
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
      int num_line = Integer.parseInt(scanner.nextLine());
      int m =0;
      
      while(m< num_line){
		  int number = Integer.parseInt(scanner.nextLine());
		 int i =0;
		 int j =0;
		  int num =0;
		  System.out.println("Case #"+(m+1)+":");
		  int first = combination(i,j);
		  System.out.println((i+1)+" "+(j+1));
		  num+=first;
		  int b =0;
		  while(num != number){
			  j =0; 
			  i+=1;
			  boolean is_found = false;
			  boolean found =false;
			  if (num+Math.pow(2,i) > number){
				  found = true;
			  }
			  if(found == false){
				  if(b%2 ==0){
					  for(int k =j ;k <=i; k++ ){
						   System.out.println((i+1)+" "+(k+1));
						  num+= combination(i,k);
						  if(num == number){

							  break;
						  }
					  }
				  }else{
					  for(int k =i ;k >=j; k-- ){
						  System.out.println((i+1)+" "+(k+1));
						  num+= combination(i,k);
						  if(num == number){

							  break;
						  }
					  }
				  }
			  }else{
				   j=i;
				  
				while (num!= number){
					System.out.println((i+1)+" "+(j+1));
					num+=1;
					i+=1;
					j+=1;
				}	
				  if(num==number){
					  break;
				  }
			  }
			  b+=1;
			  if (is_found){
				  break;
			  }
			  if(num> number){

				 	 
				  break;
			  }
		  }
		
          m++;
      }
      
    }
}