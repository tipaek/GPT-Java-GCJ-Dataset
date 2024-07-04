import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        int bits=input.nextInt();
        for(int t=1;t<=test;t++) {
            StringBuilder ans=new StringBuilder("");
            for(int i=1;i<=10;i++) {
                System.out.println(i);
                System.out.flush();
                int bit=input.nextInt();
                ans.append(bit);
            }
            System.out.println(ans);
            System.out.flush();
            char verdict=input.next().charAt(0);
            if(verdict=='N') {
                break;
            }
        }
    }
}