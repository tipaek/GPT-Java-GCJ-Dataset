import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        int t = scan.nextInt();
    
        for(int k = 1; k <= t; k++){
        
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            int rastro = 0;
            int col = 0;
            int fil = 0;
            
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                
                    arr[i][j] = scan.nextInt();    
                    if(i == j){
                        rastro += arr[i][j];
                    }
                }
            }

                for(int i = 0; i < n; i++){
                    int[] num = new int[n];
                    boolean comp = false;
                    for(int j = 0; j < n; j++){
                        num[j] = arr[i][j];
                        if(!comp){
                            for(int z = j-1; z >=0; z--){
                                
                                if(num[j] == num[z]){
                                    comp = true;
                                    fil++;
                                }
                            }
                        }   
                    }
                }

                for(int i = 0; i < n; i++){
                    int[] num = new int[n];
                    boolean comp = false;
                    for(int j = 0; j < n; j++){
                        num[j] = arr[j][i];
                        if(!comp){
                            for(int z = j-1; z >=0; z--){

                                if(num[j] == num[z]){
                                    comp = true;
                                    col++;
                                }
                            }
                        }   
                    }
                }

            System.out.println("Case #" + k + ": " + rastro + " " + fil + " " + col);

        }

    }
}