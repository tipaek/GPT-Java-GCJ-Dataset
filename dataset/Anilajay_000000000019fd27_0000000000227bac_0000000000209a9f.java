import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int i=1;
        while(t-->0) {
            System.out.print("Case #"+i+": ");
            String str = in.next();
            char[] str1 = str.toCharArray();
            int c = 1, j = 0;
            while (j < str.length()) {

                if (str1[j] == '0')
                    System.out.print('0');
                else if (j < str.length() - 1 && str1[j] == '1' && str1[j + 1] == '1')
                    c++;
                else if (j < str.length() - 1 && str1[j] == '1' && str1[j + 1] == '0' || (j+1)<=str.length()) {
                    System.out.print('(');
                    while (c > 0) {
                        System.out.print('1');
                        c--;
                    }
                    System.out.print(')');
                    c = 1;
                }
                j++;
            }
            System.out.println();
            i++;
        }
    }
}