import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++)
        {
            int N = scanner.nextInt();
            String[] left = new String[N];
            String[] right = new String[N];

            for(int j=0;j<N;j++) {
                String str = scanner.next();
                int asterix = str.indexOf("*");
                if(asterix == str.length()-1)
                {
                    left[j] = str.substring(0,asterix);
                    right[j] = "";
                }
                else if(asterix == 0)
                {
                    left[j] = "";
                    right[j] = str.substring(1);
                }
                else {
                    left[j] = str.substring(0, asterix);
                    right[j] = str.substring(asterix + 1);
                }
            }

            int longestLengthLeft = left[0].length();
            String longestStringLeft = left[0];
            int longestLengthIndexLeft = 0;
            for(int j=1;j<N;j++)
            {
                if(left[j].equals(""))
                    continue;
                if(left[j].length() > longestLengthLeft)
                {
                    longestLengthLeft = left[j].length();
                    longestStringLeft = left[j];
                    longestLengthIndexLeft = j;
                }
            }
            boolean possible = true;
            for(int j=0;j<N;j++)
            {
                if(j==longestLengthIndexLeft)
                    continue;
                if(!(longestStringLeft.substring(0, left[j].length()).equals(left[j])))
                {
                    possible = false;
                    break;
                }
            }
            if(!possible)
            {
                System.out.println("Case #" + (i+1) + ": *");
                continue;
            }

            int longestLengthRight = right[0].length();
            String longestStringRight = right[0];
            int longestLengthIndexRight = 0;
            for(int j=1;j<N;j++)
            {
                if(right[j].equals(""))
                    continue;
                if(right[j].length() > longestLengthRight)
                {
                    longestLengthRight = right[j].length();
                    longestStringRight = right[j];
                    longestLengthIndexRight = j;
                }
            }
            for(int j=0;j<N;j++)
            {
                if(j==longestLengthIndexRight)
                    continue;
                if(!(longestStringRight.substring(longestStringRight.length()-right[j].length()).equals(right[j])))
                {
                    possible = false;
                    break;
                }
            }
            if(!possible)
            {
                System.out.println("Case #" + (i+1) + ": *");
                continue;
            }
            System.out.println("Case #" + (i+1) + ": " + longestStringLeft + longestStringRight);
        }

    }
}
