import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Vestigium vestigium = new Vestigium();
        Map<Integer, List<List<Integer>>> inputMap = vestigium.readInput();
        vestigium.perform(inputMap);
    }

    /**
     * Read Matrix,
     * Output1 - Trace of matrix
     * Output2 - Duplicates in Rows
     * Output2 - Duplicates in Columns
     *
     * @param inputMap
     */
    private void perform(Map<Integer, List<List<Integer>>> inputMap) {

        Map<Integer,List<Integer>> outputMap = new HashMap<>();
        int outputIdx = 1;
        for(Integer inputKey:inputMap.keySet()){
            List<List<Integer>> inputList = inputMap.get(inputKey);
            List<Integer> outputList = new ArrayList<>();
            outputList.add(getTrace(inputList));
            outputList.add(getRowDuplicates(inputList));
            outputList.add(getColumnDuplicates(inputList));
            System.out.println("Case #" + outputIdx + ": " + outputList.get(0) + " " + outputList.get(1) + " " + outputList.get(2));
            outputMap.put(outputIdx++,outputList);
        }

    }

    private Integer getColumnDuplicates(List<List<Integer>> inputList) {
        int output = 0;
        HashSet<Integer> uniqueSet = new HashSet<>();
        int currentElement=0;
        for(int i=0;i<inputList.size();i++) {
            uniqueSet = new HashSet<>();
            for (int j = 0; j < inputList.size(); j++) {
                currentElement = inputList.get(j).get(i);
                if (uniqueSet.contains(currentElement)) {
                    output++;
                    break;
                }
                uniqueSet.add(currentElement);
            }
        }
        return output;
    }

    private Integer getRowDuplicates(List<List<Integer>> inputList) {
        int output = 0;
        HashSet<Integer> uniqueSet = new HashSet<>();
        int currentElement=0;
        for(int i=0;i<inputList.size();i++) {
            uniqueSet = new HashSet<>();
            for (int j = 0; j < inputList.size(); j++) {
                currentElement = inputList.get(i).get(j);
                if (uniqueSet.contains(currentElement)) {
                    output++;
                    break;
                }
                uniqueSet.add(currentElement);
            }
        }
        return output;
    }

    private Integer getTrace(List<List<Integer>> inputList) {
        int output=0;
        for(int i=0;i<inputList.size();i++){
            output+=inputList.get(i).get(i);
        }
        return output;
    }

    public Map<Integer, List<List<Integer>>> readInput() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        Map<Integer, List<List<Integer>>> inputMap = new
                HashMap<>();
        for (int i = 1; i <= t; ++i) {
            int s = in.nextInt();
            List<List<Integer>> testCaseList = new ArrayList<>();
            for (int j = 0; j < s * s; j=j+s) {
                List<Integer> list = new ArrayList<>();
                int k=0;
                while(in.hasNextInt()){
                     list.add(in.nextInt());
                     if(++k==s){
                         break;
                     }
                }
                testCaseList.add(list);
            }
            inputMap.put(i,testCaseList);
        }
        return inputMap;
    }

    public void writeOutput() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
        }
    }

}
