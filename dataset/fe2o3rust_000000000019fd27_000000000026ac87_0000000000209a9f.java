import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public  class Solution {
    public static void main(String[] arg)throws IOException{

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int numCases= Integer.parseInt(reader.readLine());

        for(int i =0;i<numCases;i++){
            CaseInputs inp=readCase(reader);


            CaseOutputs outp=processCase(inp);
            printOutput(i+1,outp);
        }
    }

    private static CaseOutputs processCase(CaseInputs inputs){
        CaseOutputs outputs=new CaseOutputs();

        StringBuilder sb=new StringBuilder();
        int prevDigit=0;
        for(int digit:inputs.digits){
            int diff=prevDigit-digit;
            if(diff>0){
                for(int d=0;d<diff;d++){
                    sb.append(")");
                }
            }else if(diff<0){
                diff=diff*-1;
                for(int d=0;d<diff;d++){
                    sb.append("(");
                }
            }
            sb.append(digit);
            prevDigit=digit;
        }
        //final closure

        for(int d=0;d<prevDigit;d++){
            sb.append(")");
        }


        outputs.result=sb.toString();


        return outputs;
    }

    private static CaseInputs readCase(BufferedReader reader)throws IOException{
        CaseInputs inputs=new CaseInputs();
        String digitString=reader.readLine();
        int[] arr=new int[digitString.length()];
        for(int i=0;i<digitString.length();i++){
            arr[i]=Character.digit(digitString.charAt(i),10);
        }
        inputs.digits=arr;
        return inputs;
    }
    private static void printOutput(int caseNum,CaseOutputs outputs){
        StringBuilder sb=new StringBuilder();
        sb.append("Case #").append(caseNum)
                .append(": ").append(outputs.result);
        System.out.println(sb.toString());
    }

    public static class CaseInputs{

        public int []digits;
    }
    public static class CaseOutputs{

        public String result;
    }
}
