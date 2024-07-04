import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p=sc.nextInt();
        int S=0;
        for (int i=0;i<p;i++)
        {
            String ptr=sc.next();
            int M=0;
            String Sum="";
            for (char q:ptr.toCharArray())
            {
                int n=q-'0';
                while (n>M)
                {
                    M++;
                    Sum+='(';
                }
                while (n<M)
                {
                    M--;
                    Sum+=')';
                }
                Sum+=q;
            }
            while (M>0)
            {
                M--;
                Sum+=')';
            }
            S++;
            System.out.println("Case #" + S+": " +Sum );

        }
    }
}




























