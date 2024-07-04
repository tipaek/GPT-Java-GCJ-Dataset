import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []s = br.readLine().split(" ");
        int t = Integer.parseInt(s[0]);
        while(t-->0){
            outer:
            for(int i = -5;i<=5;i++){
                for(int j = -5;j<=5;j++){
                    System.out.println(i+" "+j);
                    System.out.flush();
                    String ss = br.readLinr();
                    if(ss.length()==6){
                        break outer;
                    }
                }
            }
        }
    }
}