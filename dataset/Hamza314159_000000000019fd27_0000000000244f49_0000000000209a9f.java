import java.util.Scanner;
public class Solution
{
    void perform(String s)
    {
        char ch[]=s.toCharArray();String output="";
        for(int i=0;i<ch.length;i++)
        {
            int n=unpar(output);
            switch(ch[i])
            {
                case '0':
                for(int f=0;f<n;f++)
                    output+=")";
                output+='0';
                break;
                case '1':
                if(n>1)
                {
                    while(n!=1)
                    {
                        output+=")";
                        n--;
                    }
                    output+='1';
                }
                else
                {
                    while(n!=1)
                    {
                        output+="(";
                        n++;
                    }
                    output+='1';
                }
                break;
                case '2':
                if(n>2)
                {
                    while(n!=2)
                    {
                        output+=")";
                        n--;
                    }
                    output+='2';
                }
                else
                {
                    while(n!=2)
                    {
                        output+="(";
                        n++;
                    }
                    output+='2';
                }
                break;
                case '3':
                if(n>3)
                {
                    while(n!=3)
                    {
                        output+=")";
                        n--;
                    }
                    output+='3';
                }
                else
                {
                    while(n!=3)
                    {
                        output+="(";
                        n++;
                    }
                    output+='3';
                }
                break;
                case '4':
                if(n>4)
                {
                    while(n!=4)
                    {
                        output+=")";
                        n--;
                    }
                    output+='4';
                }
                else
                {
                    while(n!=4)
                    {
                        output+="(";
                        n++;
                    }
                    output+='4';
                }
                break;
                case '5':
                if(n>5)
                {
                    while(n!=5)
                    {
                        output+=")";
                        n--;
                    }
                    output+='5';
                }
                else
                {
                    while(n!=5)
                    {
                        output+="(";
                        n++;
                    }
                    output+='5';
                }
                break;
                case '6':
                if(n>6)
                {
                    while(n!=6)
                    {
                        output+=")";
                        n--;
                    }
                    output+='6';
                }
                else
                {
                    while(n!=6)
                    {
                        output+="(";
                        n++;
                    }
                    output+='6';
                }
                break;
                case '7':
                if(n>7)
                {
                    while(n!=7)
                    {
                        output+=")";
                        n--;
                    }
                    output+='7';
                }
                else
                {
                    while(n!=7)
                    {
                        output+="(";
                        n++;
                    }
                    output+='7';
                }
                break;
                case '8':
                if(n>8)
                {
                    while(n!=8)
                    {
                        output+=")";
                        n--;
                    }
                    output+='8';
                }
                else
                {
                    while(n!=8)
                    {
                        output+="(";
                        n++;
                    }
                    output+='8';
                }
                break;
                case '9':
                if(n>9)
                {
                    while(n!=9)
                    {
                        output+=")";
                        n--;
                    }
                    output+='9';
                }
                else
                {
                    while(n!=9)
                    {
                        output+="(";
                        n++;
                    }
                    output+='9';
                }
                break;
            }
        }
        int c=unpar(output);
        for(int i=0;i<c;i++)
            output+=")";
        System.out.println(output);
    }

    int unpar(String k)
    {
        int o=0,c=0;
        for(int i=0;i<k.length();i++)
        {
            if(k.charAt(i)=='(')
                o++;
            if(k.charAt(i)==')')
                c++;
        }
        return o-c;
    }

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        if(t>=1&&t<=100)
        {
            for(int i=0;i<t;i++){
                String s=sc.next();
                if(s.length()>=1&&s.length()<=100)
                {
                    System.out.print("Case #"+(i+1)+": ");
                    Solution ob=new Solution();
                    ob.perform(s);

                }
            }
        }
    }
}