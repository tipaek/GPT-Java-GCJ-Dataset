import java.util.*;

public class nest{


    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for(int i = 0 ; i < n ; i ++ ){

            char[] withParen = new char[100000];
            String finalString = "sdfdsf";

            String initialString = stdin.next();
            // System.out.println("HERE IS THE INTIAL STRING: "  + initialString);
            char[] initialChar = initialString.toCharArray();


            int level = 0; 
            int prevLevel = 0;
            int withParenIndex = 0;
            int len = initialChar.length;
            System.out.print("Case #" + (i+1) + ": ");
            for(int j = 0 ; j < len ;  j ++){
               
                level = Integer.parseInt(String.valueOf(initialChar[j]));
                
                // System.out.println(j + " :" +  level);

                if(level > prevLevel){
                    for(int k = 0 ; k < (level - prevLevel); k++){
                        withParen[withParenIndex] = '(';
                        System.out.print("(");
                        withParenIndex++;
                    }
                }

                if(level < prevLevel){
                    for(int k = 0 ; k < (prevLevel - level); k++){
                        withParen[withParenIndex] = ')';
                        System.out.print(")");
                        withParenIndex++;
                    }
                }

               

                //add current number
                withParen[withParenIndex] = initialChar[j];
                System.out.print(initialChar[j]);
                withParenIndex++;
                // prev = current
                prevLevel = level;
                 
                //this part could be problems
                if(j == (len - 1) ){
                    for(int k = level ; k > 0 ; k--){
                        // withParen[withParenIndex] = ')';
                        // withParenIndex++;
                        System.out.print(")");
                    }
                }
                
            }

            System.out.println();
           
        }

        stdin.close();


    }

}