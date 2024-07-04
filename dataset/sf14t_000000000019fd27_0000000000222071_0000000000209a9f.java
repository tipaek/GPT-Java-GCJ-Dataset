import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            StringBuilder str=new StringBuilder(input.next());
            StringBuilder ans=new StringBuilder("");
            int curr_brac=0;
            for(int i=0;i<str.length();i++) {
                int chr=str.charAt(i)-48;
                if(curr_brac==chr) {
                    ans.append(str.charAt(i));
                }
                else if(curr_brac<chr) {
                    while(curr_brac!=chr) {
                        ans.append('(');
                        curr_brac++;
                    }
                    ans.append(str.charAt(i));
                }
                else if(curr_brac>chr) {
                    while(curr_brac!=chr) {
                        ans.append(')');
                        curr_brac--;
                    }
                    ans.append(str.charAt(i));
                }
            }
            while(curr_brac!=0) {
                ans.append(')');
                curr_brac--;
            }
            System.out.println("Case #"+t+": "+ans);
        }
    }
}
