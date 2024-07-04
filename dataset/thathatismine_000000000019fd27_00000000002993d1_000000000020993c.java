import java.util.*;

class Solution{
    public static void main(String args[]){
        
        Scanner scanner = new Scanner( System.in );
        int caseNum = scanner.nextInt();
        
        for(int m = 0; m < caseNum; m++){
            
            int rows = scanner.nextInt();
            scanner.nextLine();
            
            int[][] arr = new int[rows][];
        
            for (int i = 0; i < rows; ++i) {
                String line = scanner.nextLine();
                arr[i] = lineToIntArray(line);
            }
        
            int k = 0, r = 0, c = 0;
            
            k = diagonalSum(arr, k);
            
            for(int i = 0; i < arr.length; i++){
                if(doesRowHasRepeated(arr, i))
                    r++;
            }
        
            for(int i = 0; i < arr[0].length; i++){
                if(doesColHasRepeated(arr, i))
                    c++;
            }
            
            System.out.println("Case #" + (m+1) + ": " + k + " " + r + " " + c + " ");
        }
    }
    
    private static int diagonalSum(int[][] arr, int k){
        
        int r = 0, c = 0;
        while(r < arr.length){
            k += arr[r][c];
            r++;
            c++;
        }
        
        return k;
    }
    
    private static int[] lineToIntArray(String line) {
        return Arrays.asList(line.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
    }
    
    
    private static boolean doesRowHasRepeated(int[][] arr, int r){
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int c = 0; c < arr[r].length; c++){
            if(set.contains(arr[r][c])){
                return true;
            }else{
                set.add(arr[r][c]);
            }
        }
        return false;
    }
    
    private static boolean doesColHasRepeated(int[][] arr, int c){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int r = 0; r < arr.length; r++){
            if(set.contains(arr[r][c])){
                return true;
            }else{
                set.add(arr[r][c]);
            }
        }
        return false;
    }
}


