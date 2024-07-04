import java.util.*;
import java.io.*;
public class Solution{
    static class pair{
        int a,b;
        pair(int x,int y){
            a=x;b=y;
        }
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int p=1;
        while(p<=t){
            int u=s.nextInt();
            HashMap<Character,Boolean> h=new HashMap<>();
            HashSet<String> hs=new HashSet<>();
          for(int i=0;i<10000;i++){
              long a=s.nextLong();
              String b=s.next();
              hs.add(b);
              if(h.size()<10){
                  
              for(int i1=0;i1<b.length();i1++)
              h.put(b.charAt(i1),false);
                  
              }
          }
          for(String f:hs){
              h.put(f.charAt(0),true);
          }
          String ans="";String ans1="";
          for(Character c:h.keySet()){
              if(!h.get(c)){
                  ans+=c;
              }else{
                  ans1+=c;
              }
          }
         
            System.out.println("Case #"+p+": "+(ans+ans1));
            
            p++;
        }
    }
}