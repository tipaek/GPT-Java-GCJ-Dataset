import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author Rasha267
 */
public class Solution 
{
   
        public static int A, B, N1, N2;
        public static char c = 'C';
        public static char j = 'J';
        public static StringBuilder sb = new StringBuilder("");
	public static void main(String[] args) 
        {
            Scanner sc = new Scanner(System.in);
            int cases = sc.nextInt();
            int counter = 1;
            for (int a = 1; a <= cases; a++)
            {
            int T = sc.nextInt();
            int i;
            N1 = sc.nextInt();
            N2 = sc.nextInt();
            A = N1;
            B = N2;
            sb.append(c);
            for (i = 2; i <= T; i++) 
            {
		N1 = sc.nextInt();
                N2 = sc.nextInt();
                if (N1 < B)
                {
                    sb.append(j);                    
                }
                else  if (N1 > B)
                {
                    sb.append(c);
                }
                else
                    sb.append(j);
                A = N1;
                B = N2;
            }
            System.out.println("Case #" + counter + ": " + sb);
            
            counter++;
            }
            sc.close();
	}
}
