import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution {
  
    
    public static void main (String [] args){
        
        //Scanner
        Scanner input = new Scanner(System.in);
        
        
        int T = input.nextInt();    //test cases
        
        for(int i=0; i<T; i++){
            
            int x = i+1;
            int N = input.nextInt();
            
            char [] y = new char [N];   //answer
            int [] S = new int [N];     //start time
            int [] E = new int [N];     //end time
            
            char C = 'C';
            char J = 'J';
            int flag = 0;   //1 if impossible
            
            for(int j=0; j<N; j++)
                y[j] = 'x';
            
            for(int j=0; j<N; j++){
                S[j] = input.nextInt();
                E[j] = input.nextInt();
            }
            
            y[0] = C;   //assigning C to first task
            
            
            
            for(int j=1; j<N; j++){ //assigning rest of C's
                for(int k=0; k<j; k++){
                    
                    if(y[k] == C){
                        if((S[j]>S[k] && S[j]<E[k]) || (E[j]>S[k] && E[j]<E[k])){
                            y[j] = 'x';
                        }
                        else{
                            y[j] = C;
                        }
                    }
                }
            }
            
            
            for(int j=1; j<N; j++){
                if(y[j] == 'x'){
                    y[j] = J;
                    break;
                }
            }
            
            for(int j=1; j<N; j++){
                if(y[j] == 'x'){
                    for(int k=0; k<j; k++){
                    
                        if(y[k] == J){
                            if((S[j]>S[k] && S[j]<E[k]) || (E[j]>S[k] && E[j]<E[k])){
                                y[j] = 'x';
                            }
                            else{
                                y[j] = J;
                            }
                        }
                    }
                }
                
            }
            
            for(int j=0; j<N; j++){
                if(y[j] == 'x'){
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 1)
                System.out.println("Case #" + x + ": IMPOSSIBLE");
            else{
                System.out.print("Case #" + x + ": " );
                for(int j=0; j<N; j++)
                    System.out.print(y[j]);
                System.out.println("");
            }
        }
    }
}
