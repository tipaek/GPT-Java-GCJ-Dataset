import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++){
            int size = sc.nextInt();
            int[][] mat = new int[size][size];
            
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    mat[j][k] = sc.nextInt();
                }
            }
            
            latinSquare(mat, size, i+1);
        }
    }
    
    public static void latinSquare(int[][] mat, int size, int testcaseNum){
        int kTrace = 0;
        
        for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    if(j == k){
                        kTrace += mat[j][k];
                    }
                }
        }
        
        
        int rowSum = 0;
        HashMap<Integer, Integer> mapRow = new HashMap<>();
        for(int i = 0; i < size; i++){
            for(int m = 0; m < size; m++){
                if(!mapRow.containsKey(mat[i][m]))
                {
                    mapRow.put(mat[i][m], 0);
                }
                else
                {
                    int val = mapRow.get(mat[i][m]);
                    mapRow.put(mat[i][m], val + 1);
                }
            }
            
            
            for(int val : mapRow.values()){
                if(val > 0){
                    rowSum += 1;
                    break;
                }
            }
            
            mapRow.clear();
        }
        
        
        
        int colSum = 0;
        HashMap<Integer, Integer> mapCol = new HashMap<>();
        for(int i = 0; i < size; i++){
            for(int m = 0; m < size; m++){
                if(!mapCol.containsKey(mat[m][i]))
                {
                    mapCol.put(mat[m][i], 0);
                }
                else
                {
                    int val = mapCol.get(mat[m][i]);
                    mapCol.put(mat[m][i], val + 1);
                }
            }
            for(int val : mapCol.values()){
                if(val > 0){
                    colSum += 1;
                    break;
                }
            }
            
            mapCol.clear();
        }
        
        System.out.println("Case #"+testcaseNum+": "+kTrace+" "+rowSum+" "+colSum);
    }
}