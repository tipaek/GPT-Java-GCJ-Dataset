import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int noOfTests = Integer.parseInt(scanner.nextLine());
        for (int caseNo = 1; caseNo <= noOfTests; caseNo++)
        {
            int noOfPatterns = Integer.parseInt(scanner.nextLine());
            // Solve test set 1 and 2
            String start = "";
            String end = "";
            for (int i = 0; i < noOfPatterns; i++)
            {
                String[] components = scanner.nextLine().split("*");

                // Update start
                if (components.length > 0)
                {
                    if (components[0].startsWith(start))
                    {
                        start = components[0];
                    }
                    else if (!start.startsWith(components[0])) {
                        start = "*";
                        end = "";
                        break;
                    }
                }

                // Update end
                if (components.length > 1)
                {
                    if (components[1].endsWith(end))
                    {
                        end = components[1];
                    }
                    else if (!end.endsWith(components[1]))
                    {
                        start = "*";
                        end = "";
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNo + ": " + start + end);
        }
    }
}
