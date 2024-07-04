import java.util.*;
public class Solution{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k = 1; k<=t; k++){
            int n = sc.nextInt();
            int[][] nums=  new int[n][3];
            for(int i = 0; i<n; i++){
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
                nums[i][2] = i;
            }
            System.out.println("Case #"+ k + ": " + schedule(nums));
        }
        
    }
    
    public static String schedule(int[][] nums){
        
        Arrays.sort(nums, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]==b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        char[] res = new char[nums.length];
        int x = 0, y = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i][0]>=x){
                res[nums[i][2]] = 'C';
                x = nums[i][1];
            }
            else if(nums[i][0]>=y){
                res[nums[i][2]] = 'J';
                y = nums[i][1];
            }
            else{
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(res);
        
    }
    
}