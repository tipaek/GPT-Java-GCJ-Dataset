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
                    if(i == 0 || curr.charAt(i - 1) == '0'){
                        s += "(1)";
                    }
                    else{
                        s = s.substring(0, s.length() - 1);
                        s += "1)";
                    }
                }
                if(curr.charAt(i) == '2'){
                    if(i == 0  || curr.charAt(i - 1) == '0'){
                        s += "((2))";
                    }
                    else{
                        if(curr.charAt(i - 1) == '2'){
                            s = s.substring(0, s.length() - 2);
                            s += "2))";
                        }
                        if(curr.charAt(i - 1) == '1'){
                            s = s.substring(0, s.length() - 1);
                            s += "(2))";
                        }
                        if(curr.charAt(i - 1) == '3'){
                            s = s.substring(0, s.length() - 2);
                            s += "2))";
                        }
                        if(curr.charAt(i - 1) == '4'){
                            s = s.substring(0, s.length() - 2);
                            s += "2))";
                        }
                        if(curr.charAt(i-1) == '5'){
                            s.substring(0, s.length() - 4);
                            s += "2))";
                        }
                    }
                }
                if(curr.charAt(i) == '3'){
                    if(i == 0 || curr.charAt(i - 1) == '0'){
                        s += "(((3)))";
                    }
                    else{
                        if(curr.charAt(i- 1) == '1'){
                            s.substring(0, s.length() - 1);
                            s += "((3)))";
                        }
                        if(curr.charAt(i- 1) == '2'){
                            s.substring(0, s.length() - 1);
                            s += "(3)))";
                        }
                        if(curr.charAt(i- 1) == '3'){
                            s.substring(0, s.length() - 3);
                            s += "3)))";
                        }
                        if(curr.charAt(i- 1) == '4'){
                            s.substring(0, s.length() - 4);
                            s += "3)))";
                        }
                        if(curr.charAt(i-1) == '5'){
                            s.substring(0, s.length() - 4);
                            s += "3)))";
                        }
                    }
                }
                if(curr.charAt(i) == '4'){
                    if(i == 0 || curr.charAt(i - 1) == '0'){
                        s += "((((4))))";
                    }
                    else{
                        if(curr.charAt(i- 1) == '1'){
                            s.substring(0, s.length() - 1);
                            s += "(((4))))";
                        }
                        if(curr.charAt(i- 1) == '2'){
                            s.substring(0, s.length() - 2);
                            s += "((4))))";
                        }
                        if(curr.charAt(i- 1) == '3'){
                            s.substring(0, s.length() - 3);
                            s += "(4))))";
                        }
                        if(curr.charAt(i- 1) == '4'){
                            s.substring(0, s.length() - 4);
                            s += "4))))";
                        }
                        if(curr.charAt(i-1) == '5'){
                            s.substring(0, s.length() - 5);
                            s += "4))))";
                        }
                    }
                }
                if(curr.charAt(i) == '5'){
                    if(i == 0 || curr.charAt(i - 1) == '0'){
                        s += "(((((5)))))";
                    }
                    else{
                        if(curr.charAt(i- 1) == '1'){
                            s.substring(0, s.length() - 1);
                            s += "((((5)))))";
                        }
                        if(curr.charAt(i- 1) == '2'){
                            s.substring(0, s.length() - 2);
                            s += "(((5)))))";
                        }
                        if(curr.charAt(i- 1) == '3'){
                            s.substring(0, s.length() - 3);
                            s += "((5)))))";
                        }
                        if(curr.charAt(i- 1) == '4'){
                            s.substring(0, s.length() - 4);
                            s += "(5))))";
                        }
                    }
                }
                if(curr.charAt(i) == '0'){
                    s += "0";
                }
            }
            return s;
        }
    }