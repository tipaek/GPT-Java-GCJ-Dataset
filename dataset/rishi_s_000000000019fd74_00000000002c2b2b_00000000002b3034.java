import java.util.*;
import java.io.*;

public class Solution { 
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int max=0;
            int maxlen=0;
            String[] ss = new String[n];
            ss[0] = in.nextLine();
           
                for(int j=0;j<n;j++)
                {
                     ss[j]=in.nextLine();
                   if(max<ss[j].length())
                   {
                    max=ss[j].length();
                    maxlen=j;
                }
            }
           
        boolean flag=true;
        String bigboi = ss[maxlen].substring(1);
            for(int k=0;k<n;k++)
            {
                String smallboi = ss[k].substring(1);
                if(maxlen!=k)
                {
                    if(!bigboi.contains(smallboi))
                    {
                        flag=false;
                        break;
                    }
                }

            }
            if(flag==true)
            {
                System.out.print("Case #" + (i) + ":"+ " ");
                System.out.println(bigboi);
            }
            else {
                System.out.print("Case #" + (i) + ":" +" ");
                System.out.println("*");
             }
        
        }
    }

}