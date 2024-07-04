import java.io.*;
class display
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,k,i,num=0,to=0,open=0,tc=0,l=0;
        String s;
        char c=' ';
        String[] opbr={" ","(","((","(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
        String[] clbr={" ",")","))",")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};
        t=Integer.parseInt(br.readLine());
        for(k=0;k<t;k++)
        {
            s=br.readLine();
            l=s.length();
            for(i=0;i<l;i++)
            {
                c=s.charAt(i);
                num=c-'0';
                if(num>open)
                {
                    to=num-open;
                    open=num;
                    System.out.print(opbr[to]);
                    System.out.print(num);
                }
                else if(num<open)
                {
                    tc=open-num;
                    open=num;
                    System.out.print(clbr[tc]);
                    System.out.print(num);
                }
                else
                {
                    System.out.print(num);
                }
                if(i==l-1)
                {
                    System.out.print(clbr[open]);
                }
            }
            l=0;open=0;tc=0;to=0;
            System.out.println();
        }
    }
}