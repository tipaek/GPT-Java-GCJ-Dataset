import java.io.*;
import java.lang.Math; 
class test
{
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String s1[]=s.split(" ");
        int t=Integer.parseInt(s1[0]);
        int b=Integer.parseInt(s1[1]);
        int i,j,p;
        String str[]=new String[b];
        for(i=0;i<t;i++)
        {
            for(j=0;j<150;j++)
            {
                int rand = (int)(Math.random()*b)+1;
                System.out.print(rand);
                p=Integer.parseInt(br.readLine());
                str[rand]=p+"";
            }
            StringBuilder stringBuilder = new StringBuilder();
             for ( j = 0; j < str.length;j++) {
                stringBuilder.append(str[j]);}
        
             System.out.print(stringBuilder.toString());
             char c=(char)(br.read());
             if(c=='N')
                break;
        }
    }
}