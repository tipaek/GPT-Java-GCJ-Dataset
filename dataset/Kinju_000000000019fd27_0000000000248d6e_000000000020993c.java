import java.util.*;

public class Solution{

     public static void main(String []args){
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t=0 ; t < T ; t++){
            
            int N = sc.nextInt();
			
			int numArr[][] = new int[N][N];
			
			int trace = 0;
			for(int i=0; i<N; i++){

				for(int j=0; j<N; j++){
					
					numArr[i][j] = sc.nextInt();
					if(i == j){
						trace = trace + numArr[i][j];
					}
				}
			}
			
			int rowDupCnt = 0;
			for(int i=0; i<N; i++){ // Row

				boolean isRowDup = false;
				for(int j=0; j<N; j++){ // Row
					
					for(int k=0; k<N; k++){ // Col
					
						if(j != k && numArr[i][j] == numArr[i][k]){
							isRowDup = true;
							break;
						}
					}
					
					if(isRowDup){
						rowDupCnt = rowDupCnt + 1;
						break;
					}
				}
			}
			
			int colDupCnt = 0;
			for(int i=0; i<N; i++){ // Col

				boolean isColDup = false;
				for(int j=0; j<N; j++){ // Row
					
					for(int k=0; k<N; k++){ // Col
					
						if(j != k && numArr[j][i] == numArr[k][i]){
							isColDup = true;
							break;
						}
					}
					
					if(isColDup){
						colDupCnt = colDupCnt + 1;
						break;
					}
				}
			}
			
			System.out.println("Case #" +(t+1)+ ": " + trace + " " + rowDupCnt + " " + colDupCnt);
			
        }
        
        sc.close();
        System.exit(0);
        
     }
}