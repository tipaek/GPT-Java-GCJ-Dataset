import java.util.*;
import java.lang.*; 

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<int[][]> input = new ArrayList<>();
        int testcases = scanner.nextInt();
        for(int i=0; i<testcases; i++){
            int dim = scanner.nextInt();
            int[][] matrix = new int[dim][dim];
            for(int j=0; j<dim; j++){
                for(int k=0; k<dim; k++){
                    matrix[j][k] = scanner.nextInt();
                }
            }
            input.add(matrix);
        }
        
        int size = input.size();
        
        for(int i=0; i<size; i++){
            int[][] arr = input.get(i);
            int[] answer = new int[3];
            
            for(int j=0; j<arr.length; j++){
                Set<Integer> rowhashset = new HashSet<>();
                Set<Integer> colhashset = new HashSet<>();
                for(int k=0; k<arr[0].length; k++){
                    if(j==k)
                        answer[0] += arr[j][k];
                    rowhashset.add(arr[j][k]);
                    colhashset.add(arr[k][j]);
                }
                answer[1] += rowhashset.size()==arr.length? 0:1;
                answer[2] += colhashset.size()==arr[0].length? 0:1;
            }
            System.out.println("Case #" + i+1 + ": " + answer[0] + " " + answer[1] + " " + answer[2]);
        }
    }
}