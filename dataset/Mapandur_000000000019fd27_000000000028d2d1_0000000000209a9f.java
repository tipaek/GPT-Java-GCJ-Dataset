import java.util.*;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int z = 1; z <= T; z++) {
        	String s = sc.next();
        	//String res = result(s);
        	
        	//System.out.print(res);
        	
        	int n = s.length();
            int brac=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = s.charAt(i)-48;
                if(val==brac)
                {
                    sb.append(s.charAt(i));
                }
                else if(val>brac)
                {
                    int diff = val-brac;
                    sb.append(generateOpenBraces(diff)).append(s.charAt(i));
                    brac = brac+diff;
                }
                else
                {
                    int diff = brac-val;
                    sb.append(generateCloseBraces(diff)).append(s.charAt(i));
                    brac=brac-diff;
                }
            }
            if(brac>0) 
            {
                sb.append(generateCloseBraces(brac));
            }
            System.out.println(sb.toString());

        }
        System.exit(0);
    }
  //      }
//	}
	

    public static String generateOpenBraces(int n)
    {
         return String.join("", Collections.nCopies(n, "("));
    }
    public static String generateCloseBraces(int n)
    {
         return String.join("", Collections.nCopies(n, ")"));
    }

}
