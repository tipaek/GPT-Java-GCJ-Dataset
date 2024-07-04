import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
      static int up=(int)Math.pow(10,9)/2;
      static int down=(int)-Math.pow(10,9)/2;
      static int right=(int)Math.pow(10,9)/2;
      static int left=(int)-Math.pow(10,9)/2;
      static int a;
      static int count;
      static int b;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
         a=in.nextInt();
            b=in.nextInt();
        for(int j=0; j<t; j++){
            count=300;
            if(!solve(in)){
                break;
            }
        }
       // System.out.println(size);
    }
    
    public static boolean solve(Scanner in ) {
        
        String input;
        boolean solved=false;
       while(count>0) {
           //right up
           System.out.println((right-(right-left)/4)+" "+(up-(up-down)/4));
           input=in.next();
           count--;
           if(input.equals("CENTER")){
               solved=true;
               break;
           }else if(input.equals("HIT")){
               if(restrict((right-(right-left)/4),(up-(up-down)/4),in))
               return true;
               continue;
               
           }
           
           //left up
            System.out.println((left-(left-right)/4)+" "+(up-(up-down)/4));
           input=in.next();
           count--;
           if(input.equals("CENTER")){
               solved=true;
               break;
           }else if(input.equals("HIT")){
               if(restrict((left-(left-right)/4),(up-(up-down)/4),in))
               return true;
               continue;
               
           }
           
           //right down
            System.out.println((right-(right-left)/4)+" "+(down-(down-up)/4));
           input=in.next();
            count--;
           if(input.equals("CENTER")){
               solved=true;
               break;
           }else if(input.equals("HIT")){
               if(restrict((right-(right-left)/4),(down-(down-up)/4),in))
               return true;
               continue;
               
           }
           
           //left down
            System.out.println((left-(left-right)/4)+" "+(down-(down-up)/4));
           input=in.next();
            count--;
           if(input.equals("CENTER")){
               solved=true;
               break;
           }else if(input.equals("HIT")){
               if(restrict((left-(left-right)/4),(down-(down-up)/4),in))
               return true;
               continue;
               
           }
           
           
       }
        return solved;
    }
    
    public static boolean restrict(int x,int y,Scanner in){
        //check ceeling
        boolean upa=false,upb=false,downa=false,downb=false;
         System.out.println((x+a)+" "+y);
           String input=in.next();
            count--;
           if(input.equals("CENTER")){
              return true;
           }else if(input.equals("HIT")){
             upa=true;
           }
           else{
               right=x;
           }
        if(upa){
            System.out.println((x+b)+" "+y);
           input=in.next();
             count--;
           if(input.equals("CENTER")){
              return true;
           }else if(input.equals("HIT")){
             upb=true;
             left=x;
           }
           else{
                System.out.println((x-a)+" "+y);
           input=in.next();
           count--;
                if(input.equals("CENTER")){
              return true;
           }else if(input.equals("HIT")){
             downa=true;
            System.out.println((x-b)+" "+y);
           input=in.next();
           count--;
           if(input.equals("CENTER")){
              return true;
           }else if(input.equals("HIT")){
            right=x;
           }
           
           }else{
               left=x;
           }
               
           }
        }
        upa=false;downa=false;upb=false;downb=false;
        System.out.println(x+" "+(y+a));
           input=in.next();
            count--;
           if(input.equals("CENTER")){
              return true;
           }else if(input.equals("HIT")){
             upa=true;
           }
           else{
               up=y;
           }
        if(upa){
            System.out.println(x+" "+(y+b));
           input=in.next();
             count--;
           if(input.equals("CENTER")){
              return true;
           }else if(input.equals("HIT")){
             upb=true;
             down=y;
           }
           else{
                System.out.println(x+" "+(y-a));
           input=in.next();
           count--;
                if(input.equals("CENTER")){
              return true;
           }else if(input.equals("HIT")){
             downa=true;
            System.out.println(x+" "+(y-b));
           input=in.next();
           count--;
           if(input.equals("CENTER")){
              return true;
           }else if(input.equals("HIT")){
            up=y;
           }
           
           }else{
               down=y;
           }
               
           }
        }
        
        
        return false;
        
    }
}






