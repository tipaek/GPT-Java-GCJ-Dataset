import java.util.Scanner;

public class Solution {

    public static void NestedDepth(int no, String input)
    {
        String ans = "";

        ans = Wrap(input.charAt(0) + "",Integer.parseInt(input.charAt(0) + ""));

        for(int i=1; i<input.length(); i++)
        {
            String st = input.charAt(i) + "";
            int n = Integer.parseInt(st);

            if(st.equals("0"))
            {
                ans = ans + 0;
                continue;
            }

            int index = ans.length()-1;
            int count = 0;

            while(true)
            {
                String s = ans.charAt(index) + "";

                if(s.equals(")"))
                {
                    count++;
                    index--;
                }
                else
                {
                    String first = ans.substring(0,index+1);
                    String last = ans.substring(index+1);
                    ans = first + Wrap(st,n-count) + last;
                    break;
                }

                if(count == n) break;
            }

            if(count == n && n !=0)
            {
                String first = ans.substring(0,index+1);
                String last = ans.substring(index+1);
                ans = first + Wrap(st,n-count) + last;
            }

        }

        System.out.println("Case #" + no + ": " + ans);
    }

    public static String Wrap(String s, int t)
    {
        String ans = "" ;

        for(int i=0; i<t; i++)
        {
            ans = ans + "(";
        }

        ans = ans + s;

        for(int i=0; i<t; i++)
        {
            ans = ans + ")";
        }

        return ans;
    }

    public static void main(String[] args) {

        int cases;
        Scanner s = new Scanner(System.in);
        cases = s.nextInt();

        for(int i=1; i<=cases; i++)
        {
            String st = s.next();
            NestedDepth(i,st);
        }

    }
}
