import java.util.Scanner;

class Solution {

    public static void main(String[] args){

        Scanner stdScanner = new Scanner(System.in);
        int testCases = Integer.parseInt(stdScanner.nextLine().trim());

        String stream = "";
        int r = 0;
        while(r < testCases){

            stream = stdScanner.nextLine().trim();
            NestingDepth nestingDepth = new NestingDepth(r, stream);
            System.out.println(nestingDepth.getPatternWithBraces());
            r++;
        }
        stdScanner.close();
    }
}

class NestingDepth{

    String pattern;
    int testId;
    public NestingDepth(int testId, String pattern){

        //System.out.println(pattern);
        this.pattern = pattern;
        this.testId = testId;
    }

    public String getPatternWithBraces(){

        String patternWithBraces = "";
        char[] chars = pattern.toCharArray();
        int currentDigit = 0;
        StringBuffer sb = new StringBuffer("");
        for(char ch : chars){

            int digit = ch - '0';
            int diff = currentDigit - digit;
            //System.out.println(diff);
            while(diff > 0){

                sb.append(")");
                diff--;
            }
            while(diff++ < 0){
                sb.append("(");
            }
            sb.append(digit);
            currentDigit = digit;
        }

        while(currentDigit-- > 0){

            sb.append(")");
        }
        return formatOutput(sb.toString());
    }

    public String formatOutput(String patternWithBraces){

        String ret = "";
        ret += "Case #" + String.valueOf(testId+1) + ": ";
        ret += patternWithBraces;
        return ret;
    }
}
