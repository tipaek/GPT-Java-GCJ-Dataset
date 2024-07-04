
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for(int h=1;h<=t;h++) {
            str.append("Case #" + h + ": ");
            String in[] = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            long d = Long.parseLong(in[1]);
            Map<Integer, List<Long>> s = new HashMap<>();
            in = br.readLine().split(" ");
            long arr[] = new long[n];
            Set<Long>  set = new HashSet<>();
            for(int i=0;i<n;i++){
                arr[i] = Long.parseLong(in[i]);
                set.add(arr[i]);
            }
            Arrays.sort(arr);
            long ans = d-1;
            for(long hl:set){
                long count = 0;
                long currSlice=0L;
                long greater = 0L;
                for(int i=0;i<n;i++){
                    if(arr[i]==hl){
                        currSlice++;
                    } else if(arr[i]%hl==0){
                        long b=arr[i]/hl;
                        if(currSlice+b>=d){
                           // if(arr[i]%hl!=0){
                                count+=Math.min(d-currSlice, b-1);
                           // } else {
                              //  count+=Math.min(d-currSlice, arr[i]/hl-1);
                           // }
                            currSlice=d;
                        } else {
                            currSlice+=b;
                            count+=(arr[i]/hl-1);
                        }

                    } else if(arr[i]>hl){
                        greater++;
                    }
                    if(currSlice>=d){
                        break;
                    }
                }
                if(currSlice>=d){
                    ans = Math.min(count, ans);
                } else if(greater+currSlice>=d){
                    ans = Math.min(ans, d-currSlice);
                }
            }
            str.append(ans+"\n");

        }
        out.print(str);
        out.flush();
        br.close();
    }

    public static int getValue(int arr[], int N,
                                  int X, int d)
    {
        int cost = 0;
        int slice = 0;
        for (int i = 0; i < N; i++){
          //  if(arr[i])
        }
        return cost;
    }

    public static int getAns(int arr[], int N, int d)
    {
        int low, high;
        low = high = arr[N-1];

        while ((high - low) > 2) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            int cost1 = getValue(arr, N, mid1, d);
            int cost2 = getValue(arr, N, mid2, d);
            if (cost1 < cost2)
                high = mid2;
            else
                low = mid1;
        }
        return getValue(arr, N, (low + high) / 2, d);
    }

    private static void addDivisor(long a, Map<Integer, List<Long>> s) {
        for(int i=1;i<=(int)Math.sqrt(a);i++){
            if(a%(long)i==0L){
                List<Long> k = s.getOrDefault(i, new ArrayList<>());
                k.add(a);
                s.put(i, k);
                int h = (int)(a/(long)i);
                if(h !=i){
                    k = s.getOrDefault(h, new ArrayList<>());
                    k.add(a);
                    s.put(h, k);
                }
            }
        }
    }
}

