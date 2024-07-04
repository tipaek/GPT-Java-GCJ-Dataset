import java.io.*; 
import java.util.*; 
public class Solution {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            int n=input.nextInt();
            int d=input.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++) {
                arr[i]=input.nextLong();
            }
            System.out.println("Case #"+t+": "+solve(n,d,arr));
        }
    }
    public static long solve(int n,int d, long arr[]) {
        Arrays.sort(arr);
        long min=d-1;
        HashMap<Long,Long> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 0L);
            }
            map.replace(arr[i], map.get(arr[i])+1L);
        }
        for(int i=0;i<n;i++) {
            long cuts=0,pieces=map.get(arr[i]);
            for(int j=n-1;arr[j]!=arr[i];j--) {
                long tmp=arr[j];
                while(tmp-arr[i]>=0) {
                    if(pieces==d) {
                        break;
                    }
                    pieces++;
                    cuts++;
                    tmp-=arr[i];
                }
                if(tmp==0) {
                    cuts--;
                }
                if(pieces==d) {
                    min=Math.min(min,cuts);
                }
            }
        }
        return min;
    }
}
