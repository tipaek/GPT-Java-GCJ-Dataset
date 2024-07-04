import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int i=1;i<=T;i++){
            int N = in.nextInt();
            int[][] temp = new int[N][2];
            for(int j=0;j<N;j++){
                temp[j][0] = in.nextInt();
                temp[j][1] = in.nextInt();
            }
            System.out.println("Case #"+i+": "+getSchedule(temp));
        }
    }
    
    public static String getSchedule(int[][] nums){
        boolean C = true;
        boolean J = true;
        
        int cStart = -1,cFinish = -1;
        int jStart = -1,jFinish = -1;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<nums.length;i++){
            int start = nums[i][0],finish = nums[i][1];
            
            if(finish <= cStart || cFinish <= start){
                cStart = start;
                cFinish = finish;
                
                sb.append("C");
            }else if(finish <= jStart || jFinish <= start){
                jStart = start;
                jFinish = finish;
                
                sb.append("J");
            }else{
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }
}