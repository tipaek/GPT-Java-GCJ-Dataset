import java.util.Scanner;

class Solution {
    
    private String open(int n){
        if(n > 0){
            System.out.print("(");
            open(n-1);
        }
    }
    private String close(int n){
        if(n > 0){
            return(")");
            close(n-1);
        }
    }
    public void main(String[] args) {
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
                out +="(((((((((";

            for (int i=1;i<str.length();i++)
            {
                for (int j=0;j<10;j++)
                {
                    if (ch[i]-ch[i-1]==j)
                        out+=close(j);
                    out+=ch[i];

                    if (ch[i]-ch[i+1]==j)
                        out+=open(j);
                }
            }

            if (ch[str.length()-1]=='1')
                out+=")";
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
