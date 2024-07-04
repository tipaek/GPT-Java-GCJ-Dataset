import java.util.*;
import java.lang.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int count=input.nextInt();
        
        for (int i=0;i<count;i++){
            int upper=input.nextInt();
            String result=new String();
            Map<Long,Character> map=new HashMap<>();
            
            for (int j=0;j<10000;j++){
                long number=input.nextLong();
                String encode=input.next();
                handle(map,number,encode);
            }
            for (int k=0;k<10;k++){
                result+=Character.toString(map.get(k));
            }
            System.out.println("Case #"+String.valueOf(i+1)+": "+result);
        }
    }
    
    public static void handle(Map<Long,Character> map,long number,String encode){
        if (number!=-1){
            for (int i=encode.length()-1;i>=0;i--){
                map.put(number%10,encode.charAt(i));
                number/=10;
            }
        }
    }
}
