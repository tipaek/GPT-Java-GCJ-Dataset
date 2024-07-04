import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    public static void main(String[] args){
         Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        in.nextLine();
        for(int i=0;i<t;i++){
            int b=in.nextInt();
            in.nextLine();
            String res="";
            for(int j=0;j<b;j++){
                System.out.println(j);
                String str=in.next();
                in.nextLine();
                char ch=str.charAt(0);
                res+=ch;
            }
            System.out.println(res);
            continue;
        }
    }
}