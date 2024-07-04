import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++)
        {
            int no=sc.nextInt();
            int val=sc.nextInt();
            if(no==2)
            {
                if(val==2)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 2");
                    System.out.println("2 1");
                }
                else if(val==3)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==4)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("2 1");
                    System.out.println("1 2");
                }
            }
            else if(no==3)
            {
                if(val==3)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 2 3");
                    System.out.println("3 1 2");
                    System.out.println("2 3 1");
                }
                else if(val==4)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==5)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==6)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("3 2 1");
                    System.out.println("2 1 3");
                    System.out.println("1 3 2");
                }
                else if(val==7)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==8)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==9)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("3 2 1");
                    System.out.println("1 3 2");
                    System.out.println("2 1 3");
                }
            }
            else  if(no==4)
            {
                if(val==4)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 2 3 4");
                    System.out.println("2 1 4 3");
                    System.out.println("4 3 1 2");
                    System.out.println("3 4 2 1");
                }
                else if(val==5)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==6)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 2 3 4");
                    System.out.println("2 1 4 3");
                    System.out.println("3 4 2 1");
                    System.out.println("4 3 1 2");
                }
                else if(val==7)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 2 3 4");
                    System.out.println("3 1 4 2");
                    System.out.println("4 3 2 1");
                    System.out.println("2 4 1 3");
                }
                else if(val==8)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 4 3 2");
                    System.out.println("2 1 4 3");
                    System.out.println("4 3 2 1");
                    System.out.println("3 2 1 4");
                }
                else if(val==9)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("2 4 3 1");
                    System.out.println("1 2 4 3");
                    System.out.println("4 3 1 2");
                    System.out.println("3 1 2 4");
                }
                else if(val==10)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 3 4 2");
                    System.out.println("4 2 1 3");
                    System.out.println("2 4 3 1");
                    System.out.println("3 1 2 4");
                }
                else if(val==11)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 2 4 3");
                    System.out.println("3 4 1 2");
                    System.out.println("4 3 2 1");
                    System.out.println("2 1 3 4");
                }
                else if(val==12)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("4 2 3 1");
                    System.out.println("2 4 1 3");
                    System.out.println("3 1 2 4");
                    System.out.println("1 3 4 2");
                }
                else if(val==13)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("4 3 2 1");
                    System.out.println("2 4 1 3");
                    System.out.println("1 2 3 4");
                    System.out.println("3 1 4 2");
                }
                else if(val==14)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("3 4 1 2");
                    System.out.println("4 3 2 1");
                    System.out.println("2 1 4 3");
                    System.out.println("1 2 3 4");
                }
                else if(val==15)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==16)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("4 3 2 1");
                    System.out.println("3 4 1 2");
                    System.out.println("2 1 4 3");
                    System.out.println("1 2 3 4");
                }
            }
            else if(no==5)
            {
                if(val==5)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 1 5 3 4");
                    System.out.println("3 4 1 5 2");
                    System.out.println("4 5 2 1 3");
                    System.out.println("5 3 4 2 1");
                }
                else if(val==6)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==7)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 5 2 3 4");
                    System.out.println("2 1 4 5 3");
                    System.out.println("3 2 1 4 5");
                    System.out.println("4 3 5 2 1");
                    System.out.println("5 4 3 1 2");
                }
                else if(val==8)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 2 5 4 3");
                    System.out.println("3 1 2 5 4");
                    System.out.println("4 3 1 2 5");
                    System.out.println("2 5 4 3 1");
                    System.out.println("5 4 3 1 2");
                }
                else if(val==9)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("3 4 2 1 5");
                    System.out.println("2 1 5 3 4");
                    System.out.println("4 2 1 5 3");
                    System.out.println("5 3 4 2 1");
                    System.out.println("1 5 3 4 2");
                }
                else if(val==10)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 5 3 4 2");
                    System.out.println("2 1 5 3 4");
                    System.out.println("5 3 4 2 1");
                    System.out.println("3 4 2 1 5");
                    System.out.println("4 2 1 5 3");
                }
                else if(val==11)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("2 3 4 1 5");
                    System.out.println("4 1 5 2 3");
                    System.out.println("1 5 2 3 4");
                    System.out.println("5 2 3 4 1");
                    System.out.println("3 4 1 5 2");
                }
                else if(val==12)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 4 2 3 5");
                    System.out.println("5 1 4 2 3");
                    System.out.println("2 3 5 1 4");
                    System.out.println("3 5 1 4 2");
                    System.out.println("4 2 3 5 1");
                }
                else if(val==13)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 5 3 2 4");
                    System.out.println("5 3 2 4 1");
                    System.out.println("2 4 1 5 3");
                    System.out.println("4 1 5 3 2");
                    System.out.println("3 2 4 1 5");
                }
                else if(val==14)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("2 4 3 5 1");
                    System.out.println("1 2 4 3 5");
                    System.out.println("4 3 5 1 2");
                    System.out.println("3 5 1 2 4");
                    System.out.println("5 1 2 4 3");
                }
                else if(val==15)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 3 5 2 4");
                    System.out.println("5 2 4 1 3");
                    System.out.println("3 5 2 4 1");
                    System.out.println("4 1 3 5 2");
                    System.out.println("2 4 1 3 5");
                }
                else if(val==16)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("5 2 3 1 4");
                    System.out.println("1 4 5 2 3");
                    System.out.println("2 3 1 4 5");
                    System.out.println("3 1 4 5 2");
                    System.out.println("4 5 2 3 1");
                }
                else if(val==17)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 5 2 4 3");
                    System.out.println("4 3 1 5 2");
                    System.out.println("3 1 5 2 4");
                    System.out.println("5 2 4 3 1");
                    System.out.println("2 4 3 1 5");
                }
                else if(val==18)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("2 4 5 1 3");
                    System.out.println("4 5 1 3 2");
                    System.out.println("1 3 2 4 5");
                    System.out.println("3 2 4 5 1");
                    System.out.println("5 1 3 2 4");
                }
                else if(val==19)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("1 4 3 2 5");
                    System.out.println("2 5 1 4 3");
                    System.out.println("5 1 4 3 2");
                    System.out.println("4 3 2 5 1");
                    System.out.println("3 2 5 1 4");
                }
                else if(val==20)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("5 2 4 1 3");
                    System.out.println("3 5 2 4 1");
                    System.out.println("4 1 3 5 2");
                    System.out.println("1 3 5 2 4");
                    System.out.println("2 4 1 3 5");
                }
                else if(val==21)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("5 3 4 2 1");
                    System.out.println("1 5 3 4 2");
                    System.out.println("3 4 2 1 5");
                    System.out.println("4 2 1 5 3");
                    System.out.println("2 1 5 3 4");
                }
                else if(val==22)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("5 3 1 2 4");
                    System.out.println("4 5 3 1 2");
                    System.out.println("1 2 4 5 3");
                    System.out.println("2 4 5 3 1");
                    System.out.println("3 1 2 4 5");
                }
                else if(val==23)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
                    System.out.println("5 1 4 3 2");
                    System.out.println("4 5 2 1 3");
                    System.out.println("3 4 5 2 1");
                    System.out.println("2 3 1 4 5");
                    System.out.println("1 2 3 5 4");
                }
                else if(val==24)
                {
                    System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
                }
                else if(val==25)
                {
                    System.out.println("Case #"+(j+1)+": POSSIBLE");
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