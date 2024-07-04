import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        for(int i =1;i<=t;i++){
            String dig = br.readLine();
            int tot=0;
            //String ans="";
            System.out.print("Case #"+i+": ");
            for(int x=0;x<dig.length();x++){
                if(tot==dig.charAt(x)-'0')
                    System.out.print(tot);
                else if(tot<dig.charAt(x)-'0'){
                    while(tot<dig.charAt(x)-'0'){
                        System.out.print("(");
                        tot++;
                    }
                    System.out.print(tot);
                }
                else{
                    while(tot>dig.charAt(x)-'0'){
                        System.out.print(")");
                        tot--;
                    }
                    System.out.print(tot);
                }
            }
            for(int x=0;x<tot;x++)
                System.out.print(")");
            System.out.println();


        }
    }
}