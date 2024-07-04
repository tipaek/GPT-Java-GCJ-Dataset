
  
package question2;

import java.util.Scanner;

class Question2{
  
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        
        int T,N;
        
        T= input.nextInt();
        N =input.nextInt();
        
        
        for(int i = 1;i<=T;i++){
        int S,E;
        
        for(int j = 1;j<=N;i++){
            S=input.nextInt();
            E=input.nextInt();
            check(S,E);
        }
        
       }
    }
    public static void check(int S,int E){
    Scanner input = new Scanner(System.in);    
    
    int S2,E2;
     S2=input.nextInt();
     E2=input.nextInt();
    
    if(E > S2)
         System.out.println("CJ");
    else if(E>S2)
         System.out.println("JC");
    else
         System.out.println("Impossible");
    
    }
    
  
    
}
