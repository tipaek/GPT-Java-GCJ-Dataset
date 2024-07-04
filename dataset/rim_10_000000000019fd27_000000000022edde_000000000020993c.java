import java.util.*;
public class Solution{
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    int count=1;
    sc.nextLine();
    while(t > 0){
       int n = sc.nextInt();
       int[][] arr = new int[n][n];
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            arr[i][j] = sc.nextInt();
        }
      }
      int k = 0;
      int r = 0;
      int c = 0;
      int flagCol = 0;
      
        for(int i=0;i<n;i++){
        	int flagRow = 0;
        	Set<Integer> col = new HashSet<>();
        	Set<Integer> row = new HashSet<>();
        	

            for(int j=0;j<n;j++){
            	//Diagonal sum
                if(i==j){
                    k += arr[i][j];
                }
                //duplicate row;
                if(row.contains(arr[i][j])){
                    flagRow = 1;
                }
                row.add(arr[i][j]);  
                //duplicate col
	            if(col.contains(arr[j][i])) {
	            	flagCol = 1;
	            }
	            else {
	            	col.add(arr[j][i]);
	            }
	       }
            if(flagRow == 1) {
            	++r;
            }
            if(flagCol == 1) {
            	++c;
            }
            
        }
        System.out.println("Case #"+count+": "+ k + " " + r + " " + c);
        
       t--;
       count++;
    }
   }
    
}