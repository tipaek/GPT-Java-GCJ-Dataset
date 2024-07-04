import java.util.*;
public class Solution{
     public static void main(String []args){
         Scanner s = new Scanner(System.in);
       int T=s.nextInt();
       for(int t=1;t<=T;t++){
           int h= s.nextInt();
           int v= s.nextInt();
           int sum=Math.abs(h)+Math.abs(v);
           int rh= getrev(Math.abs(h));
           int rv= getrev(Math.abs(v));
           int  k = (int)(Math.log(sum+1) / Math.log(2));
           if(Math.pow(2,k)==sum+1)
           System.out.println("Case #"+t+": "+getStr(h,v,0,0,k));
           else{
            sum=Math.abs(h)+2*rh+2*rv+Math.abs(v);
             k = (int)(Math.log(sum+1) / Math.log(2));
           if(Math.pow(2,k)==sum+1)
           System.out.println("Case #"+t+": "+getStr(h,v,rh,rv,k));
          else
          System.out.println("Case #"+t+": IMPOSSIBLE");}
          
           

}
}
static int getrev(int n){
         int r=0;
         int  k = (int)(Math.log(n) / Math.log(2)); 
          for (int i = 0; i < k; i++) 
    { 
        if((n & (1 << i))==0) 
           r |= 1 << ( i);   
   }
   return r;
}
static String getStr(int h,int v, int rh, int rv,int k){
    
    
    char ans[]= new char[k];
    
    if(h>0){
        for (int i = 0; i <k; i++) 
    { 
        if(((h+rv) & (1 << i))!=0) ans[i]='E';
        if((rv & (1 << i))!=0) ans[i]='W';
    }
    
    
    }
    else{
        for (int i = 0; i < k; i++) 
    { 
        if(((-h+rv) & (1 << i))!=0) ans[i]='W';
        if((rv & (1 << i))!=0) ans[i]='E';
    }
    }
    if(v>0){
        for (int i = 0; i < k; i++) 
    { 
        if(((v+rh) & (1 << i))!=0) ans[i]='N';
        if((rh & (1 << i))!=0) ans[i]='S';
    }
    
    
    }
    else{
        for (int i = 0; i < k; i++) 
    { 
        if(((-v+rh) & (1 << i))!=0) ans[i]='S';
        if((rh & (1 << i))!=0) ans[i]='N';
    }
    }
    return new String(ans);
}
}
