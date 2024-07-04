import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for(int i = 0 ; i < a ; i++){
            
            int b = input.nextInt();
            int c = input.nextInt();
            
            String possible = "POSSIBLE";
            if(c % b == 0 && b <= c && c <= b*b){
               int test = c / b;
                int[][] e = new int[b][b];
                
                for(int k2 = 0; k2 < b ;k2++){
                 if(test > b){
                    test = test - b;   
                 }
                 e[0][k2] = test;
                 test++;
                }
                
                for(int k2 = 1; k2 < b; k2++){
                    for(int k1 = 0; k1 < b ; k1++){
                        if(e[k2-1][k1]-1 == 0) {
                            e[k2][k1] = b;
                        }
                        else{
                            e[k2][k1] = e[k2-1][k1] - 1;    
                        }
                    }    
                }
                
                System.out.println("Case #"+(i+1)+": " + possible);
    
                for(int k2 = 0; k2 < b ;k2++){
                    for(int k1 = 0; k1 < b; k1++){
                        System.out.print(e[k2][k1]);
                        if(k1 != b-1){
                            System.out.print(" ");
                        }
                        else if (i == a-1 && k2 == b-1 && k1 == b-1) {
                        	
                        }
                        else if(k1 == b-1){
                            System.out.print("\n");
                        }
                    }
                }
            }
            else {
                possible = "IMPOSSIBLE";
        		if(i == a-1){
        			System.out.print("Case #"+(i+1)+": " + possible);	
        		}
            	else {
            		System.out.println("Case #"+(i+1)+": " + possible);
            	}
            }
        
        }
    }
}