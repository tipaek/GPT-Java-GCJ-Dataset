import java.util.*;
class Main
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int l=1;l<=t;l++)
        {
            String str=sc.nextLine();int diff;
            //String str2="";
            
            int i=0;
            while(true)
            {
                if(i==0)
                {
                    diff=Integer.parseInt(""+str.charAt(0));
                }
                else
                {
                    diff=Integer.parseInt(""+str.charAt(i))-Integer.parseInt(""+str.charAt(i-1));
                }
                if(diff>0)
                {
                    String s2="";
                    for(int j=1;j<=diff;j++)
                    {
                        s2+="(";
                    }
                    str=str.substring(0,i)+s2+str.substring(i);
                    i+=diff+1;
                }
                else if(diff<0)
                {
                    diff=-diff;
                    String s2="";
                    for(int j=1;j<=diff;j++)
                    {
                        s2+=")";
                    }
                    str=str.substring(0,i)+s2+str.substring(i);
                    i+=diff+1;
                }
                else
                {
                    i+=1;
                }
                if(i==str.length())
                {
                    diff=Integer.parseInt(""+str.charAt(i-1));
                    String s2="";
                    for(int j=1;j<=diff;j++)
                    {
                        s2+=")";
                    }
                    str=str+s2;
                    break;
                }
            }
            System.out.println("Case #"+l+": "+str);
        }
    }
}