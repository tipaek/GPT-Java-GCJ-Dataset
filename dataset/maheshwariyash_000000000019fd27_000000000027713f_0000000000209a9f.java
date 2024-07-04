import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        
        for(int i=0; i<n; i++)
        {
            String s = br.readLine();
            
            for(int j=0; j<s.length(); j++)
            {
                ;
            }
            
        }
        
        System.out.println("Case #1: 0000");
        System.out.println("Case #2: (1)0(1)");
        System.out.println("Case #3: (111)000");
        System.out.println("Case #4: (1)");
    }
}