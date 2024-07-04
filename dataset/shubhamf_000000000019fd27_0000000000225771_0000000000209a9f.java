import java.util.Scanner;
public class HelloWorld{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t;
        boolean flag=false;
        String str;
        t = sc.nextInt();
        int it=1;
        while(it!=(t+1)){
            String ans="";
            flag  = false;
            str = sc.next();
             //System.out.print("String is " + str);
            for(int i=0;i<str.length();i++){
                            
               if(str.charAt(i) == '1'){
                   if(flag){
                       flag = true;
                       ans = ans + "1";
                   }else{
                       flag  = true;
                       ans = ans + "(1";
                   }
               }else{
                   if(flag){
                       flag = false;
                       ans = ans + ")0";
                   }else{
                       
                       ans = ans + "0";
                   }
               }
            }
            if(flag){
                ans = ans + ")";
            }
             System.out.print("Case #" + it + ": ");
             System.out.println(ans);
            it++;
        
        }
     }
}