import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int t = read.nextInt();
        for (int k=0;k<t;k++)
        {
            String str = read.next();
            char[] ch = new char[str.length()+1];

            for (int i=0;i<str.length();i++)
                ch[i] = str.charAt(i);
            String out = "";

            int a = ch[0]-48;
            int b = ch[str.length()-1]-48;

            for (int i=0;i<a;i++)
                out+="(";
            out+=ch[0];
            int d1=0,d2=0;
            for (int i=1;i<str.length();i++)
            {
                if (ch[i]>ch[i-1])
                {
                    d1=ch[i]-ch[i-1];
                    for (int j=0;j<d1;j++)
                        out+="(";
                }
                else if (ch[i]<ch[i-1])
                {
                    d2 = ch[i-1]-ch[i];
                    for (int j=0;j<d2;j++)
                        out+=")";
                }
                out+=ch[i];
            }
            for (int i=0;i<b;i++)
                out+=")";

            System.out.println("Case #"+(k+1)+": "+out);
        }
    }
}
