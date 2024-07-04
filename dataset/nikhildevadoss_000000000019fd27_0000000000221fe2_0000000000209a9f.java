import java.util;
import java.io;

    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            //number of test cases
            int t = in.nextInt(); 
            in.nextLine();
            for(int i = 1; i <= t; i++){
                String curr = in.nextLine();
                String s = nest(curr);
                System.out.println("Case #" + i + ": " + s);
            }
        }
        public static String nest(String curr){
            String s = "";
            for(int i = 0; i < curr.length(); i++){
                if(curr.charAt(i) == '1'){
                    if(i == 0 || curr.charAt(i - 1) == '0'){
                        s += "(1)";
                    }
                    else{
                        s = s.substring(0, s.length() - 1);
                        s += "1)";
                    }
                }
                else if(i == 0 || curr.charAt(i - 1) == '0'){
                    String currStr = curr.substring(i, i + 1);
                    for(int j = 0; j < Integer.parseInt(currStr); j++){
                        s += "(";
                    }
                    s += currStr;
                    for(int j = 0; j < Integer.parseInt(currStr); j++){
                        s += ")";
                    }
                    
                }
                else{
                    String temp = curr.substring(i, i + 1);
                    int num = Integer.parseInt(temp);
                    for(int j = 0; j < num; j++){
                        temp += ")";
                    }
                    int lastNum = Character.getNumericValue(curr.charAt(i - 1));
                    if(lastNum <= num){
                       s = s.substring(0, s.length() - lastNum);
                       if(lastNum < num){
                            for(int j = lastNum; j < num; j++){
                                s += "(";
                            }
                       }
                       s += temp;
                    }
                    else{
                        s = s.substring(0, s.length() - num);
                        s += temp;
                    }
                }
            }
            return s;
        }
        
    }