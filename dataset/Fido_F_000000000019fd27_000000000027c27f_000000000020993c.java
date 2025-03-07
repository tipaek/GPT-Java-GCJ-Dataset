import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int T = Integer.parseInt(input.nextLine());
        
        for(int x = 1; x <= T ; x++){
            int N = Integer.parseInt(input.nextLine());
            int k = 0;
            int c = 0;
            int r = 0;
            
            int[][] matrix = new int[N][N];           
            
            for(int i = 0; i < N; i++) {
            	String in = input.nextLine();
            	String[] splitIn = in.split(" ");    
            	int[] rep = new int[101];
            	boolean check = false;
            	            	           	 	
            	for(int j = 0 ; j < N; j++) {
            		int toAdd = Integer.parseInt(splitIn[j]);
            		matrix[i][j] = Integer.parseInt(splitIn[j]);
            		if(rep[toAdd] > 0 && !check) {
            			r++;            			
            			check = true;
            		}
            		rep[toAdd]++;
            	}
            	k += matrix[i][i];
            }
            
            for(int j = 0; j < N; j++ ) {
            	int[] rep = new int[101];
            	boolean check = false;
	            for(int i = 0; i < N; i++ ) {
	            	if(rep[matrix[i][j]] > 0 && !check) {
	            		c++;	            		
	            		check = true;
	            	}
	            	rep[matrix[i][j]]++;
	            }
            }
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
        
        input.close();
        
    }
}