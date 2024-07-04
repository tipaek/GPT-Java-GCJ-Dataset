import java.util.*;
class Solution
{

    public static void main(String[] args)
    {
        //System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();int a=sc.nextInt();int b=sc.nextInt();sc.nextLine();
        for(int i=1;i<=t;i++)
        {
          int flag=0;
          for(int j=-5;j<=5;j++)
          {
            for(int k=-5;k<=5;k++)
            {
            System.out.println(j+" "+k);
            String res=sc.nextLine();
            if(res.equals("CENTER")||res.equals("center"))
            {flag=1;break;}
            }
            if(flag==1)
            break;
            }             
            }            
        }
    }
