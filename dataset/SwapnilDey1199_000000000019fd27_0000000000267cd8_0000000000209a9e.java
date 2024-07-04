import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        while(t-->0){
            StringBuffer sb = new StringBuffer();
            if(b==10){
                for(int i = 1;i<=b;i++){
                    System.out.println(i);
                    System.out.flush();
                    String s = sc.next();
                    //sc.nextLine();
                    sb.insert(i-1,s);
                }
                System.out.println(sb);
                System.out.flush();
                char ch = sc.next().charAt(0);
                if(ch=='N') System.exit(0);
            }
            
        }
    }
}