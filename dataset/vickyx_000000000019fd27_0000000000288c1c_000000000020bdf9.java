import java.io.*;
import java.util.*;

public class NestingDepth{
    public static void main(String[] args){
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while(input.hasNextLine()){
            int cases = input.nextLine();
        }
        for(int i=0;i<cases;i++){
            System.out.println("Case #"+i+": "+addP()); 
        }
    }

    private static String addP(){
        Stack<Integer> s = new Stack<>();
        String line = input.nextLine();
        //save the digits read in a line into a stack
        String toAddRight = "";
        String toAddLeft = "";
        String res = "";
        int digit = s.pop();
        if(digit!='0'){
            for(int j=0;j<digit;j++){
                toAddRight += ')';
                toAddLeft+='(';
                res = toAddLeft + res + toAddRight;
                
            }   
        }
        else res = res + digit;

    return res;
    }
}