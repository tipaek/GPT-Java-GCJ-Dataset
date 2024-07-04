import java.io.*;
public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t ; i++)
        {
            String s = br.readLine(), s1 = "";
            int b = 0;
            for(int j = 0 ; j < s.length() ; j++)
            {
                char c = s.charAt(j);
                if(b == 0)
                {
                    b = (int)(c) - 48;
                    for(int k = 0 ; k < b ; k++)
                        s1 = s1 + "(";
                    s1 = s1 + c;
                }
                else
                {
                    int z = (int)(c) - 48;
                    if(z > b)
                    {
                        for(int k = b ; k < z ; k++)
                            s1 = s1 + "(";
                        s1 = s1 + c;
                        b = z;
                    }
                    else if(z < b)
                    {
                        for(int k = b ; k > z ; k--)
                            s1 = s1 + ")";
                        s1 = s1 + c;
                        b = z;
                    }
                    else
                        s1 = s1 + c;
                }
            }
            if(b != 0)
            {
                for(int k = b ; k > 0 ; k--)
                    s1 = s1 + ")";
            }
            System.out.println("Case #" + (i + 1) + ": " + s1);
        }
    }
}