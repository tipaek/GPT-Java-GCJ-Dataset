import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static final int MAX_WIDTH=1000000000;
    final int MAX_HEIGHT=1000000000;
   static Scanner scanner;
    public static void main(String[] args) {


         scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();//min radius
            int D = scanner.nextInt();//max radius
            Long[] slicesSize = new Long[N];
            for(int j=0;j<N;j++){
                slicesSize[j]=scanner.nextLong();

            }
            System.out.println("Case #"+(i+1)+": "+print(slicesSize,D));




        }
    }

    private static long print(Long[] slicesSize, int diners) {
        int cuts=0;
        Long[] tmp=checkMaxCount(slicesSize);


        while(tmp[0]<diners){
            tmp=checkMaxCount(slicesSize);
            if(tmp[0]==diners)
                return cuts;
            Long divisor=printDivisors(max(slicesSize),diners,slicesSize);
            if(divisor==1){
                return cuts+(diners-tmp[0]);
            }
            ArrayList<Long> res = new ArrayList<>();
            System.out.println("divisor"+divisor);
            for(int i=0;i<slicesSize.length;i++){
                int tmpcuts=0;
                if(slicesSize[i]%divisor==0&&slicesSize[i]!=divisor) {
                    for (int j = 0; j < slicesSize[i] / divisor-1; j++) {
                        tmpcuts++;

                        if(tmp[0]+tmpcuts+1>=diners){
                            return cuts+tmpcuts;
                        }
                        cuts++;
                        res.add(divisor);
                        Long[] tmpArr=res.toArray(new Long[0]);
                        Long[] tmp5=checkMaxCount(tmpArr);
                        if(tmp5[0]==diners)
                            return cuts;
                    }
                } else{
                    res.add(slicesSize[i]);
                }
            }
            slicesSize=res.toArray(new Long[0]);


        }
        return cuts;

    }

    public static Long[] checkMaxCount(Long[] arr){
        Long max=0L;
        Long size=0L;

//map to store results in
        Map<Long, Long> counts = new HashMap<Long, Long>();

//Do the counting
        for (Long i : arr) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i)+1);
            } else {
                counts.put(i, 1L);
            }
        }

//Output the results
        for (Long i : counts.keySet()) {
            if(counts.get(i)>max){
                max=counts.get(i);
                size=i;
            }
        }


        return new Long[]{max,size};

    }
    public static Long max(Long arr[]){
        Long max=0L;
        for(int i=0;i<arr.length;i++){
            max=Math.max(arr[i],max);
        }
        return max;
    }



    static Long printDivisors(Long n, int numNeeded, Long[] nums)
    {
        Long max=0L;
        for (Long i=n; i>=1; i--)
        {
            int currentNum=0;
            for(int j=0;j<nums.length;j++) {
                if (nums[j] % i == 0) {

                    currentNum+=nums[j] / i;
                }
                max=Math.max(max,currentNum);
                if(max>=numNeeded){
                    return i;
                }
            }
        }
        return max;
    }
}