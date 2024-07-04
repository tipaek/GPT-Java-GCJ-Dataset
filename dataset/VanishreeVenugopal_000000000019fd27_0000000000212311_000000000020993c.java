class LatinSquare { 
      
    // Function to print n x n Latin Square 
    static void printLatin(int N) 
    { 
          
        // A variable to control the  
        // rotation point. 
        int k = N+1; 
      
        // Loop to print rows 
        for (int i = 1; i <= N; i++) 
        { 
  
            // This loops runs only after 
            // first iteration of outer  
            // loop. It prints 
            // numbers from n to k 
            int temp = k; 
  
            while (temp <= N) 
            { 
                System.out.print(temp + " "); 
                temp++; 
            } 
      
            // This loop prints numbers from 
            // 1 to k-1. 
            for (int j = 1; j < k; j++) 
                System.out.print(j + " "); 
      
            k--; 
            System.out.println(); 
        } 
    }  
          
    // Driver code 
    public static void main (String[] args) 
    { 
        int N = 5; 
          
        // Invoking printLatin function 
        printLatin(N); 
    } 
} 
  