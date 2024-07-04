import java.util.Scanner;
class Solution { 
      
    // Function to print n x n Latin Square 
    static void printLatin(int n, int sum) 
    { 
          
        // A variable to control the  
        // rotation point. 
        int k = sum; 
      
        // Loop to print rows 
        for (int i = 0; i < n; i++) 
        { 
  
            // This loops runs only after 
            // first iteration of outer  
            // loop. It prints 
            // numbers from n to k 
            int temp = k; 
  
            while (temp <= n) 
            { 
                System.out.print(temp + " "); 
                temp++; 
            } 
      
            // This loop prints numbers from 
            // 1 to k-1. 
            for (int j = 1; j < k; j++) 
                System.out.print(j + " "); 
      
            k--; 
            if(k<=0){
                k=n;
            }
            System.out.println(); 
        } 
    }  
          
    // Driver code 
    public static void main (String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int curCase = 1;
        while(curCase <= t){
            System.out.print("Case #"+curCase+": ");
            int n = sc.nextInt();
            int k = sc.nextInt();
            int sum;
              
            // Invoking printLatin function 
            if(k%n==0){
                sum = k/n;
                if(sum <=n){
                    System.out.println("POSSIBLE");
                    printLatin(n, sum);
                } 
                else{
                    System.out.print("IMPOSSIBLE");
                }
            }
            else{
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
            curCase++;
        }
    } 
} 