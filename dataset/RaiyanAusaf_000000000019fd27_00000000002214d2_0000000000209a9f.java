import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        for (int i = 0; i < numCases; i++) {
            String temp = sc.nextLine();
            String newTemp = "";
            for (int j = 0; j < temp.length(); j++) {
                if (temp.substring(j,j+1).equals("0"))
                {
                    newTemp+="0";
                }
                else {
                    int iterations = 0;
                    int k = j;
                    if (k < temp.length()) {
                        while (temp.substring(k,k+1).equals("1")) {
                            iterations++;
                        }
                    }
                    newTemp+="(";
                    for (int z = 0; z <= iterations; z++) {
                        newTemp+="1";
                    }
                    newTemp+=")";
                }
            }
            int caseNum = i+1;
            System.out.println("Case #" + caseNum + ": " + newTemp);
        }
    }
}
