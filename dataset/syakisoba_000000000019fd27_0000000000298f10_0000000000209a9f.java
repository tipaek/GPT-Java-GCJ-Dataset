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
                    if(j == 0){//first
                        if('0' == inS.charAt(j)){
                            temp = inS.charAt(j);
                            outS += temp;
                            //System.out.println("first/0");
                        }else if('1' == inS.charAt(j)){
                            braCount = 1;
                            temp = inS.charAt(j);
                            outS = "(";
                            outS += temp;
                            //System.out.println("first/1");
                        }else{
                            //2~9
                        }
                        //System.out.println("===============");
                    }else if(j== sLength-1){//last
                        if('0' == inS.charAt(j)){
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
                            }
                        }else if('1' == inS.charAt(j)){
                            if(braCount > 1){
                                for(int k = braCount-1; k > 0; k--){
                                    outS += ")";
                                    braCount--;
                                }
                                temp = inS.charAt(j);
                                outS += temp;
                            }else if(braCount == 1){
                                temp = inS.charAt(j);
                                outS += temp;
                                outS += ")";
                            }else if(braCount == 0){
                                temp = inS.charAt(j);
                                outS += "(1)";
                            }else{
                                
                                //System.out.println("Error: 11111 -- 0 brackets====");
                            }
                        }else{
                            //2~9
                        }
                    }else{//middle
                        if('0' == inS.charAt(j)){
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
                            }
                        }else if('1' == inS.charAt(j)){
                            if(braCount == 1){
                                temp = inS.charAt(j);
                                outS += temp;
                            }else if(braCount >1){
                                for(int k = braCount; k > 0; k--){
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
                            }
                        }else{

                        }
                    }
                    
                }else if(sLength ==1){//only 1 char String
                    if('0' == inS.charAt(j)){
                        outS = inS;
                    }else if('1' == inS.charAt(j)){
                        outS = "(1)";
                    }else{
                        //2~9
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