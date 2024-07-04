import java.util.*;
public class Solution{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();
        for(int i=1;i<=x;i++){
            String[] y = sc.nextLine().split("\\s+");
            System.out.println("Case #"+i+": "+compute(Integer.parseInt(y[0]), Integer.parseInt(y[1]), y[2]));
        }
     }
     public static String compute(int a, int b, String c){
        int min=0;
        int len=c.length();
        boolean flag=true;
        while(true){
            if(mod(a)+mod(b)>min && len>0){
            if(c.substring(min, min+1).equalsIgnoreCase("N")){
                b++;   
            }
            else if(c.substring(min, min+1).equalsIgnoreCase("S")){
                b--;   
            }
            else if(c.substring(min, min+1).equalsIgnoreCase("E")){
                a++;   
            }
            else if(c.substring(min, min+1).equalsIgnoreCase("W")){
                a--;   
            }
            min++;len--;
            //System.out.println(min+" "+(mod(a)+mod(b))+" "+len);
            }
            else{
                if(mod(a)+mod(b)>min){flag=false;}
                break;
            }
        }
        if(flag){
            return String.valueOf(min);
        }
        return "IMPOSSIBLE";
     }
     public static int mod(int x){
         if (x<0){
             return -x;
         }
         return x;
     }
}