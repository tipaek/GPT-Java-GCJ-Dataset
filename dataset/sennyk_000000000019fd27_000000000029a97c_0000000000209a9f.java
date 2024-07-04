import java.io.*;
import java.util.*;

public class Solution{
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter (new OutputStreamWriter(System.out));
         int TestCases = Integer.parseInt(in.readLine());
         for (int a=0;a<TestCases;a++)
         {
             String casE = (in.readLine());
             String caseAns =  "";
             String caseActualAns = "";
             for(int b=0;b<casE.length();b++)
             {
                 int number = Integer.parseInt(casE.substring(b,b+1));
                 for (int c=0;c<number;c++)
                 {
                     caseAns+="(";
                 }
                 caseAns+=number;
                  for (int d=0;d<number;d++)
                 {
                     caseAns+=")";
                 }
             }
            while(caseAns.contains(")(") == true)
            {
             caseAns = caseAns.replace(")(","");
            }
             out.println("Case #"+ (a+1) +": "+caseAns);
         }
         out.close();
    }
}             
         