import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt() , case_num = 1;
        
        while(test-- > 0){
            int size = sc.nextInt();
            
            int[][] mat = new int[size][size];
            
            int trace = 0 , count_row = 0 , count_col = 0;
            
            for(int i = 0 ; i < size ; i++){
                for(int j = 0 ; j < size ; j++){
                    mat[i][j] = sc.nextInt();
                    
                }   
                
                trace += mat[i][i];
            }
            
            for(int i = 0 ; i < size ; i++){
                HashSet<Integer> set_row = new HashSet<>();
                HashSet<Integer> set_col = new HashSet<>();
                
                for(int j = 0 ; j < size ; j++){
                    if(set_row.contains(mat[i][j])){
                        count_row++;
                        break;
                    }
                    set_row.add(mat[i][j]);
                }
                
                for(int j = 0 ; j < size ; j++){
                    if(set_col.contains(mat[j][i])){
                        count_col++;
                        break;
                    }
                    set_col.add(mat[j][i]);
                }
            }
            
            System.out.println("Case #" + case_num + ": " + trace + " " + count_row + " " + count_col);
            
            case_num++;
        }
    }
}