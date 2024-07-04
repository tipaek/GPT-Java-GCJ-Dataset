import java.util.scanner;
class pascalwalk
{
    public static void main(String args[])
    {
        int num;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter row value:");
        num=sc.nextline();
        for(int i=0;i<num;i++)
        {
            for (int j=num;j>i;j--)
            {
                System.out.print("");
            }
            int val=1;
            for(int j=0;j<=i;j++)
            {
                System.out.println(val+"");
                val=val*(i-j)/(j+1);
            }
            System.out.println();
        }
    }
}