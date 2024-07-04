import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int T = 0;
        T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<T;i++)
        {
            String S = sc.nextLine();
            int l = S.length();
            StringBuilder sb = new StringBuilder();
            int openCount = 0;
//            if(l > 0)
//            {
//                if(S.charAt(0) != '0')
//                {
//                    sb.append("(");
//                    openCount++;
//                }
//                    
//            }
            for(int j = 0; j<l; j++)
            {
                int k = Character.getNumericValue(S.charAt(j));
                if( k < openCount)
                {
                    int m = (openCount - k);
                    for(int p = 0; p < m; p++)
                    {
                        sb.append(")");
                        openCount--;
                    }
                }
                else
                {
                    int m = (k - openCount);
                    for(int p = 0; p < m; p++)
                    {
                        sb.append("(");
                        openCount++;
                    }
                }
                sb.append(Character.toString(S.charAt(j)));               
                
            }
            
            for(int j = 0; j < openCount; j++)
            {
                sb.append(")");
            }
            System.out.println("Case #" + (i+1) + ": " + sb.toString());
        }
    }
    
}
