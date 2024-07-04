import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static String doingTheJob(int[] asNumbers, String asString, int nestingDepth){
        boolean sendToInsertString = false;
        int startpoint = 0;
        int endpoint = 0;
        boolean startedAlready = false;
        String newString = asString;

        for(int j=0; j<asNumbers.length; j++){
            if(asNumbers[j] > nestingDepth && !startedAlready){
                startpoint = j;
                startedAlready = true;
            }
            else if(asNumbers[j] <= nestingDepth && startedAlready){
                endpoint = j;
                sendToInsertString = true;
            }
            if(asNumbers[j] > nestingDepth && j == asNumbers.length-1){
                endpoint = j+1;
                sendToInsertString = true;
            }
            if(sendToInsertString){

                int[] newAsNumbers1 = new int[endpoint-startpoint];
                int counter1 =0;
                for(int k=startpoint; k<endpoint; k++){
                    newAsNumbers1[counter1] = asNumbers[k];
                    counter1++;
                }
                int[] newAsNumbers2 = new int[asNumbers.length-endpoint];
                int counter2 =0;
                for(int k=endpoint; k<asNumbers.length; k++){
                    newAsNumbers2[counter2] = asNumbers[k];
                    counter2++;
                }

                newString = asString.substring(0, startpoint) + "(" + doingTheJob(newAsNumbers1, asString.substring(startpoint, endpoint), nestingDepth+1) + ")" +
                        doingTheJob(newAsNumbers2, asString.substring(endpoint), nestingDepth);
                break;
            }
        }

        return  newString;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTests = Integer.parseInt(br.readLine());
        for(int i=0; i<numberOfTests; i++){

            String lineInput = br.readLine();
            int[] numbers = new int[lineInput.length()];
            for(int j=0; j<lineInput.length(); j++){
                numbers[j] = Integer.parseInt(String.valueOf(lineInput.charAt(j)));
            }

            //testing
            String toSout = doingTheJob(numbers, lineInput, 0);
            System.out.println("Case #" + (i+1) + ": " + toSout);

        }
        br.close();

    }
}
