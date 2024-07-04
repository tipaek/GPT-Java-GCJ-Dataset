import java.util.*;

class Test
{
    public static void main(String [] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        String [] sarray=new String[t];
        for(int k=0;k<t;k++)
        {
            sarray[k]=s.next();
        }
        for(int k=1;k<=t;k++)
        {
            String str=sarray[k-1];
            int count=0,temp=0;
            System.out.print("Case #"+String.valueOf(k)+": ");
            for(int i=0;i<str.length();i++)
            {

                temp=str.charAt(i)-'0';
                if(temp>count)
                {
                    while(count<temp)
                    {
                        System.out.print("(");
                        count=count+1;
                    }
                }
                else if(temp<count)
                {
                    while(count>temp)
                    {
                        System.out.print(")");
                        count=count-1;
                    }
                }

                System.out.print(str.charAt(i));
            }
            while(count>0)
            {
                System.out.print(")");
                count=count-1;
            }
            System.out.println();

        }

    }
}
