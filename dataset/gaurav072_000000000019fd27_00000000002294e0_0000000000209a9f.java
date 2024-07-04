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
            
            for (int i=0;i<str.length();i++) {
                for (int j=0;j<=9;j++) {
                    if (ch[i]==j)
                        for(int l=0;l<j;l++)
                            out +="(";
                }
            }

            for (int i=0;i<str.length();i++)
            {
                for (int j=0;j<10;j++)
                {
                    out+=ch[i];
                    if (ch[i]==j && ch[i+1]=='0')
                        for(int l=0;l<j;l++)
                            out +=")";
                    else if (ch[i]=='0' && ch[i+1]==j)
                        for(int l=0;l<j;l++)
                            out +="(";
                }
            }
            for (int i=0;i<str.length();i++) {
                for (int j=0;j<=9;j++) {
                    if (ch[str.length()-1]==j)
                        for(int l=0;l<j;l++)
                            out +=")";
                }
            }
            System.out.println("Case #"+(k+1)+": "+out);
        }
    }
}
