import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner S = new Scanner(System.in);
        Integer T = S.nextInt();
        for(Integer t = 0 ; t < T ;t++) {
            String s = S.nextLine();
            String result = "";
            Integer count = 0;
            for(Integer i = 0; i < s.length() ; i++){
                Integer num = Integer.parseInt(s.charAt(i) + "");
                int diff = num - count;
                if(diff > 0){
                    for(int repeat = 0; repeat < diff ; repeat++){
                        result += "(";
                    }

                    count += diff;
                }
                else if(diff < 0){
                    for(int repeat = 0; repeat < -diff ; repeat++){
                        result += ")";
                    }
                    count += diff;
                }

                result += num;

            }

            for(int repeat = 0; repeat < count ; repeat++){
                result += ")";
            }
            System.out.println(result);
        }

    }
}