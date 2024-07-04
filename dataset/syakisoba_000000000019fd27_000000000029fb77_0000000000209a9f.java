import java.io.*;
import java.util.*;

/**
 *
 * @author michael
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; i++) {
            String inS = in.next();
            String outS = "";
            int sLength = inS.length();
            int braCount = 0;
            char temp;
            
            for(int j = 0; j < sLength; j++){
                if(sLength > 1){
                    if(j == 0){ //first
                        switch (inS.charAt(j)) {
                            case '0':
                                temp = inS.charAt(j);
                                outS += temp;
                                //System.out.println("first/0");
                                break;
                        //System.out.println("===============");
                            case '1':
                                braCount = 1;
                                temp = inS.charAt(j);
                                outS = "(";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            case '2':
                                braCount = 2;
                                temp = inS.charAt(j);
                                outS = "((";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            case '3':
                                braCount = 3;
                                temp = inS.charAt(j);
                                outS = "(((";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            case '4':
                                braCount = 4;
                                temp = inS.charAt(j);
                                outS = "((((";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            case '5':
                                braCount = 5;
                                temp = inS.charAt(j);
                                outS = "(((((";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            case '6':
                                braCount = 6;
                                temp = inS.charAt(j);
                                outS = "((((((";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            case '7':
                                braCount = 7;
                                temp = inS.charAt(j);
                                outS = "(((((((";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            case '8':
                                braCount = 8;
                                temp = inS.charAt(j);
                                outS = "((((((((";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            case '9':
                                braCount = 9;
                                temp = inS.charAt(j);
                                outS = "(((((((((";
                                outS += temp;
                                //System.out.println("first/1");
                                break;
                            default:
                                break;
                        }
                    }else if(j== sLength-1){ //last
                        switch (inS.charAt(j)) {
                            case '0':
                                if(braCount != 0){
                                    for(int k = braCount; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 0){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    //2~9
                                }   break;
                            case '1':
                                if(braCount > 1){
                                    for(int k = braCount-1; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")";
                                }else if(braCount == 1){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")";
                                }else if(braCount == 0){
                                    //temp = inS.charAt(j);
                                    outS += "(1)";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 0 brackets====");
                                }   break;
                            case '2':
                                if(braCount > 2){
                                    for(int k = braCount-2; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))";
                                }else if(braCount == 2){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))";
                                }else if(braCount == 0){
                                    //temp = inS.charAt(j);
                                    outS += "((2))";
                                }else if(braCount < 2){
                                    for(int k = 2 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 2 brackets====");
                                }   break;
                            case '3':
                                if(braCount > 3){
                                    for(int k = braCount-3; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))";
                                }else if(braCount == 3){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))";
                                }else if(braCount < 3){
                                    for(int k = 3 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 3 brackets====");
                                }   break;
                            case '4':
                                if(braCount > 4){
                                    for(int k = braCount-4; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))";
                                }else if(braCount == 4){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))";
                                }else if(braCount < 4){
                                    for(int k = 4 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 4 brackets====");
                                }   break;
                            case '5':
                                if(braCount > 5){
                                    for(int k = braCount-5; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))";
                                }else if(braCount == 5){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))";
                                }else if(braCount < 5){
                                    for(int k = 5 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 5 brackets====");
                                }   break;
                            case '6':
                                if(braCount > 6){
                                    for(int k = braCount-6; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))))";
                                }else if(braCount == 6){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))))";
                                }else if(braCount < 6){
                                    for(int k = 6 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))))";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 6 brackets====");
                                }   break;
                            case '7':
                                if(braCount > 7){
                                    for(int k = braCount-7; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))))";
                                }else if(braCount == 7){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))))";
                                }else if(braCount < 7){
                                    for(int k = 7 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))))";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 7 brackets====");
                                }   break;
                            case '8':
                                if(braCount > 8){
                                    for(int k = braCount-8; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))))))";
                                }else if(braCount == 8){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))))))";
                                }else if(braCount < 8){
                                    for(int k = 8 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += "))))))))";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 8 brackets====");
                                }   break;
                            case '9':
                                if(braCount > 9){
                                    for(int k = braCount-9; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))))))";
                                }else if(braCount == 9){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))))))";
                                }else if(braCount < 9){
                                    for(int k = 9 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                    outS += ")))))))))";
                                }else{
                                    
                                    //System.out.println("Error: 11111 -- 9 brackets====");
                                }   break;
                            default:
                                break;
                        }
                    }else{ //middle
                        switch (inS.charAt(j)) {
                            case '0':
                                if(braCount != 0){
                                    for(int k = braCount; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 0){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }   break;
                            case '1':
                                if(braCount == 1){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount >1){
                                    for(int k = braCount - 1; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 0){
                                    outS += "(";
                                    braCount++;
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }   break;
                            case '2':
                                if(braCount > 2){
                                    for(int k = braCount-2; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 2){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount < 2){
                                    for(int k = 2 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    
                                    //System.out.println("Error: mmm  -- 2 brackets====");
                                }   break;
                            case '3':
                                if(braCount > 3){
                                    for(int k = braCount-3; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 3){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount < 3){
                                    for(int k = 3 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    
                                    //System.out.println("Error: mmm  -- 3 brackets====");
                                }   break;
                            case '4':
                                if(braCount > 4){
                                    for(int k = braCount-4; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 4){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount < 4){
                                    for(int k = 4 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    
                                    //System.out.println("Error: mmm -- 4 brackets====");
                                }   break;
                            case '5':
                                if(braCount > 5){
                                    for(int k = braCount-5; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 5){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount < 5){
                                    for(int k = 5 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    
                                    //System.out.println("Error: mmm  -- 5 brackets====");
                                }   break;
                            case '6':
                                if(braCount > 6){
                                    for(int k = braCount-6; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 6){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount < 6){
                                    for(int k = 6 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    
                                    //System.out.println("Error: mmm  -- 6 brackets====");
                                }   break;
                            case '7':
                                if(braCount > 7){
                                    for(int k = braCount-7; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 7){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount < 7){
                                    for(int k = 7 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    
                                    //System.out.println("Error: mmm  -- 7 brackets====");
                                }   break;
                            case '8':
                                if(braCount > 8){
                                    for(int k = braCount-8; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 8){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount < 8){
                                    for(int k = 8 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    
                                    //System.out.println("Error: mmm -- 8 brackets====");
                                }   break;
                            case '9':
                                if(braCount > 9){
                                    for(int k = braCount-9; k > 0; k--){
                                        outS += ")";
                                        braCount--;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount == 9){
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else if(braCount < 9){
                                    for(int k = 9 - braCount; k > 0; k--){
                                        outS += "(";
                                        braCount++;
                                    }
                                    temp = inS.charAt(j);
                                    outS += temp;
                                }else{
                                    
                                    //System.out.println("Error: mmmm -- 9 brackets====");
                                }   break;
                            default:
                                break;
                        }
                    }
                    
                }else if(sLength ==1){ //only 1 char String
                    switch (inS.charAt(j)) {
                        case '0':
                            outS = inS;
                            break;
                        case '1':
                            outS = "(1)";
                            break;
                        case '2':
                            outS = "((2))";
                            break;
                        case '3':
                            outS = "(((3)))";
                            break;
                        case '4':
                            outS = "((((4))))";
                            break;
                        case '5':
                            outS = "(((((5)))))";
                            break;
                        case '6':
                            outS = "((((((6))))))";
                            break;
                        case '7':
                            outS = "(((((((7)))))))";
                            break;
                        case '8':
                            outS = "((((((((8))))))))";
                            break;
                        case '9':
                            outS = "((((((((9)))))))))";
                            break;
                        default:
                            break;
                    }
                }else{
                    //System.out.println("Error: .mdsafklsajfd");
                }
            }
            //System.out.println(outS);
            System.out.println("Case #" + i + ": " + outS);
        }
    }

}