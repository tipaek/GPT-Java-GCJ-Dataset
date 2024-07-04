import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long a = sc.nextLong();
        long b = sc.nextLong();
        while(t-->0){
            outer:
            for(int i = -5;i<=5;i++){
                for(int j = -5;j<=5;j++){
                    System.out.println(i+" "+j);
                    System.out.flush();
                    String s = sc.nextLine();
                    if(s.equals("CENTER")){
                        break outer;
                    }
                }
            }
        }
    }
}