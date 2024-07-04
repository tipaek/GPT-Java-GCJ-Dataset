import java.util.*;
public class Solution{

    static int[][] nums=  new int[500][500];
    static boolean flag = false;
    static int startX = -1, startY = -1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        getPascal(500);
        int[][] arr = new int[500][500];
        for(int i = 1; i<=t; i++){
            flag = false;
            startX = -1;
            startY = -1;
            for(int j = 0; j<500; j++){
                Arrays.fill(arr[j], 0);
            }
            int n = sc.nextInt();
            System.out.println("Case #" + i + ":");
            dfs(0, 0, n, arr, 1);
            getAns(startX, startY, arr, arr[startX][startY]);
        }
    }
    
    public static void getAns(int i, int j, int[][] arr,  int index){
        
        if(index==1){
            System.out.println((i+1) + " " + (j+1));
            return;
        }
        if(i-1>=0 && j-1>=0 && arr[i-1][j-1]==index-1){
            getAns(i-1, j-1, arr, index-1);
        }
        else if(i-1>=0 && arr[i-1][j]==index-1){
            getAns(i-1, j, arr, index-1);
        }
        else if(j-1>=0 && arr[i][j-1]==index-1){
            getAns(i, j-1, arr, index-1);
        }
        else if(j+1<=i && arr[i][j+1]==index-1){
            getAns(i, j+1, arr, index-1);
        }
        else if(i+1<nums.length && arr[i+1][j]==index-1){
            getAns(i+1, j, arr, index-1);
        }
        else if(i+1<nums.length && j+1<=i+1 && arr[i+1][j+1]==index-1){
            getAns(i+1, j+1, arr, index-1);
            
        }
        System.out.println((i+1) + " " + (j+1));
        
    }
    
    public static void dfs(int i, int j, int target, int[][] arr, int index){
        
        if(index>500)
            return;
        arr[i][j] = index;
        if(nums[i][j]==target){
            flag = true;
            startX = i;
            startY = j;
            return;
        }
        else if(nums[i][j]>target)
            return;
        int newTarget = target - nums[i][j];
        if(i-1>=0 && j-1>=0 && arr[i-1][j-1]==0){
            dfs(i-1, j-1, newTarget, arr, index+1);
            if(flag){
                return;
            }
        }
        if(i-1>=0 && arr[i-1][j]==0 ){
            dfs(i-1, j, newTarget, arr, index+1);
            if(flag){
                return;
            }
        }
        if(j-1>=0 && arr[i][j-1]==0){
            dfs(i, j-1, newTarget, arr, index+1);
            if(flag){
                return;
            }
        }
        if(j+1<=i && arr[i][j+1]==0){
            dfs(i, j+1, newTarget, arr, index+1);
            if(flag){
                return;
            }
        }
        if(i+1<nums.length && arr[i+1][j]==0){
            dfs(i+1, j, newTarget, arr, index+1);
            if(flag){
                return;
            }
        }
        if(i+1<nums.length && j+1<=i+1 && arr[i+1][j+1]==0){
            dfs(i+1, j+1, newTarget, arr, index+1);
            if(flag){
                return;
            }
        }
        arr[i][j] = 0;
        
    }
    
    public static void getPascal(int n) { 
        
        for (int line = 0; line < n; line++) { 
            for (int i = 0; i <= line; i++) { 
                if (line == i || i == 0) 
                    nums[line][i] = 1; 
                else 
                    nums[line][i] = nums[line-1][i-1] + nums[line-1][i]; 
            } 
        } 
    } 
    
}