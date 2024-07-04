import java.util.*;

class Solution{
    
    public static int row(int n, int[][] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<n; i++){
            map.clear();
            for(int j=0; j<n; j++){
                if(map.containsKey(arr[i][j])){
                    count++;
                    break;
                }
                else{
                    map.put(arr[i][j], 1);
                
                }
            }
        }
        return count;
    }
    
    public static int col(int n, int[][] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<n; i++){
            map.clear();
            for(int j=0; j<n; j++){
                if(map.containsKey(arr[j][i])){
                    count++;
                    break;
                }
                else{
                    map.put(arr[j][i], 1);
                
                }
            }
        }
        return count;
    }
    
    public static int diagonal(int n, int[][] a){
        int sum = 0;
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    sum += a[i][j];
                }
            }    
        }
        return sum;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, cur_case = 1;
        int a[][];
        while(cur_case<=t){
            n = sc.nextInt();
            a = new int[n][n];
            for(int i = 0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            int row_count = row(n, a);
            int col_count = col(n, a);
            int sum = diagonal(n,a);
            System.out.println("Case #"+cur_case+": "+sum+" "+row_count+" "+col_count);
            cur_case++;
        }
    }
}