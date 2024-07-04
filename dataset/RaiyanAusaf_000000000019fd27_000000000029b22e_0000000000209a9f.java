import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        String[] answers = new String[numCases];
        int jk = 0;
        for (int i = 0; i < numCases; i++) {
            skipLines(sc,1);
            String temp = sc.nextLine();
            String newTemp = "";
            for (int j = 0; j < temp.length(); j++) {
                if (temp.substring(j,j+1).equals("1"))
                {
                    int k = j+1;
                    int iterations = 1;
                    if (k < temp.length()) {
                        while (temp.substring(k,k+1).equals("1")) {
                            iterations++;
                            k++;
                        }
                    }
                    if (iterations > 0)
                    {
                        j=k-1;
                    }   
                    newTemp+="(";
                    for (int l = 0; l < iterations; l++)
                    {
                        newTemp+="1";
                    }
                    if (iterations == 0)
                    {
                        newTemp+="1";
                    }
                    newTemp+=")";
                }
                else {
                    newTemp+="0";
                }
            }
            int caseNum = i+1;
            String solution = ("Case #" + caseNum + ": " + newTemp);
            if (solution.length()>0) {
                answers[jk] = solution;
                jk++;
            }
        }
        for (int i = 0; i < answers.length; i++)
        {
            System.out.println(answers[i]);
        }
    }
    public static void skipLines(Scanner s,int lineNum){
        for(int i = 0; i < lineNum;i++){
            if(s.hasNextLine())s.nextLine();
        }
    }
}
