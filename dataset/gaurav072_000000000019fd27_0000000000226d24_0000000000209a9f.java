import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int t = read.nextInt();
        for (int k=0;k<t;k++)
        {
            String str = read.next();
            char[] ch = str.toCharArray();
            String out = "";
            if (ch[0]=='1')
                out +="(";
            for (int i=0;i<str.length();i++)
            {
                out+=ch[i];
                if (ch[i]=='1' && ch[i+1]=='0')
                    out+=')';
                else if (ch[i]=='0' && ch[i+1]=='1')
                    out+='(';
            }
            if (ch[str.length()-1]=='1')
                out+=')';
            
            System.out.println("Case #"+(k+1)+": "+out);
        }
    }
}
