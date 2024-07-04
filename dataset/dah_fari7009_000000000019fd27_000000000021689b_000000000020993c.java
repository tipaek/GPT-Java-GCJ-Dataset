import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = Integer.parseInt(scanner.nextLine());
        for(int a=1;a<=totalTests;a++){
            int dim = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[dim][dim];
            int trace = 0, numRows = 0, numCols = 0;
            for(int i=0;i<dim;i++){
                HashSet set = new HashSet();
                String line = scanner.nextLine();
                String[] words = line.split("\\s");
                System.out.println("Words: "+line+" "+Arrays.toString(words));
                boolean repeated = false;
                for(int j = 0;j<dim;j++){
                    matrix[i][j] = Integer.parseInt(words[j]);
                    if(!repeated && set.contains(matrix[i][j])){
                        numRows ++;
                        repeated = true;
                    }
                    set.add(matrix[i][j]);
                }
            }
            for(int i = 0;i<dim;i++){
                System.out.println(Arrays.toString(matrix[i]));
            }
            System.out.println();

            for(int j=0;j<dim;j++){
                trace += matrix[j][j];
                HashSet set = new HashSet();
                for(int i=0;i<dim;i++){
                    if(set.contains(matrix[i][j])){
                        numCols ++;
                        break;
                    }
                    set.add(matrix[i][j]);
                }
            }
            System.out.println("Case #"+a+": "+trace+" "+numRows+" "+numCols);
        }
    }
}