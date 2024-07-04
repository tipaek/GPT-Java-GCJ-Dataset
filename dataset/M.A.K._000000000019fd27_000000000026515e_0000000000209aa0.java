import java.util.*;
class LatinSquare { 
      
  
    public void printLatin(int n) 
    { 
          
        
        int k = n+1; 
      
      
        for (int i = 1; i <= n; i++) 
        { 
  
            int temp = k; 
  
            while (temp <= n) 
            { 
                System.out.print(temp + " "); 
                temp++; 
            } 
      
           
            for (int j = 1; j < k; j++) 
                System.out.print(j + " "); 
      
            k--; 
            System.out.println(); 
        } 
    }  
          
    
    public static void main (String[] args) 
    { 
    	System.out.println("Enter :");        
    	Scanner s =new Scanner(System.in);
    	
    	int n =s.nextInt(); 
          
        // Invoking printLatin function 
        LatinSquare ls = new LatinSquare();
        ls.printLatin(n); 
    } 
} 
  
