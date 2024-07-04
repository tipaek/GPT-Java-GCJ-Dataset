import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int i=1;i<=T;i++){
            int N = in.nextInt();
            int[][] temp = new int[N][3];
            for(int j=0;j<N;j++){
                temp[j][0] = in.nextInt();
                temp[j][1] = in.nextInt();
                temp[j][2] = j;
            }
            System.out.println("Case #"+i+": "+getSchedule(temp));
        }
    }
    
    public static String getSchedule(int[][] nums){
        
        int cStart = 0,cFinish = 0;
        int jStart = 0,jFinish = 0;
        
        int[][] chArr = new int[nums.length][2];
        
        for(int i=0;i<chArr.length;i++){
            chArr[i][1] = i;
        }
        
        Arrays.sort(nums,(a,b)->{
            return a[0]-b[0];
        });
        
        for(int i=0;i<nums.length;i++){
            int start = nums[i][0],finish = nums[i][1];
            
            if(finish <= cStart || cFinish <= start){
                cStart = start;
                cFinish = finish;
                
                chArr[i][0] = 'C';
            }else if(finish <= jStart || jFinish <= start){
                jStart = start;
                jFinish = finish;
                
                chArr[i][0] = 'J';
            }else{
                return "IMPOSSIBLE";
            }
        }
        
        Arrays.sort(chArr,(a,b)->{
            return nums[a[1]][2] - nums[b[1]][2];
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chArr.length;i++){
            sb.append((char)chArr[i][0]);
        }
        return sb.toString();
    }
}