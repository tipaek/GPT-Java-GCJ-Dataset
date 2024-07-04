import java.io.*;
import java.util.*;
public class Solution{

     public static void main(String []args)throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        for(int T=1;T<=t;T++){
           line = br.readLine();
           int n = Integer.parseInt(line);
           int[] st = new int[n];
           char[] ans = new char[n];
           HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
           HashMap<Integer,Integer> d1hs = new HashMap<Integer,Integer>();
           HashMap<Integer,Integer> hs_i = new HashMap<Integer,Integer>();
           HashMap<Integer,Integer> d1hs_i = new HashMap<Integer,Integer>();
           StringBuilder sb = new StringBuilder("");
           int g=0;
           for(int i=0;i<n;i++){
           line = br.readLine();
              if(g!=-1){String[] strs = line.trim().split("\\s+");
               st[i] = Integer.parseInt(strs[0]);
               int y = Integer.parseInt(strs[1]);
               if(!hs.containsKey(st[i])){ hs.put(st[i],y); hs_i.put(st[i],i); }
               else if(!d1hs.containsKey(st[i])){ d1hs.put(st[i],y); d1hs_i.put(st[i],i); }
               else{g=-1;}
              }
           }
          Arrays.sort(st);
          int c = 0;
          int j = 0;
          for(int i=0;i<n;i++){
              if(hs.containsKey(st[i])){
                  int u = hs.get(st[i]);
                  int ind = hs_i.get(st[i]);
                  if(c<=st[i]){ c=u;  ans[ind] = 'C'; }
                  else if(j<=st[i]){ j=u; ans[ind] = 'J'; }
                  else{ g=-1; break; }
                  hs.remove(st[i]);
              }
              else if(d1hs.containsKey(st[i])){
                  int u = d1hs.get(st[i]);
                  int ind = d1hs_i.get(st[i]);
                  if(c<=st[i]){ c=u; ans[ind] = 'C'; }
                  else if(j<=st[i]){ j=u; ans[ind] = 'J'; }
                  else{ g=-1; break; }
                  d1hs.remove(st[i]);
              }
              
          }
           if(g==-1) sb = new StringBuilder("IMPOSSIBLE");
           else sb =  new StringBuilder(new String(ans));
         
        System.out.println("Case #"+T+": "+ sb);
        }
     }
}