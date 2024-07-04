import java.util.*;
public class Solution{


    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int  t = in.nextInt();

        for (int i=1;i<=t;i++ ){
            String s = in.next();
            String ans="";
            int depth=0;
            for (char c : s.toCharArray()){
               int ch =  Character.getNumericValue(c);
               if(ch>depth){
                   for(int j=0;j<ch-depth;j++){
                       ans=ans+"(";
                   }
                   depth=ch;
               }
               if(ch<depth){
                   for(int j=0;j<depth-ch;j++){
                       ans=ans+")";
                   }
                   depth=ch;
               }
               ans=ans+c;
            }
            while(depth>0){
                ans=ans+")";
                depth--;
            }
            System.out.println("Case #"+ i +": "+ans );
        }
    }
}