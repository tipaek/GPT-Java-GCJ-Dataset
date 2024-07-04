

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tt = scan.nextInt();
        scan.nextLine();
        for (int t = 0; t <tt ; t++) {

            char[] nm = scan.nextLine().toCharArray();
            StringBuilder ans = new StringBuilder();
            int len = nm.length;
            for (int i = 0; i <len ; i++) {
                if(nm[i]=='0') {
                    while (i < len && nm[i] == '0') {
                        ans.append('0');
                        i++;
                    }
                    i--;
                }
                else if(nm[i]=='1')
                {
                    ans.append('(');
                    ans.append('1');
                    i++;
                    while(i<len && nm[i]=='1'){
                        ans.append('1');
                        i++;
                    }
                    i--;
                    ans.append(')');
                }
            }
            System.out.println("Case #"+(t+1)+": " +ans.toString());
        }
    }
}

