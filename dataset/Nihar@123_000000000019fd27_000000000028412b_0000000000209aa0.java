import java.util.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            //System.out.println("enter the value of n and k");
            int n=sc.nextInt();
            int k=sc.nextInt();
            if(n==2)
            {
                if(k==2)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 2");
                    System.out.println("2 1");
                }
                else if(k==3)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==4)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("2 1");
                    System.out.println("1 2");
                }
            }
             else if(n==3)
            {
                if(k==3)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 2 3");
                    System.out.println("3 1 2");
                    System.out.println("2 3 1");
                }
                else if(k==4)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==5)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==6)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("3 2 1");
                    System.out.println("2 1 3");
                    System.out.println("1 3 2");
                }
                else if(k==7)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==8)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==9)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("3 2 1");
                    System.out.println("1 3 2");
                    System.out.println("2 1 3");
                }
            }
            else  if(n==4)
            {
                if(k==4)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 2 3 4");
                    System.out.println("2 1 4 3");
                    System.out.println("4 3 1 2");
                    System.out.println("3 4 2 1");
                }
                else if(k==5)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==6)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 2 3 4");
                    System.out.println("2 1 4 3");
                    System.out.println("3 4 2 1");
                    System.out.println("4 3 1 2");
                }
                else if(k==7)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 2 3 4");
                    System.out.println("3 1 4 2");
                    System.out.println("4 3 2 1");
                    System.out.println("2 4 1 3");
                }
                else if(k==8)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 4 3 2");
                    System.out.println("2 1 4 3");
                    System.out.println("4 3 2 1");
                    System.out.println("3 2 1 4");
                }
                else if(k==9)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("2 4 3 1");
                    System.out.println("1 2 4 3");
                    System.out.println("4 3 1 2");
                    System.out.println("3 1 2 4");
                }
                else if(k==10)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                   System.out.println("1 3 4 2");
                   System.out.println("4 2 1 3");
                   System.out.println("2 4 3 1");
                   System.out.println("3 1 2 4");
                }
                else if(k==11)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 2 4 3");
                    System.out.println("3 4 1 2");
                    System.out.println("4 3 2 1");
                    System.out.println("2 1 3 4");
                }
                else if(k==12)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("4 2 3 1");
                    System.out.println("2 4 1 3");
                    System.out.println("3 1 2 4");
                    System.out.println("1 3 4 2");
                }
                else if(k==13)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("4 3 2 1");
                    System.out.println("2 4 1 3");
                    System.out.println("1 2 3 4");
                    System.out.println("3 1 4 2");
                }
                else if(k==14)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("3 4 1 2");
                    System.out.println("4 3 2 1");
                    System.out.println("2 1 4 3");
                    System.out.println("1 2 3 4");
                }
                else if(k==15)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==16)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("4 3 2 1");
                    System.out.println("3 4 1 2");
                    System.out.println("2 1 4 3");
                    System.out.println("1 2 3 4");
                }
            }
            else if(n==5)
            {
                if(k==5)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 1 5 3 4");
                    System.out.println("3 4 1 5 2");
                    System.out.println("4 5 2 1 3");
                    System.out.println("5 3 4 2 1");
                }
                else if(k==6)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==7)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 5 2 3 4");
                    System.out.println("2 1 4 5 3");
                    System.out.println("3 2 1 4 5");
                    System.out.println("4 3 5 2 1");
                    System.out.println("5 4 3 1 2");
                }
                else if(k==8)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 2 5 4 3");
                    System.out.println("3 1 2 5 4");
                    System.out.println("4 3 1 2 5");
                    System.out.println("2 5 4 3 1");
                    System.out.println("5 4 3 1 2");
                }
                else if(k==9)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("3 4 2 1 5");
                    System.out.println("2 1 5 3 4");
                    System.out.println("4 2 1 5 3");
                    System.out.println("5 3 4 2 1");
                    System.out.println("1 5 3 4 2");
                }
                else if(k==10)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 5 3 4 2");
                    System.out.println("2 1 5 3 4");
                    System.out.println("5 3 4 2 1");
                    System.out.println("3 4 2 1 5");
                    System.out.println("4 2 1 5 3");
                }
                else if(k==11)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("2 3 4 1 5");
                    System.out.println("4 1 5 2 3");
                    System.out.println("1 5 2 3 4");
                    System.out.println("5 2 3 4 1");
                    System.out.println("3 4 1 5 2");
                }
                else if(k==12)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 4 2 3 5");
                    System.out.println("5 1 4 2 3");
                    System.out.println("2 3 5 1 4");
                    System.out.println("3 5 1 4 2");
                    System.out.println("4 2 3 5 1");
                }
                else if(k==13)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 5 3 2 4");
                    System.out.println("5 3 2 4 1");
                    System.out.println("2 4 1 5 3");
                    System.out.println("4 1 5 3 2");
                    System.out.println("3 2 4 1 5");
                }
                else if(k==14)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("2 4 3 5 1");
                    System.out.println("1 2 4 3 5");
                    System.out.println("4 3 5 1 2");
                    System.out.println("3 5 1 2 4");
                    System.out.println("5 1 2 4 3");
                }
                else if(k==15)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 3 5 2 4");
                    System.out.println("5 2 4 1 3");
                    System.out.println("3 5 2 4 1");
                    System.out.println("4 1 3 5 2");
                    System.out.println("2 4 1 3 5");
                }
                else if(k==16)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("5 2 3 1 4");
                    System.out.println("1 4 5 2 3");
                    System.out.println("2 3 1 4 5");
                    System.out.println("3 1 4 5 2");
                    System.out.println("4 5 2 3 1");
                }
                else if(k==17)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 5 2 4 3");
                    System.out.println("4 3 1 5 2");
                    System.out.println("3 1 5 2 4");
                    System.out.println("5 2 4 3 1");
                    System.out.println("2 4 3 1 5");
                }
                else if(k==18)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("2 4 5 1 3");
                    System.out.println("4 5 1 3 2");
                    System.out.println("1 3 2 4 5");
                    System.out.println("3 2 4 5 1");
                    System.out.println("5 1 3 2 4");
                }
                else if(k==19)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("1 4 3 2 5");
                    System.out.println("2 5 1 4 3");
                    System.out.println("5 1 4 3 2");
                    System.out.println("4 3 2 5 1");
                    System.out.println("3 2 5 1 4");
                }
                else if(k==20)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("5 2 4 1 3");
                    System.out.println("3 5 2 4 1");
                    System.out.println("4 1 3 5 2");
                    System.out.println("1 3 5 2 4");
                    System.out.println("2 4 1 3 5");
                }
                else if(k==21)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("5 3 4 2 1");
                    System.out.println("1 5 3 4 2");
                    System.out.println("3 4 2 1 5");
                    System.out.println("4 2 1 5 3");
                    System.out.println("2 1 5 3 4");
                }
                else if(k==22)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("5 3 1 2 4");
                    System.out.println("4 5 3 1 2");
                    System.out.println("1 2 4 5 3");
                    System.out.println("2 4 5 3 1");
                    System.out.println("3 1 2 4 5");
                }
                else if(k==23)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("5 1 4 3 2");
                    System.out.println("4 5 2 1 3");
                    System.out.println("3 4 5 2 1");
                    System.out.println("2 3 1 4 5");
                    System.out.println("1 2 3 5 4");
                }
                else if(k==24)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                }
                else if(k==25)
                {
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                    System.out.println("5 2 4 1 3");
                    System.out.println("3 5 2 4 1");
                    System.out.println("1 3 5 2 4");
                    System.out.println("4 1 3 5 2");
                    System.out.println("2 4 1 3 5");
                }
            }
        }
    }
}