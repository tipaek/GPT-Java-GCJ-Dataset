import java.util.*;
class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            int N = sc.nextInt();
            int D = sc.nextInt();
            long[] arr = new long[N];
            for(int i=0;i<N;i++){
                arr[i] = sc.nextLong();
            }
            
            long ans = Long.MAX_VALUE;
            for(int i=0;i<N;i++){
                long dine = 0, minSlice = 0;
                // Get Equal
                for(int j=0;j<N;j++){
                    if(arr[i]==arr[j])
                        dine++;
                }
                if(dine >= D){
                    ans = 0;
                    break;
                }
                
                for(int j=0;j<N;j++){
                    long val = arr[j];
                    if(i!=j){
                        while(val>arr[i] && dine<D){
                            val = val-arr[i];
                            dine++;
                            minSlice++;
                            if(val==arr[i])
                                dine++;
                        }
                        
                    }
                }
                
                if(dine<D){
                    minSlice = D-1;
                }
                ans = Long.min(ans, minSlice);
            }
            System.out.println("Case #"+t+": "+ans);
                
        }
    }
}