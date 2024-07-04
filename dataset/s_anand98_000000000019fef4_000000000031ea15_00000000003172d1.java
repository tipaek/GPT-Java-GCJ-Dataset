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
            HashMap<Long,Long> map = new HashMap<Long, Long>();
            long a[] = new long[n];
            long sum=0;
            for(int i=0;i<n;i++){
                a[i] = Long.parseLong(s[i]);
                sum += a[i];
                if(map.containsKey(a[i])){
                    long v = map.get(a[i]);
                    map.put(a[i], v+1);
                }
                else{
                    map.put(a[i],1L);
                }
            }

            if(sum<d){sb.append("Case #"+test+": "+(d-1)+"\n");continue;}

            long ans =Long.MAX_VALUE;
            for(long key:map.keySet()){
                if(map.get(key)>=d){ans=0;break;}
            }

            if(ans == 0){sb.append("Case #"+test+": "+ans+"\n");continue;}

            for(long key:map.keySet()){

                long v = key;
                long count=0;
                long cuts = 0;
                for(int i=0;i<n;i++){
                    
                    if(a[i]%key != 0)continue;

                    long value = a[i]/key;
                    if(count+value>d){
                        long rem = d-count;
                        count = d;
                        cuts += rem;
                    }
                    else{
                        count += value;
                        cuts += (value-1);
                    }

                    if(count>=d)break;
                           
                }

                if(count>=d){
                    ans = (int)Math.min(ans, cuts);
                    continue;
                }

                for(int i=0;i<n;i++){
                    
                    if(a[i]%key == 0)continue;

                    long value = a[i]/key;
                    if(count+value>d){
                        long rem = d-count;
                        count = d;
                        cuts += rem;
                    }
                    else{
                        count += value;
                        cuts += value;
                    }

                    if(count>=d)break;
                           
                }

                if(count>=d){
                    ans = (int)Math.min(ans, cuts);
                    continue;
                }

            }

            if(ans == Integer.MAX_VALUE){ans=(int)(d-1);}

            sb.append("Case #"+test+": "+ans+"\n");
        }
            
        System.out.print(sb);
    }
}