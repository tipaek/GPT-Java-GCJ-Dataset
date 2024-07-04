import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


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

        StringBuffer sb=new StringBuffer();

        CaseInputs tempLocation=new CaseInputs();
        tempLocation.x=inputs.x;
        tempLocation.y=inputs.y;


        if(bothEven(inputs) || bothOdd(inputs)){
            CaseOutputs outputs=new CaseOutputs();
            outputs.result="IMPOSSIBLE";
            return outputs;
        }
        while(true){
            if(isZero(tempLocation)){
                break;
            }
            if(canDecrementX(tempLocation)){
                sb.append("E");
                tempLocation.x--;
                tempLocation=halve(tempLocation);

            }else if(canIncrementX(tempLocation)){
                sb.append("W");
                tempLocation.x++;
                tempLocation=halve(tempLocation);
            }else if(canDecrementY(tempLocation)){
                sb.append("N");
                tempLocation.y--;
                tempLocation=halve(tempLocation);

            }else if(canIncrementY(tempLocation)){
                sb.append("S");
                tempLocation.y++;
                tempLocation=halve(tempLocation);
            }else{
                CaseOutputs outputs=new CaseOutputs();
                outputs.result="IMPOSSIBLE";
                return outputs;
            }

        }



        CaseOutputs outputs=new CaseOutputs();
        outputs.result=sb.toString();

        return outputs;
    }

    private static CaseInputs readCase(BufferedReader reader)throws IOException{
        CaseInputs inputs=new CaseInputs();
        String[] ints=reader.readLine().split(" ");
        inputs.x=Integer.parseInt(ints[0]);
        inputs.y=Integer.parseInt(ints[1]);

        return inputs;
    }
    private static void printOutput(int caseNum,CaseOutputs outputs){
        StringBuilder sb=new StringBuilder();
        sb.append("Case #").append(caseNum)
                .append(": ").append(outputs.result);
        System.out.println(sb.toString());
    }

    public static class CaseInputs{

        public int x;
        public int y;
    }
    public static class CaseOutputs{

        public String result;
    }
    private static boolean bothOdd(CaseInputs ci){
        return ci.x%2!=0 && ci.y%2!=0;
    }
    private static boolean bothEven(CaseInputs ci){
        return ci.x%2==0 && ci.y%2==0;
    }
    private static CaseInputs halve(CaseInputs ci){
        CaseInputs halved=new CaseInputs();
        halved.x=ci.x/2;
        halved.y=ci.y/2;
        return halved;
    }
    private static boolean isZero(CaseInputs ci){
        return ci.x==0 && ci.y==0;
    }
    private static boolean isChanged(CaseInputs ci1, CaseInputs ci2){
        return ci1.x != ci2.x || ci1.y!=ci2.y;
    }

    private static boolean canIncrementX(CaseInputs ci){
        //true if x is odd and i add 1 to x then divide both by 2, theyre not both odd or both even
        if(ci.x%2==0){
            return false;
        }
        CaseInputs changed=new CaseInputs();
        changed.x=ci.x+1;
        changed.y=ci.y;
        changed=halve(changed);
        return isChanged(ci,changed)&&( isZero(changed) || (!bothOdd(changed) && !bothEven(changed)));
    }

    private static boolean canIncrementY(CaseInputs ci){
        //true if y is odd and i add 1 to y then divide both by 2, theyre not both odd or both even
        if(ci.y%2==0){
            return false;
        }
        CaseInputs changed=new CaseInputs();
        changed.x=ci.x;
        changed.y=ci.y+1;
        changed=halve(changed);
        return isChanged(ci,changed)&&( isZero(changed) || (!bothOdd(changed) && !bothEven(changed)));
    }
    private static boolean canDecrementX(CaseInputs ci){
        //true if x is odd and i subtract 1 from x then divide both by 2, theyre not both odd or both even
        if(ci.x%2==0){
            return false;
        }
        CaseInputs changed=new CaseInputs();
        changed.x=ci.x-1;
        changed.y=ci.y;
        changed=halve(changed);
        return isChanged(ci,changed)&&( isZero(changed) || (!bothOdd(changed) && !bothEven(changed)));
    }
    private static boolean canDecrementY(CaseInputs ci){
        //true if y is odd and  i subtract 1 from y then divide both by 2, theyre not both odd or both even
        if(ci.y%2==0){
            return false;
        }
        CaseInputs changed=new CaseInputs();
        changed.x=ci.x;
        changed.y=ci.y-1;
        changed=halve(changed);
        return isChanged(ci,changed)&&( isZero(changed) || (!bothOdd(changed) && !bothEven(changed)));
    }
}
