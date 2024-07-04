import java.util.*;
import java.math.*;

 class Main
{
	public static void main(String[] args) {
	
    Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int a=0;a<t;a++)
        {   int flag=0,open=0;
        String ans="";
            String str=sc.next();
            char ch[]=str.toCharArray();
            String bo[]={"","(","((","(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
            String bc[]={"",")","))",")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};
            for(int j=0;j<ch.length;j++)
            {   int x=Integer.parseInt(ch[j]+"");
                if(open > x)
                {
                    ans=ans+bc[open-x]+ch[j];
                    open=x;
                }
                else if(x>open)
                {
                    ans=ans+bo[x-open]+ch[j];
                    open=x;
                }
                else
                {
                    ans=ans+ch[j];
                }
                /*if(flag==0)
                {
                    if(ch[j]=='1')
                    {
                        
                        ans=ans+'('+'1';
                        flag=1;
                    }
                    else
                    {
                        ans=ans+'0';
                    }
                }
                else
                {
                    if(ch[j]=='1')
                    {
                        
                        ans=ans+'1';
                    }
                    else
                    {
                        ans=ans+')'+'0';
                        flag=0;
                    }
                }
            }
            if(ch[ch.length-1]=='1')
            {
                ans=ans+')';
            }*/
            }
            ans=ans+bc[open];
            System.out.println("Case "+"#"+(a+1)+": "+ans);
        }

}
}

