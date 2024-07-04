import java.util.Scanner;

public class Nesting_Depth
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        Nesting_Depth n=new Nesting_Depth();
        int t=scan.nextInt();
        int tc=1;
        scan.nextLine();
        while(tc<=t)
        {
            String S=scan.nextLine();
            n.brackets(S,tc);
            tc++;
        }
    
    }
    public void brackets(String S,int tc)
    {
        char[] Sdash=S.toCharArray();
        char j='0';
        int k=0,l=0;
        System.out.print("case #"+tc+":");
        for(int i=0;i<Sdash.length;i++)
        {
            l=0;
            
            while(k<(Sdash[i]-j))
            {
                System.out.print("(");
                k++;
            }
        
            if(l<k-(Sdash[i]-j))
            {

            while(l<k-(Sdash[i]-j))
            {
                System.out.print(")");
                l++;
                
            }
            k=Sdash[i]-j;
            }

            System.out.print(Sdash[i]);

            if(Sdash[i]=='0')
            {
                k=0;
            }
            if(i==Sdash.length-1)
            {
                int last=0;
                while(last<(k))
                {
                    System.out.print(")");
                    last++;
                }
            }
        }
        System.out.print("\n");

    }
}