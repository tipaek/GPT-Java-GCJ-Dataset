import java.io.*;
import java.lang.Math; 
class test
{
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int i,j,p;
        String str[]=new String[b];
        for(i=0;i<t;i++)
        {
            for(j=0;j<150;j++)
            {
                int rand = (int)(Math.random()*b)+1;
                System.out.println(rand);
                p=Integer.parseInt(br.readLine());
                str[rand]=p+"";
            }
            StringBuilder stringBuilder = new StringBuilder();
             for ( i = 0; i < str.length; i++) {
                stringBuilder.append(str[i]);}
        
             System.out.println(stringBuilder.toString());
             char c=(char)(br.read());
             if(c=='N')
                System.exit(0);
        }
    }
}