import java.util.*;
public class Solution{
    
    static String assignTask(int start[], int end[], int N){
        String ans = "";
        for(int i=0;i<N;i++){
            
            if(i+1 < N && end[i] >= end[i+1] && start[i] <= start[i+1]){
                ans = "IMPOSSIBLE";
                break;
            }
                
            if(i+1 < N && start[i+1] < end[i])
                ans = ans+"C";
            else{
                ans = ans+"J";
            }
        }
        return ans;
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t=1;t<=T;t++){
            int N = scan.nextInt();
            int start[] = new int[N];
            int end[] = new int[N];
            for(int i=0;i<N;i++){
                start[i] = scan.nextInt();
                end[i] = scan.nextInt();
            }
            System.out.println("Case #"+t+": "+assignTask(start,end,N));
        }
    }
}