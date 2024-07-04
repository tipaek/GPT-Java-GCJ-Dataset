import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = Integer.parseInt(scanner.nextLine());
        
        for(int i = 1; i <= totalTestCases; i++)
        {
            String curInput = scanner.nextLine();
            String solution = new ResultComputer(curInput).compute();
            System.out.println(String.format("Case #%d: %s", i, solution));
        }
    }
    
    private static class ResultComputer
    {
        private String input;
        
        ResultComputer(String input)
        {
            this.input = input;
        }
        
        String compute()
        {
            StringBuilder stringBuilder = new StringBuilder();
            boolean parsedOneBefore = false;
            for(char c : input.toCharArray())
            {
                if(c == '0')
                {
                    if(parsedOneBefore)
                    {
                        stringBuilder.append(")");
                    }
                    stringBuilder.append("0");
                    parsedOneBefore = false;
                }
                else if(c == '1')
                {
                    if(parsedOneBefore)
                    {
                        stringBuilder.append("1");
                    }
                    else
                    {
                        stringBuilder.append("(");
                        stringBuilder.append("1");
                        parsedOneBefore = true;
                    }
                }
            }
            
            //reached end of input and had seen 1 before
            if(parsedOneBefore)
            {
                stringBuilder.append(")");
            }
            
            return stringBuilder.toString();
        }
    }
}
