import java.util.Scanner;
import java.lang.Integer;

public class Solution {
    public static void main(String[] arg){
        Scanner s=new Scanner(System.in);
        char a='(',c=')';
        int tc=s.nextInt();
        for(int in=0;in<tc;in++){
            String numbers=s.next();
            StringBuffer result=new StringBuffer();
            char b=numbers.charAt(0);
            Integer numValue=Character.getNumericValue(b);
            Integer level=numValue;
            for(int i=0;i<numValue;i++){
                result.append(a);
            }
            result.append(b);
            for(int i=1;i<numbers.length();i++){
                b=numbers.charAt(i);
                numValue=Character.getNumericValue(b);
                if(numValue<level){
                    int diff=level-numValue;
                    for(int j=0;j<diff;j++){
                        result.append(c);
                    }
                } else if(numValue>level) {
                    int diff = numValue - level;
                    for (int j = 0; j < diff; j++) {
                        result.append(a);
                    }
                }
                result.append(b);
                level=numValue;
            }
            for(int j=0;j<level;j++){
                result.append(c);
            }
            int testno=in+1;
            System.out.println("Case #"+testno+": "+result);
        }
    }
}
