import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public  class Solution {
    public static void main(String[] arg)throws IOException{

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int numCases= Integer.parseInt(reader.readLine());

        for(int i =0;i<numCases;i++){
            CaseInputs inp=readCase(reader);


            CaseOutputs outp=processMatrix(inp);
            printOutput(i+1,outp);
        }
    }

    private static CaseOutputs processMatrix(CaseInputs inputs){
        CaseOutputs outputs=new CaseOutputs();

        int sum=0;
        for(int i=0;i<inputs.size;i++){
            sum+=inputs.matrix[i][i];
        }
        outputs.trace=sum;

        Set<Integer> rowSet;
        Set<Integer> colSet;
        int rowsWithDup=0;
        int colsWithDup=0;
        for(int i=0;i<inputs.size;i++){

            rowSet=new HashSet<>(Arrays.asList(inputs.matrix[i]));
            if(rowSet.size()<inputs.size){
                rowsWithDup++;
            }

            colSet=new HashSet<>();
            for(int z=0;z<inputs.size;z++){
                colSet.add(inputs.matrix[z][i]);
            }
            if(colSet.size()<inputs.size){
                colsWithDup++;
            }
        }

        outputs.rowsWithDup=rowsWithDup;
        outputs.colsWithDup=colsWithDup;




        return outputs;
    }

    private static CaseInputs readCase(BufferedReader reader)throws IOException{
        int matrixSize=Integer.parseInt(reader.readLine());
        CaseInputs inputs=new CaseInputs();
        inputs.matrix=new Integer[matrixSize][matrixSize];
        inputs.size=matrixSize;

        for(int i=0;i<matrixSize;i++){
            String row = reader.readLine();
            String[] words=row.split(" ");
            for(int j=0;j<matrixSize;j++){
                int m=Integer.parseInt(words[j]);
                inputs.matrix[i][j]=m;
            }
        }
        return inputs;
    }
    private static void printOutput(int caseNum,CaseOutputs outputs){
        StringBuilder sb=new StringBuilder();
        sb.append("Case #").append(caseNum)
                .append(": ").append(outputs.trace)
                .append(" ").append(outputs.rowsWithDup)
                .append(" ").append(outputs.colsWithDup);
        System.out.println(sb.toString());
    }

    public static class CaseInputs{

        public int size;
        public Integer[][] matrix;
    }
    public static class CaseOutputs{

        public int trace;
        public int rowsWithDup;
        public int colsWithDup;
    }
}
