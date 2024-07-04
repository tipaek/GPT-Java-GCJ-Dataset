import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution {
  public static void solve(Scanner in, int[] bit, int b) {
      boolean same=false;
      boolean dif=false;
      int s1=-1,s2=-1;
      int d1=-1,d2=-1;
      if(b<10){
          for(int i=1;i<=b;i++){
              System.out.println(i);
             bit[i]=in.nextInt();
          }
          print(bit,in);
          return;
      }
      
      for(int i=1;i<=5;i++){
             System.out.println(i);
             bit[i]=in.nextInt();
             System.out.println(b-i+1);
             bit[b-i+1]=in.nextInt();
             if(bit[i]==bit[b-i+1]){
                 same=true;
                 s1=i;
                 s2=b-i+1;
             }else{
                 dif=true;
                 d1=i;
                 d2=b-i+1;
             }
      }
      int call=11;
      int a,bb,c;
      boolean done;
      boolean first,second,third;
     for(int i=6;i<=b;i++){
         
       if(call%10==1){
           //case of switch
           if(same){
               if(dif){
                   //both same and diff
                   System.out.println(d1);
                    a=in.nextInt();
                    System.out.println(d2);
                    bb=in.nextInt();
                    System.out.println(s1);
                    c=in.nextInt();
                    call+=3;
                    if(bit[d1]==a)
                       first=false;
                    else
                        first=true;
                    
                    if(bit[d2]==bb)
                       second=false;
                    else
                        second=true;
                        
                    if(bit[s1]==c)
                       third=false;
                    else
                        third=true;
                   
                    done=performOperation(first,second,third,bit,in);
                    if(done)
                    return;
               }else{
                   //only same
                   System.out.println(s1);
                    a=in.nextInt();
                    call++;
                    if(a==bit[s1]){
                        //do nothing
                    }
                    else{
                       done= flip(bit,in);
                    if(done)
                    return;
                    }
                   
               }
           }else{
               //only diff
                System.out.println(d1);
                    a=in.nextInt();
                    call++;
                    if(a==bit[d1]){
                        //do nothing
                    }
                    else{
                        done= flip(bit,in);
                        if(done)
                            return;
                    }
               
           }
       }
       else{
             System.out.println(i);
             bit[i]=in.nextInt();
             System.out.println(b-i+1);
             bit[b-i+1]=in.nextInt();
             call+=2;
             if(!same && bit[i]==bit[b-i+1]){
                 same=true;
                 s1=i;
                 s2=b-i+1;
             }
             if(!dif && bit[i]!=bit[b-i+1]){
                 dif=true;
                 d1=i;
                 d2=b-i+1;
             }
             
             if(i%10==0){
                 if(checkSolved(bit)){
                     print(bit,in);
                     return;
                 }
                 
             }
       }
      
         
     }
      
     
    
  }
  public static void reverse(int[] bit){
      int temp=0;
      int len=bit.length;
      for(int i=1;i<bit.length/2;i++){
          if(bit[i]==-1)
            continue;
            temp=bit[i];
            bit[i]=bit[len-i];
            bit[len-i]=temp;
        
      }
  }
  public static void negeate(int[] bit){
      for(int i=1;i<bit.length;i++){
          if(bit[i]==-1)
          continue;
            if(bit[i]==0)
                bit[i]=1;
            else
                bit[i]=0;
      }
  }
  
    public static boolean flip(int[] bit,Scanner in){
      for(int i=1;i<bit.length;i++){
          if(bit[i]==-1)
          continue;
            if(bit[i]==0)
                bit[i]=1;
            else
                bit[i]=0;
      }
      boolean solved=checkSolved(bit);
      if(solved){
          print(bit,in);
          return true;
      }
      return false;
  }
  
  public static boolean performOperation(boolean f,boolean s,boolean t, int[] bit,Scanner in ){
      
      if(f&&s&&!t){
          //reverse
          reverse(bit);
      }
      if(f&&s&&t){
          //negate
          negeate(bit);
      }
      if(!f&&!s&&t){
          //reverse and negate
          reverse(bit);
          negeate(bit);
      }
      if(!f&&!s&&!t){
          //do nothing
      }
      
      boolean solved=checkSolved(bit);
      if(solved){
          print(bit,in);
          return true;
      }
      return false;
  }
  
  public static boolean checkSolved(int[] bit){
      for(int i=1;i<bit.length;i++){
          if(bit[i]==-1)
          return false;
      }
      return true;
  }
  
    public static boolean print(int[] arr,Scanner in){
        StringBuffer ans=new StringBuffer();
        for(int i=1;i<arr.length;i++){
            ans.append(arr[i]);        
        }
        System.out.println(ans.toString());
        String c=in.next();
        if(c.equals('N'))
            System.exit(0);
        else
            return true;
            
        return false;
    }
    
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int b = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
        int[] bit=new int[b+1];
        for(int i=0;i<=b;i++){
            bit[i]=-1;
        }
    
      solve(input, bit, b);
    }
  }
}
