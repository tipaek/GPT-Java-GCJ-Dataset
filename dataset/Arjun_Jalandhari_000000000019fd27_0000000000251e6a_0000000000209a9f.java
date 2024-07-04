import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[] ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        for(int z=0;z<T;z++)
        {
            result.append("Case #");
            result.append(z+1);
            result.append(": ");

            String input = reader.readLine();
            StringBuilder []filled = new StringBuilder[input.length()];
            for(int i=0;i<input.length();i++)
            {
                StringBuilder strB = new StringBuilder();
                int n = Integer.parseInt(input.charAt(i)+"");
                for(int j=0;j<n;j++)
                    strB.append("(");
                strB.append(n);
                for(int j=0;j<n;j++)
                    strB.append(")");
                filled[i] = strB;
            }

            result.append(filled[0]);
            for(int i=1;i<input.length();i++)
            {
                int l = result.length()-1;
                int total = 0;
                while (l>0&&result.charAt(l-total)==')'&&filled[i].charAt(total)=='(')
                {
                    total++;
                    l--;
                }

                l = result.length()-1;

                for(int r=0;r<total;r++)
                {
                    result.deleteCharAt(l);
                    filled[i].deleteCharAt(0);
                    l--;
                }
                result.append(filled[i]);
            }
            result.append("\n");
        }
        System.out.print(result.toString().trim());
    }
}
