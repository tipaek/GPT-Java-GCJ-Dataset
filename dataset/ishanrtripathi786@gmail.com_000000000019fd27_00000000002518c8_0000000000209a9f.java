import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int itr = 1;
        while (itr <= t) {
            String str= sc.nextLine();
            str="0"+str+"0";
            String res="";
            for(int i=1; i<str.length(); i++)
            {
                int a= Integer.parseInt(str.charAt(i-1)+"");
                int b= Integer.parseInt(str.charAt(i)+"");
                int diff= a-b;
                if(diff<0) {
                    while (diff < 0) {
                        res += "(";
                        diff++;
                    }
                    res += (str.charAt(i) + "");
                }
                else {
                    while (diff > 0) {
                        res += ")";
                        diff--;
                    }
                    res += (str.charAt(i) + "");
                }
            }
            System.out.println("Case #"+itr+": "+res.substring(0, res.length()-1));
            itr++;
        }
    }
}
