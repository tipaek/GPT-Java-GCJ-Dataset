import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Saurabh
 */
public class Solution {
    public static void main(String []ar)throws Exception{
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(reader.nextLine());
        int i = 0; 
        while(i < t){
            String temp = reader.nextLine();
            char num[] = temp.toCharArray();
            int closebrace=0;
            String output="";
            for(int j=0;j<num.length;j++){
                if(j==0){
                    output = appendBrace(output,'(',Character.getNumericValue(num[j]));
                    output = output + num[j];
                    closebrace=Character.getNumericValue(num[j]);
                }
                else if(Character.getNumericValue(num[j])==Character.getNumericValue(num[j-1])){
                    output = output + num[j];
                }
                else if(Character.getNumericValue(num[j]) < Character.getNumericValue(num[j-1])){
                    int diff = Character.getNumericValue(num[j-1]) - Character.getNumericValue(num[j]);
                    output = appendBrace(output,')',diff);
                    output = output + num[j];
                    closebrace = closebrace - diff;
                }
                else if(Character.getNumericValue(num[j]) > Character.getNumericValue(num[j-1])){
                    int diff = Character.getNumericValue(num[j]) - Character.getNumericValue(num[j-1]);
                    output = appendBrace(output,'(',diff);
                    output = output + num[j];
                    closebrace = closebrace + diff;
                }
            }
            if(closebrace > 0){
                output = appendBrace(output, ')', closebrace);
            }
            System.out.println("Case #" + (i+1) + ": " + output);
            i++;
        }
    }
    
    public static String appendBrace(String abc,char bracket,int time){
        for(int i=0;i<time;i++){
                abc=abc+bracket;
        } 
        return abc;
    }
    
}
