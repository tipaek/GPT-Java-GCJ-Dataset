import java.util.*;
import java.lang.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution{
    public static Map<Long, Integer> freq;
    public static int getSmallestCount(long[] arr, int d, int n){
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(freq.get(arr[i]) == d)
                return 0;
        }
        if(d == 2){
            return 1;
        }
        else if(d == 3){
            if(n==1)
                return 2;
            else if(n==2){
                if(arr[0]*2 == arr[1])
                    return 1;
                else
                    return 2;
            }
            else{
                for(int i=0;i<n;i++){
                    if(Arrays.asList(arr).contains(arr[i]*2))
                        return 1;
                }
                return 2;
            }
        }
        return 1;
    }
    
     
     public static void main(String []args){
         Scanner sc = new Scanner(System.in);
         int tt=0;
         int t = sc.nextInt();
         while(tt++<t){
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] arr = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }
            freq = new HashMap<>();

		    for (long s: arr){
			    int prev = 0;
			// get previous count
			    if (freq.get(s) != null)
				    prev = freq.get(s);
			    freq.put(s, prev + 1);
		    }
		    System.out.println("Case #"+tt+": "+getSmallestCount(arr,d,n));
        }
    }
}