import java.io.*;
class Main
{
    public static void main(String args[])throws IOException
    {
        String s,s1="";
        int T,l,i,k=1;
        char c;
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        T=Integer.parseInt(in.readLine());
        while(k<=T)
        {
            s=in.readLine();
            s1="";
            l=s.length();
            for(i=0;i<l;i++)
            {   
                c=s.charAt(i);
                if(c=='0')
                {
                s1=s1+c;
                }
                else if(c=='1')
                {
                    s1=s1+'('+c;
                    while(((i+1)<l)&&(s.charAt(i+1)=='1'))
                    {
                        i++;
                        s1=s1+'1';
                    }
                    s1=s1+')';
                }
            }
            System.out.println(s1);
            k++;
        }
       
    }
}