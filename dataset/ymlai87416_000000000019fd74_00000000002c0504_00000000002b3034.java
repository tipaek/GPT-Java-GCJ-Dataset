import java.io.File;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static String   FILENAME;
    static Scanner sc;
    static String   IN;
    static String   OUT;
    static PrintStream out;

    static{
        try{
            /*
            FILENAME = "Solution-large";
            IN = FILENAME + ".in";
            OUT = FILENAME + ".out";
            sc = new Scanner(new File(IN));
            out      = new PrintStream(
                    new FileOutputStream(OUT, false));
                    */

            //IN = "C:\\GitProjects\\algorithm_practice\\java\\src\\main\\java\\GoogleCodeJam\\Y2020\\RoundA\\A\\A-test.in";
            IN = null;
            if(IN == null)
                sc = new Scanner(System.in);
            else
                sc = new Scanner(new File(IN));
            out = new PrintStream(System.out);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private String solve(ArrayList<String> inputs){
        //do nothing
        //given a set, find the min prefix and suffix, and then send the whole ans to recursive function. done

        String prefix = "";
        String suffix = "";

        if(inputs.size() == 0)
            return "";
        else if(inputs.size()== 1)
            return inputs.get(0).replaceAll("\\*", "");

        for(int i=0; i< inputs.size(); ++i){
            StringBuilder sb = new StringBuilder();
            String temp;
            for (int j = 0; j <inputs.get(i).length() ; j++) {
                if(inputs.get(i).charAt(j) != '*')
                    sb.append(inputs.get(i).charAt(j));
                else
                    break;
            }
            temp = sb.toString();
            if(temp.length() > prefix.length())
                prefix = temp;

            sb = new StringBuilder();
            for (int j = inputs.get(i).length()-1; j >=0 ; j--) {
                if(inputs.get(i).charAt(j) != '*')
                    sb.append(inputs.get(i).charAt(j));
                else
                    break;
            }
            reverseString(sb);
            temp = sb.toString();
            if(temp.length() > suffix.length())
                suffix = temp;
        }

        //case: prefix, suffix empty, all string start by * and end by *
        if(prefix.length() == 0 && suffix.length() == 0){
            boolean allStart = true;
            for(int i=0; i<inputs.size(); ++i) {
                if(inputs.get(i).length() > 1) {
                    inputs.set(i, inputs.get(i).substring(1));
                    allStart =false;
                    break;
                }
            }
            if(allStart) return "";
            else return solve(inputs);
        }

        //longest prefix and suffix on hand
        for(int i=0; i<prefix.length(); ++i){
            String suf = suffix.substring(0, Math.min(prefix.length()-i, suffix.length()));
            if(prefix.endsWith(suf)){
                String b = prefix.substring(0, i) + suf;
                String ans;
                boolean isAns = true;
                for (int j = 0; j < inputs.size(); j++) {
                    ans = compatable(b, inputs.get(j), 0, 0, -1, "");
                    if(ans==null){
                        isAns = false;
                        break;
                    }
                }
                if(!isAns) continue;
                else return b;
            }
        }

        //prefix+suffix?
        String b = prefix + suffix;
        String ans;
        boolean isAns = true;
        for (int j = 0; j < inputs.size(); j++) {
            ans = compatable(b, inputs.get(j), 0, 0, -1, "");
            if(ans==null){
                isAns = false;
                break;
            }
        }
        if(isAns) return b;

        b = prefix+"*"+suffix; //the worst, can suffix and prefix merge, then we get the answer.

        ArrayList<String> newInput = new ArrayList<>();
        for(int i=0; i<inputs.size(); ++i) {
            String temp = compatable(b, inputs.get(i), 0, 0, b.indexOf("*"), "");
            if(temp == null) return "*";
            if(temp != "")
                newInput.add(temp);
        }


        return prefix+solve(newInput)+suffix;
    }

    private void reverseString(StringBuilder sb){
        StringBuilder sb2 = new StringBuilder();
        for(int i=0, j=sb.length()-1; i<j; ++i, --j){
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, c);
        }
    }

    private String compatable(String a, String b, int ptr1, int ptr2, int query, String t){
        //base case
        if(ptr1 == a.length() && ptr2 ==b.length())
            return t;
        if(ptr1 == a.length()-1 && a.charAt(ptr1)=='*') {
            if(ptr1 == query)
                return b.substring(ptr2);
            else
                return t;
        }
        if(ptr2 == b.length()-1 && b.charAt(ptr2)=='*')
            return t;
        if(ptr1 == a.length() && ptr2 != b.length() || ptr1 != a.length() && ptr2 == b.length())
            return null;

        char ca= a.charAt(ptr1);
        char cb =b.charAt(ptr2);

        if(ca != '*' && cb != '*'){
            if(ca == cb) {
                String aa = compatable(a, b, ptr1 + 1, ptr2 + 1, query, t);
                //System.out.println("debug: " + a.substring(ptr1) + ", " + b.substring(ptr2) + " ans: " + (aa == null));
                return aa;
            }
            else
                return null;
        }
        else{
            //if anyone is *, advance either * or others
            if(ptr1 == query) {
                //match as further as possible
                String aa  = compatable(a, b, ptr1, ptr2 + 1, query, t + b.charAt(ptr2));
                if(aa != null) return aa;
                aa = compatable(a, b, ptr1 + 1, ptr2, query, t);
                //System.out.println("debug: " + a.substring(ptr1) +", " + b.substring(ptr2) + " ans: " + (aa==null));
                return aa;
            }
            else{
                String aa  = compatable(a, b, ptr1 + 1, ptr2, query, t);
                if(aa != null) return aa;
                aa = compatable(a, b, ptr1, ptr2 + 1, query, t);
                //System.out.println("debug: " + a.substring(ptr1) +", " + b.substring(ptr2) + " ans: " + (aa==null));
                return aa;
            }
        }
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();


        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");

            int size = sc.nextInt();
            sc.nextLine();
            ArrayList<String> inputs = new ArrayList<>();

            for(int p=0; p<size; ++p){
                String line = sc.nextLine();
                line = line.replaceAll("(\\*)+", "\\*");
                inputs.add(line);
            }

            String result = solve(inputs);
            out.format("%s\n", result);
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
