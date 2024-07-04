import java.io.*;
import java.util.*;

class Solution {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine().trim());
        for(int test=1;test<=t;test++){
           
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            long d = Long.parseLong(s[1]);

            s=br.readLine().trim().split(" ");
            HashMap<Long,Integer> map = new HashMap<Long, Integer>();
            long a[] = new long[n];
            long sum=0;
            for(int i=0;i<n;i++){
                a[i] = Long.parseLong(s[i]);
                sum += a[i];
                if(map.containsKey(a[i])){
                    int v = map.get(a[i]);
                    map.put(a[i], v+1);
                }
                else{
                    map.put(a[i],1);
                }
            }

            if(sum<d){sb.append("Case #"+test+": "+(d-1)+"\n");continue;}

            int ans =Integer.MAX_VALUE;
            for(long key:map.keySet()){
                if(map.get(key)>=d){ans=0;break;}
            }

            if(ans == 0){sb.append("Case #"+test+": "+ans+"\n");continue;}

            for(long key:map.keySet()){

                long v = key;
                long count=0;
                long cuts = 0;
                for(int i=0;i<n;i++){
                
                    long value = a[i]/key;
                    if(count+value>d){
                        long rem = d-count;
                        count = d;
                        cuts += rem;
                    }
                    else{

                        if(a[i]%key == 0){
                            count += value;
                            cuts += (value-1);
                        }
                        else{
                                count += value;
                                cuts += value;
                            }

                    }

                    if(count>=d)break;
                           
                }

                if(count>=d){
                    ans = (int)Math.min(ans, cuts);
                }

            }

            if(ans == Integer.MAX_VALUE){ans=(int)(d-1);}

            sb.append("Case #"+test+": "+ans+"\n");
        }
            
        System.out.print(sb);
    }
}