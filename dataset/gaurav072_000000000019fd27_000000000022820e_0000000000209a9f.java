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
            if (ch[0]=='1')
                out +="(";
            if (ch[0]=='2')
                out +="((";
            if (ch[0]=='3')
                out +="(((";
            if (ch[0]=='4')
                out +="((((";
            if (ch[0]=='5')
                out +="(((((";
            if (ch[0]=='6')
                out +="((((((";
            if (ch[0]=='7')
                out +="(((((((";
            if (ch[0]=='8')
                out +="((((((((";
            if (ch[0]=='9')
                out +="((((((((((";
            for (int i=0;i<str.length();i++)
            {
                out+=ch[i];
                if (ch[i]=='1' && ch[i+1]=='0')
                    out+=')';
                else if (ch[i]=='0' && ch[i+1]=='1')
                   out+='(';
                if (ch[i]=='2' && ch[i+1]=='0')
                    out+="))";
                else if (ch[i]=='0' && ch[i+1]=='2')
                    out+="((";
                if (ch[i]=='3' && ch[i+1]=='0')
                    out+=")))";
                else if (ch[i]=='0' && ch[i+1]=='3')
                    out+="(((";
                if (ch[i]=='4' && ch[i+1]=='0')
                    out+="))))";
                else if (ch[i]=='0' && ch[i+1]=='4')
                    out+="((((";
                if (ch[i]=='5' && ch[i+1]=='0')
                    out+=")))))";
                else if (ch[i]=='0' && ch[i+1]=='5')
                    out+="(((((";
                if (ch[i]=='6' && ch[i+1]=='0')
                    out+="))))))";
                else if (ch[i]=='0' && ch[i+1]=='6')
                    out+="((((((";
                if (ch[i]=='7' && ch[i+1]=='0')
                    out+=")))))))";
                else if (ch[i]=='0' && ch[i+1]=='7')
                    out+="(((((((";
                if (ch[i]=='8' && ch[i+1]=='0')
                    out+="))))))))";
                else if (ch[i]=='0' && ch[i+1]=='8')
                    out+="((((((((";
                if (ch[i]=='9' && ch[i+1]=='0')
                    out+=")))))))))";
                else if (ch[i]=='0' && ch[i+1]=='9')
                    out+="(((((((((";
            }
            if (ch[str.length()-1]=='1')
                out+=')';
            if (ch[str.length()-1]=='2')
                out+="))";
            if (ch[str.length()-1]=='3')
                out+=")))";
            if (ch[str.length()-1]=='4')
                out+="))))";
            if (ch[str.length()-1]=='5')
                out+=")))))";
            if (ch[str.length()-1]=='6')
                out+="))))))";
            if (ch[str.length()-1]=='7')
                out+=")))))))";
            if (ch[str.length()-1]=='8')
                out+="))))))))";
            if (ch[str.length()-1]=='9')
                out+=")))))))))";

            System.out.println("Case #"+(k+1)+": "+out);
        }
    }
}
