import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();
        for (int p=1; p<=num; p++)
        {
            String str=input.nextLine();
            String fin= "";
            int q=0;
            for (int k=0; k<str.length(); k++)
            {
                if (q==0 && str.charAt(k)!='0' && (k==0 || str.charAt(k-1)=='0'))
                {    
                    int c=Character.getNumericValue(str.charAt(k));
                    for (int n=0; n<c; n++)
                        fin+="(";
                    q=1;
                }
                if (q==0 && k!=0 && Character.getNumericValue(str.charAt(k-1))<Character.getNumericValue(str.charAt(k)))
                {
                    int x=Character.getNumericValue(str.charAt(k))-Character.getNumericValue(str.charAt(k-1));
                    for (int n=0; n<x; n++)
                        fin+="(";
                    q=1;
                }
                if (q==0 && k!=0 && Character.getNumericValue(str.charAt(k-1))>Character.getNumericValue(str.charAt(k)))
                {
                    int b=Character.getNumericValue(str.charAt(k-1))-Character.getNumericValue(str.charAt(k));
                    for (int n=0; n<b; n++)
                        fin+=")";
                    q=1;
                }
                fin+=str.charAt(k);
                if (k==str.length()-1 && str.charAt(k)!='0')
                {
                    for (int n=0; n<Character.getNumericValue(str.charAt(k)); n++)
                        fin+=")";
                }
                
                q=0;
                
            }
            
            System.out.println("Case #" + p + ": " + fin);

        }
        input.close();
    }
}
