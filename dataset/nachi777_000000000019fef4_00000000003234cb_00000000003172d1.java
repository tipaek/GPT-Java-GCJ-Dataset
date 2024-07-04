import java.io.*;
import java.util.*;

 
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
    int t=Integer.parseInt(br.readLine());
    for(int j=1;j<=t;j++){
        String[] str=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int d=Integer.parseInt(str[1]);
        String[] s=br.readLine().split(" ");
        HashMap<Long,Integer> map = new HashMap<>();
       long x;
       int temp=0;
        for(int i=0;i<n;i++){
            x=Long.parseLong(s[i]);
            map.put(x,map.getOrDefault(x, 0)+1);
           // System.out.println(map.get(x));
            if(map.get(x)>=d)
                temp=1;
        }
//        System.out.println(d);
//        System.out.println(map);
        if(temp==1){
            System.out.println("Case #"+j+": "+0);
        }
        else if(d==2){
            System.out.println("Case #"+j+": "+1);
        }
        else{
            Set<Long> set=map.keySet();
            int flag=0;
            for(long a:set){
                if(set.contains(a/2)){
                    System.out.println("Case #"+j+": "+1);
                    flag=1;
                    break;
                }
            }
            
           if(flag==0)
                System.out.println("Case #"+j+": "+2);
        }
    }
    }}