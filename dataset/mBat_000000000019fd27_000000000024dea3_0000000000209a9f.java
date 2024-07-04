import java.io.*;

class Solution {
    
    public static String getPar(int num, String type) {
        switch(num) {
            case 1: if(type.equals("("))
                        return "(";
                    else
                        return ")";
            case 2: if(type.equals("("))
                        return "((";
                    else
                        return "))";
            case 3: if(type.equals("("))
                        return "(((";
                    else
                        return ")))";
            case 4: if(type.equals("("))
                        return "((((";
                    else
                        return "))))";
            case 5: if(type.equals("("))
                        return "(((((";
                    else
                        return ")))))";
            case 6: if(type.equals("("))
                        return "((((((";
                    else
                        return "))))))";
            case 7: if(type.equals("("))
                        return "(((((((";
                    else
                        return ")))))))";
            case 8: if(type.equals("("))
                        return "((((((((";
                    else
                        return "))))))))";
            case 9: if(type.equals("("))
                        return "(((((((((";
                    else
                        return ")))))))))";
            default: return "";
        }
    }
    
    public static void main(String args[]) throws Exception{
        int t;
        int openPar, val;
        String str;
        StringBuilder builder = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int a=0;a<t;a++) {
            str = br.readLine();
            builder = new StringBuilder();
            openPar = 0;
            for(int i=0;i<str.length();i++) {
                val = Character.getNumericValue(
                                str.charAt(i));
                if(val < openPar) {
                    builder.append(getPar(
                            (openPar - val), ")"));
                    openPar -= (openPar - val);
                }
                else if(val > openPar) {
                    builder.append(getPar(
                            (val - openPar), "("));
                    openPar += (val - openPar);
                }
                builder.append(String.valueOf(str.charAt(i)));
            }
            builder.append(getPar(openPar, ")"));
            System.out.println("Case #" + (a+1)
                        + ": " + builder);
        }
    }
}