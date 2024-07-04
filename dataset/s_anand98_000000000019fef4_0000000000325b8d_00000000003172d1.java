import java.io.*;
import java.util.*;

class Solution {

    public static long getMin(long a[] , long d, long size){


        ArrayList<Long> div = new ArrayList<Long>();
        ArrayList<Long> notDiv = new ArrayList<Long>();

        for(int i=0;i<a.length;i++){
            if(a[i]%size == 0)div.add(a[i]);
            else notDiv.add(a[i]);
        }

        Collections.sort(div);
        Collections.sort(notDiv);

        long count=0;
        long cuts=0;
        for(int i=0;i<div.size();i++){

            long x = div.get(i);
            long value = x/size;
            if(count+value>d){
                long rem = d-count;
                count = d;
                cuts += rem;
            }
            else{
                count += value;
                cuts = (value-1);
            }

            if(count>=d){break;}
        }

        if(count>=d){
            return cuts;
        }

        for(int i=0;i<notDiv.size();i++){

            long x = notDiv.get(i);
            long value = x/size;
            if(count+value>d){
                long rem = d-count;
                count = d;
                cuts += rem;
            }
            else{
                count += value;
                cuts = value;
            }

            if(count>=d){break;}
        }

        if(count>=d){
            return cuts;
        }

        else
            return Long.MAX_VALUE;

    }


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

                long cuts = getMin(a, d,key);
                ans = (long)Math.min(ans, cuts);
            }

            if(ans == Integer.MAX_VALUE){ans=(int)(d-1);}

            sb.append("Case #"+test+": "+ans+"\n");
        }
            
        System.out.print(sb);
    }
}