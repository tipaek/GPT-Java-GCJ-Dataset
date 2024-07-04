import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=1;x<=t;x++)
        {
            int n=sc.nextInt();sc.nextLine();
            String max=sc.nextLine().substring(1);
            for(int y=1;y<n;y++)
            {
                String temp=sc.nextLine().substring(1);
                if(temp.lastIndexOf(max)==temp.length()-max.length()&&temp.lastIndexOf(max)!=-1)
                {max=temp;}
                else if(!(max.lastIndexOf(temp)==max.length()-temp.length()&&max.lastIndexOf(temp)!=-1))
                {max="*";break;}
            }
            System.out.println("Case #"+x+": "+max);
        }
    }
}