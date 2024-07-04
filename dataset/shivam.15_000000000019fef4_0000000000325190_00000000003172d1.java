import java.util.*;
import java.io.*;
class Solution{
    static int a[][];
    static boolean visited[][];
    static boolean bf[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int t_=1;t_<=t;t_++){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            
            HashMap<Long, Integer> hm = new HashMap();
            s = br.readLine().trim().split(" ");
            
            for(int i=0;i<n;i++){
                long cur = Long.parseLong(s[i]);
                hm.put(cur, hm.getOrDefault(cur, 0)+1);
            }
            
            int res = -1;
            for(long i:hm.values()){
                if(i == d){
                    res = 0;break;
                }
            }
            if(res == -1){
                if(d == 2) res = 1;
                else{
                    if(n == 1)
                        res = 2;
                    else
                        res = 1;
                }
            }
            System.out.println("Case #"+t_+": "+res);
        }
    } 
} 
