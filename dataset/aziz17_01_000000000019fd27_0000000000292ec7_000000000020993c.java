import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner a = new Scanner(System.in);
        int num_of_case = a.nextInt();
        for(int i = 0; i < num_of_case; i++){
            int size = a.nextInt();
            int[][] matrix = new int[size][size];
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    matrix[j][k] = a.nextInt();
                }
            }
            int trace = 0;
            for(int j = 0; j < size; j++){
                for(int k = j; k <= j; k++){
                    trace += matrix[j][k];
                }
            }
            int r = 0;
            int c = 0;
                int temp = 0;
                
                for(int j = temp; j < j+1; j++){
                    for(int k = 1; k < size; k++){
                        if(matrix[j][0] == matrix[j][k]){
                            r++;
                            break;
                        }
                    }
                    temp++;
                    if(temp == size){
                        break;
                    }
                }
                int temp1 = 0;
                for(int j = 1; j <= size; j++){
                    for(int k = 1; k < size; k++){
                        if(matrix[0][j-1] == matrix[k][j-1]){
                            c++;
                            break;
                        }
                    }
                }
                
                
               
            System.out.println("Case #" + (i+1) + ": "  + trace + " " + r + " " +c);   
        }
    }
}