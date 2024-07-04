import java.util.*;
import java.io.*;
public class Solution4{
    public static void main(String[]args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            outer:
            for(int i = -5;i<=5;i++){
                for(int j = -5;j<=5;j++){
                    System.out.println(i+" "+j);
                    System.out.flush();
                    String s = sc.next();
                    if(s.equals("CENTER")){
                        break outer;
                    }
                }
            }
        }
    }
}