import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    public static void main(String[] args){
         Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        int b=in.nextInt();
        in.nextLine();
        for(int i=0;i<t;i++){
            String res="";
            for(int j=1;j<=b;j++){
                System.out.println(j);
                String str=in.next();
                in.nextLine();
                char ch=str.charAt(0);
                if(ch=='N')break;
                res+=ch;
            }
            System.out.println(res);
            String str=in.next();
            char ch=str.charAt(0);
            if(ch=='N')break;
            in.nextLine();
        }
    }
}