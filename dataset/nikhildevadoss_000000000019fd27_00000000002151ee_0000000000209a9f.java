 import java.util .*;
    import java.io .*;

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
                    if(i == 0){
                        s += "(1)";
                    }
                    else{
                        if(curr.charAt(i - 1) == '1'){
                            s = s.substring(0, s.length() - 1);
                            s += "1)";
                        }
                        else{
                            s += "(1)";
                        }
                    }
                }
                else{
                    s += "0";
                }
            }
            return s;
        }
    }