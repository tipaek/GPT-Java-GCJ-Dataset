import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

final class Solution {

    public static void main(String[] args) {
         
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        in.nextLine();  
        for (int i = 0; i < cases; i++) {
            String s = new String();
            s = in.nextLine();
            StringBuilder second = new StringBuilder();
            StringBuilder last= new StringBuilder();
          
           
            second.append("0");
            second.append(s);
            second.append("0");

            int j = 0;
            int a = 0;
            while((j < second.length()-1)&&(a<s.length())){
                int indent =Character.getNumericValue(second.charAt(j)) -  Character.getNumericValue(second.charAt(j+1));
                
                if(indent <0){
                   while(indent < 0){
                       last.append("(");
                       indent++;
                   }  
                  last.append(s.charAt(a));
                  a++;
                }else
                if(indent > 0 ){
                    while(indent > 0){
                        last.append(")");
                        indent--;
                    }  
                   last.append(s.charAt(a));
                   a++;
                }else
                if(indent == 0 ){
                    
                   last.append(s.charAt(a));
                   a++;
                }
                j++;
                
            }
            for(int x = 0; x <Character.getNumericValue(s.charAt(s.length()-1)); x++){
                last.append(")");
            }
            

            System.out.println("Case #" + (i+1) + ": " + last.toString());
            
        }
    }
}