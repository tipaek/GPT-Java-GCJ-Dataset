import java.util.*;

 class Test
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        String[] snew =new String[t];
        String[] sstore=new String[t];
        int i=0;
        for(int x=0;x<t;x++)
        {
            sstore[x]=s.next();
        }
        while(i<t)
        {    String str=sstore[i];
             String s_="";
            for(int j=0;j<str.length();j++)
            {
                if(str.charAt(j)=='1')
                {
                    if(j!=0 && str.charAt(j-1)=='1')
                    {
                        s_=s_+str.charAt(j);
                    }
                    else
                    {
                        s_=s_+"("+str.charAt(j);
                    }
                }
                else
                {
                    if(s_.length()>0 && str.charAt(j-1)!='0')
                    {
                        s_=s_+")"+str.charAt(j);
                    }
                    else
                    {
                        s_=s_+str.charAt(j);
                    }
                }

            }
        if(s_.charAt(s_.length()-1)=='1')
        {
            s_=s_+")";
        }
          snew[i]="Case #"+String.valueOf(i+1)+": "+s_;
         i=i+1;
        }
        for(String element:snew)
        {
            System.out.println(element);
        }
    }


}
