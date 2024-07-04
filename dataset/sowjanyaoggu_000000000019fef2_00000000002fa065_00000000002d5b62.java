import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int a=s.nextInt();
            int b=s.nextInt();
            //if(a>0 && b>0 ||a<0 && b<0)
            //{
                if(a>0 && b==0)
                    System.out.print("Case #"+(i+1)+": EE");
                else if(a<0 && b<0)
                    System.out.print("Case #"+i+": NWS");
                else if((a<0 && b>0) ||(a>0 && b<0))
                    System.out.print("Case #"+(i+1)+": IMPOSSIBLE");
                else if(a==0 && b>0)
                    System.out.print("Case #"+(i+1)+": WW");
            //}
        }
    }
}