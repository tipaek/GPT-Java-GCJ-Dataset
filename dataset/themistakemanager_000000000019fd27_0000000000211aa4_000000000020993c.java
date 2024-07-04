import java.util.*;
public class Solution{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k = 1; k<=t; k++){
            int n = sc.nextInt();
            int[][] nums =  new int[n][n];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    nums[i][j] = sc.nextInt();
                }
            }
            System.out.println("Case #"+ k + ": " + trace(nums) + " " + repeatedElementsInRows(nums) + " " + repeatedElementsInColumns(nums));
        }
        
    }
    
    public static int repeatedElementsInColumns(int[][] nums){
        
        int res = 0;
        for(int i = 0; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<nums.length; j++){
                if(set.contains(nums[j][i])){
                    res++;
                    j = nums.length;
                }
                else{
                    set.add(nums[j][i]);    
                }
            }
        }
        return res;
        
    }
    
    public static int repeatedElementsInRows(int[][] nums){
        
        int res = 0;
        for(int i = 0; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<nums.length; j++){
                if(set.contains(nums[i][j])){
                    res++;
                    j = nums.length;
                }
                else{
                    set.add(nums[i][j]);    
                }
            }
        }
        return res;
        
    }
    
    public static int trace(int[][] nums){
        
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i][i];
        }
        return sum;
        
    }

}