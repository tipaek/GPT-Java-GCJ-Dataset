import java.util.*;

public class Solution{

     public static void main(String []args){
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t=0 ; t < T ; t++){
            
            int N = sc.nextInt();
			int K = sc.nextInt();
			
			int numArr[] = new int[N];
			
			boolean possible = false;
			for(int i=0; i<N ; i++){
				
				numArr[i] = i+1;
				
				if(((i+1) * N) == K){
					possible = true;
				}
			}
			/*if(N%2 == 0){
				
				// Even Number
				int sumOfOddNum = 0;
				int sumOfEvenNum = 0;
				for(int i=0; i<N ; i++){
					
					numArr[i] = i+1;
					
					if((i+1)%2 == 0){
						// Iterated number is Even
						sumOfEvenNum = sumOfEvenNum + (i+1);
					}
					else{
						// Iterated number is Odd
						sumOfOddNum = sumOfOddNum + (i+1);
					}
				}
				
				possible = ( ( (sumOfEvenNum * 2) == K ) || ( (sumOfOddNum * 2) == K ) );
				
			}
			else{
				
				// Odd Number
				int sum = 0;
				for(int i=0; i<N ; i++){
					
					numArr[i] = i+1;
					sum = sum + (i+1);
				}
				
				possible = (sum == K);
				
			}*/
			
			if(possible){
			
				System.out.println("Case #"+(t+1)+": " + "POSSIBLE"); 
				
				int numCounter;
				for(int i=0; i<N ; i++){
					
					numCounter = i;
					for(int j=0; j<N ; j++){
						
						if(numCounter > (N-1)){
							numCounter = 0;
						}
						
						System.out.print(numArr[numCounter]);
						if(j != (N-1)){
							System.out.print(" ");
						}
						
						numCounter = numCounter + 1;
					}
					System.out.println("");
				}
				
			}
			else{
				System.out.println("Case #"+(t+1)+": " + "IMPOSSIBLE"); 
			}
        }
        
        sc.close();
        System.exit(0);
        
     }
}