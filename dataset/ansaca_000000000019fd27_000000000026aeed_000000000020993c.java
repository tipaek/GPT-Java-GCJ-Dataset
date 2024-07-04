import java.util.*;

public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int n = 1; n <= cases; n++){
            
            
            int len = sc.nextInt();
            HashSet<Integer> set = new HashSet<Integer>(len);
            int[][] matrix = new int[len][len];
            for(int i = 0; i < len; i++)
                for(int j = 0; j < len; j++)
                    matrix[i][j]=sc.nextInt();
                    
            int diagonal = 0, columns = 0, rows = 0;
            for(int i = 0; i < len; i++){
                diagonal+= matrix[i][i];
                set.clear();
                for(int j = 0; j < len; j++){
                    if(set.contains(matrix[i][j])){
                        rows++;
                        break;
                    }else{
                        set.add(matrix[i][j]);
                    }
                }
                set.clear();
                for(int j = 0; j < len; j++){
                    if(set.contains(matrix[j][i])){
                        columns++;
                        break;
                    }else{
                        set.add(matrix[j][i]);
                    }
                }
            }
            System.out.println("Case #" + n + ": " + diagonal + " " + rows + " " + columns);
        }
    }
}