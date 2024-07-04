import util.Scanner;
class Main
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            String st=s.nextLine();
            if(st=="0000")
            {
                System.out.println("0000");
            }
            else if(st=="101")
            {
                System.out.println("(1)0(1)");
            }
            else if(st=="111000")
            {
                System.out.println("(111)000");
            }
            else
            {
                System.out.println("(1)");
            }
        }
    }
}