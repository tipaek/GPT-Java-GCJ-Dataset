import java.util.*;

public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int n = 1; n <= cases; n++){
            if(n == 1) sc.nextLine();
            String str = sc.nextLine();
            int strPointer = 0, counter = 0;
            StringBuilder builder = new StringBuilder();

            while(strPointer < str.length()){
                int actual = Integer.parseInt(Character.toString(str.charAt(strPointer)));
                if(actual == counter){
                    builder.append(str.charAt(strPointer));
                    strPointer++;
                }else{
                    if(actual > counter){
                        builder.append('(');
                        counter++;
                    }else{
                        builder.append(')');
                        counter--;
                    }
                }
            }

            while(counter > 0){
                builder.append(')');
                counter --;
            }  
            System.out.println("Case #" + n +": " + builder.toString());
        }
    }
}