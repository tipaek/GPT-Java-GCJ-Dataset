import java.io.*;
import java.util.Arrays;

class Solution{
    public static void main(String[] args) {
//        Reader inputString = new StringReader("3\n" +
//                "4\n" +
//                "1 2 3 4\n" +
//                "2 1 4 3\n" +
//                "3 4 1 2\n" +
//                "4 3 2 1\n" +
//                "4\n" +
//                "2 2 2 2\n" +
//                "2 3 2 3\n" +
//                "2 2 2 3\n" +
//                "2 2 2 2\n" +
//                "3\n" +
//                "2 1 3\n" +
//                "1 3 2\n" +
//                "1 2 3");
//        Reader inputString = new StringReader("5\n" +
//                "0000\n" +
//                "101\n" +
//                "111000\n" +
//                "1\n"+
//                "221");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader in = new BufferedReader(inputString);
        String line = "";
        try {
            while ((line = in.readLine())!=null){
                int numc = Integer.parseInt(line);
                for(int c=0;c<numc;c++){
                    String digits = in.readLine();
                    int len = digits.length();
                    int[] need = new int[len];
                    for(int i=0;i<len;i++){
                        need[i] = Character.getNumericValue(digits.charAt(i));
                    }
                    String ans = solveIt(digits,need);
//                    System.out.println("Case #"+(c+1)+":"+" " + trace + " " +rowc + " " + colc + " ");
                    System.out.println("Case #"+(c+1)+":"+" " + ans);
                }

            }
        }
        catch (IOException e){}

    }
    public static String solveIt(String digits, int[] needed){
        int length = digits.length();
        if(length==0) return "";
        int min = 10;
        for(int i=0;i<length;i++){
            if(needed[i]<min) min = needed[i];
        }
        for(int i=0;i<length;i++){
            needed[i] -= min;
        }
        StringBuilder ret = new StringBuilder();
        for(int i=0;i<min;i++){
            ret.append('(');
        }
        for(int i=0;i<length;i++){
            if(needed[i]==0){
                ret.append(digits.charAt(i));
            }
            else{
                int j = i+1;
                while (j<length && needed[j]!=0){
                    j++;
                }
                ret.append(solveIt(digits.substring(i,j), Arrays.copyOfRange(needed, i, j)));
                i = j-1;
            }
        }
        for(int i=0;i<min;i++){
            ret.append(')');
        }
        return ret.toString();
    }
}


