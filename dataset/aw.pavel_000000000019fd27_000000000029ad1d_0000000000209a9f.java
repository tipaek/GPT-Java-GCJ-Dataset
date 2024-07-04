import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    byte n = in.nextByte();  
    
    String[] cases = new String[n];
    char value, prevValue;
    byte symbolIndex, symbolQty, innerIndex, index = 0;
    
    for (index = 0; in.hasNext() && index < n; ++index) {
        cases[index] = in.next();
    }

    //String result = "";
    for(index = 0; index < n; index++) {
        prevValue = '0';
        StringBuilder result = new StringBuilder();
        for(innerIndex = 0; innerIndex<cases[index].length(); innerIndex++) {
            //value = Character.getNumericValue(cases[index].charAt(innerIndex));
            value = cases[index].charAt(innerIndex);
            
            if (prevValue > value)
                for(symbolIndex = 0; symbolIndex<(prevValue-value);symbolIndex++)
                    result.append(")");
            
            if (prevValue < value)
                for(symbolIndex = 0; symbolIndex<(value-prevValue);symbolIndex++)
                    result.append("(");
            result.append(value);
            //result += (char)value;
            
            prevValue = value;
            if (innerIndex == cases[index].length() - 1)
                for(symbolIndex = '0'; symbolIndex<value; symbolIndex++)
                    result.append(")");
        }
        System.out.println("Case #"+(index+1)+": "+result.toString());
    }
  }
} 