import java.util.*;

public class Solution{    
    public static void main(String args[])throws Exception{             
        Scanner sc = new Scanner(System.in);           
        int test = sc.nextInt();
        int caseno = 1;
        while(test-->0){
            int size = sc.nextInt();
            int[][] arr = new int[size][size];
            int row = 0;
            int col = 0;
            int sum = 0;
            boolean valid = true;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int[] search = new int[100];
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    arr[i][j] = sc.nextInt();
                    if(i == j){
                        sum = sum + arr[i][j];
                    }
                    if(map.containsKey(arr[i][j]) && valid){
                        row++;
                        valid = false;
                    } else {
                        map.put(arr[i][j], 1);
                    }
                }
                valid = true;
                map.clear();
            }
            
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(map.containsKey(arr[j][i]) && valid){
                        col++;
                        valid = false;
                    } else {
                        map.put(arr[j][i], 1);
                    }
                }
                valid = true;
                map.clear();
            }
            
            System.out.println("Case #" + (caseno++) + ": " + sum + " " + row + " " + col);
            
        }
    }    
}  
