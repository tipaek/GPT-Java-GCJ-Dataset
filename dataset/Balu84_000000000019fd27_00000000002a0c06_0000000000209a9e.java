import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Solution {
    private static final int MAX_QUERIES = 150;
    private static final byte ONE = 1;
    private static final String ONE_STR = "1";
    private static final byte ZERO = 0;
    private static final String ERROR = "N";
    private static final String OK_SOLUTION = "Y";
    private static final String NULL = "?";
    private static final byte NULL_BYTE = -1;
    private static final int QUANTUM_FLUCTUATION_PERIOD = 10;
    
    private static final class Bit {
        public final byte BIT_VALUE;
        public final int NUMBER_OF_THIS_QUERY;
        public final int POSITION;
        public boolean doesNeedToFluctuate;
        
        /**
         * 
         * @param position
         * @param value
         * @param numberOfQuery 
         */
        public Bit(int position, byte value, int numberOfQuery) {
            POSITION = position;
            BIT_VALUE = value;
            NUMBER_OF_THIS_QUERY = numberOfQuery;
            doesNeedToFluctuate = false;
        }
        
        public boolean wasThisQueryFluctuated() {
            return (NUMBER_OF_THIS_QUERY % QUANTUM_FLUCTUATION_PERIOD == 1);
        }
        
        @Override
        public String toString() {
            return "Bit{" + "BIT_VALUE=" + BIT_VALUE + ", NUMBER_OF_THIS_QUERY=" + NUMBER_OF_THIS_QUERY + ", POSITION=" + POSITION + '}';
        }
    }
    
    private static enum QuantumFluctoation {
        COMPLEMENTED,
        REVERSED,
        COMPLEMENTED_AND_REVERSED,
        NOTHING,
        UNKNOWN
    }
    
    private static final class TooManyQueriesException extends RuntimeException {
        //
    }
    
    private static final class MalformedQueryException extends RuntimeException {
        //
    }
    
    private static class Database {
        public final int B; //size of the bit array for every test case
        private int numberOfQueries;
        private Scanner input;
        
        public Database(int bitSizeOfArrays, Scanner input) {
            numberOfQueries = 0;
            B = bitSizeOfArrays;
            this.input = input;
        }
        
        /**
        * Method to query the value at the given position.
        * 
        * @param position between 1 and B
        * @return 
        */
        public Bit query(int position) {
            increaseNumberOfQueries();
            if(MAX_QUERIES < getNumberOfQueries()) {
                throw new TooManyQueriesException();
            }
            System.out.println(position); //flush is called automatically
            String judgeResponse = input.next().trim();
            if(ERROR.equals(judgeResponse)) {
                throw new MalformedQueryException();
            }
            byte answer = (byte) Integer.parseInt(judgeResponse);
            return new Bit(position, answer, getNumberOfQueries());
        }
        
        /**
         * Checks the response of the judge for our guess of the solution for the current array content.
         * 
         * @param solution
         * @return 
         */
        public String getResponseForSolution(String solution) {
            return input.next().trim();
        }
        
        public void increaseNumberOfQueries() {
            numberOfQueries += 1;
        }

        public int getNumberOfQueries() {
            return numberOfQueries;
        }

        public Scanner getInput() {
            return input;
        }
    }
    
    private static final class MockedDatabase extends Database {
        private final byte[] ORIGINAL_ARRAY;
        private byte[] array;
        
        public MockedDatabase(int bitSizeOfArrays, Scanner input) {
            super(bitSizeOfArrays, input);
            ORIGINAL_ARRAY = generateTestArray(super.B);
            array = Arrays.copyOf(ORIGINAL_ARRAY, ORIGINAL_ARRAY.length);
            testPrint(Arrays.toString(array) + " : original\n");
            //testPrint(Arrays.toString(complement(Arrays.copyOf(array, array.length))) + " : complemented");
            //testPrint(Arrays.toString(reverse(Arrays.copyOf(array, array.length))) + " : reversed");
            //testPrint(Arrays.toString(complementAndReverse(Arrays.copyOf(array, array.length))) + " : complemented and reversed");
            //testPrint(Arrays.toString(doNothing(Arrays.copyOf(array, array.length))) + " : did nothing");
        }
        
        /**
        * Helper test method to query the array for a position and get back the value from there. The random quantum fluctuation can occur as described in the rules.
        * 
        * @param position
        * @return 
        */
        @Override
        public Bit query(int position) {
            increaseNumberOfQueries();
            if(MAX_QUERIES < getNumberOfQueries()) {
                throw new TooManyQueriesException();
            }
            testPrint("Query at position:" + position + ", number of queries: " + getNumberOfQueries());
            byte[] newArray = array;
            if(getNumberOfQueries() % QUANTUM_FLUCTUATION_PERIOD == 1) {
                newArray = quantumFluctuation(array);
                testPrint("original:\n" + Arrays.toString(array) + "\nfluctuated:");
            }
            testPrint(Arrays.toString(newArray));
            array = newArray;
            if(position < 1 || B < position) {
                throw new MalformedQueryException();
            }
            return new Bit(position, newArray[position-1], getNumberOfQueries());
        }
        
        /**
         * Test method to check our given solution for the current array content if we guessed right.
         * 
         * @param solution
         * @return 
         */
        @Override
        public String getResponseForSolution(String solution) {
            StringBuilder sb = new StringBuilder();
            for(byte bit : array) {
                sb.append(bit);
            }
            testPrint(solution + " : solution\n" + sb.toString() + " : current array");
            if(sb.toString().equals(solution)) {
                return OK_SOLUTION;
            }
            return ERROR;
        }
       
        public byte[] getCurrentArray() {
            return array;
        }
        public byte[] getOriginalArray() {
            return ORIGINAL_ARRAY;
        }
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt(); //number of test cases
        int B = input.nextInt(); //size of the bit array for every test case
        try {
            for (int testCase = 1; testCase <= T; testCase++) {
                Bit[] solution = new Bit[B];
                Bit[] previousSolution = null; //after every fluctuation we store the previous iteration as history reference
                Database db = new Database(B, input);
                //Database db = new MockedDatabase(B, input);
                int positionAtStart = 1; //between 1 and B
                int positionAtEnd = B; //between 1 and B
                int iterations = MAX_QUERIES / QUANTUM_FLUCTUATION_PERIOD; //15
                for(int tries=0; tries<iterations+1; tries++) { //we iterate more than allowed to catch an exception and force us to guess
                    for(int i=0; i<QUANTUM_FLUCTUATION_PERIOD; i++) {
                        Bit currentBit = null;
                        if(i%2 == 0) { //at every step we change which end of the array we want to query
                            currentBit = db.query(positionAtStart); //every time this for cyclus starts, the array will be fluctuated
                            solution[positionAtStart - 1] = currentBit;
                            positionAtStart++;
                        }
                        else {
                            currentBit = db.query(positionAtEnd);
                            solution[positionAtEnd - 1] = currentBit;
                            positionAtEnd--;
                        }
                        //String currentSolution = getSolution(solution);
                        //testPrint(currentSolution);
                        if(previousSolution != null) {
                            //if this is not the first fluctuation, we need to try to guess exactly what happened
                            QuantumFluctoation guess = guessFluctuation(solution, previousSolution);
                            if(guess != null && guess != QuantumFluctoation.UNKNOWN) {
                                //we found which kind of fluctuation happened, we can drop the previous history and execute this fluctuation on the current list
                                previousSolution = null;
                                for(int b=0; b<solution.length; b++) {
                                    Bit bit = solution[b];
                                    if(bit != null && bit.doesNeedToFluctuate) {
                                        switch(guess) {
                                            case COMPLEMENTED: {
                                                byte newBitValue = complement(bit);
                                                solution[b] = new Bit(bit.POSITION, newBitValue, bit.NUMBER_OF_THIS_QUERY);
                                                break;
                                            }
                                            case REVERSED: {
                                                Bit bitToUse = solution[solution.length - 1 - b];
                                                solution[solution.length - 1 - b] = solution[b];
                                                solution[solution.length - 1 - b].doesNeedToFluctuate = false;
                                                solution[b] = bitToUse;
                                                solution[b].doesNeedToFluctuate = false;
                                                break;
                                            }
                                            case COMPLEMENTED_AND_REVERSED: {
                                                //complement both values
                                                byte newBitValue = complement(bit);
                                                solution[b] = new Bit(bit.POSITION, newBitValue, bit.NUMBER_OF_THIS_QUERY);
                                                bit = solution[solution.length - 1 - b];
                                                newBitValue = complement(bit);
                                                solution[solution.length - 1 - b] = new Bit(bit.POSITION, newBitValue, bit.NUMBER_OF_THIS_QUERY);
                                                //reverse both values
                                                Bit bitToUse = solution[solution.length - 1 - b];
                                                solution[solution.length - 1 - b] = solution[b];
                                                solution[b] = bitToUse;
                                                //fluctuation indicator is set to false already by both because of the constructor
                                                break;
                                            }
                                            case NOTHING: {
                                                solution[b].doesNeedToFluctuate = false;
                                                break;
                                            }
                                            default: {
                                                break;
                                            }
                                        }
                                        //solution[b].doesNeedToFluctuate = false; //constructor sets it to false
                                    }
                                } //end of executing the previous fluctuation on the current solution
                                //let's find the positions where to continue the queries from
                                for(int b=0; b<solution.length; b++) {
                                    Bit bit = solution[b];
                                    if(bit == null || bit.BIT_VALUE == NULL_BYTE) {
                                        positionAtStart = b + 1;
                                        break;
                                    }
                                }
                                for(int b=solution.length-1; 0<=b; b--) {
                                    Bit bit = solution[b];
                                    if(bit == null || bit.BIT_VALUE == NULL_BYTE) {
                                        positionAtEnd = b + 1;
                                        break;
                                    }
                                }
                            } //fluctuation could be guessed if condition's end
                        } //previousSolution was not null if condition's end
                    } //end of quantum fluctuation's period for cyclus
                    String currentSolution = getSolution(solution);
                    testPrint(currentSolution);
                    if(!currentSolution.contains(NULL)) {
                        //if there are no unknown bits any longer and we are still here before the next fluctioation, we are done
                        System.out.println(currentSolution);
                        //check answer of judge
                        String judgeResponse = db.getResponseForSolution(currentSolution);
                        if(ERROR.equals(judgeResponse)) {
                            throw new MalformedQueryException();
                        }
                        else if(OK_SOLUTION.equals(judgeResponse)) {
                            tries = iterations;
                        }
                    }
                    else {
                        //we dont know all of the bits yet, and the next iteration will fluctuate the array
                        for(Bit bit : solution) {
                            if(bit != null) {
                                bit.doesNeedToFluctuate = true;
                            }
                        }
                        previousSolution = Arrays.copyOf(solution, solution.length); //we make a copy of the current state
                        //we set back the position indicators to the both end of the array. We need to query them again to figure out what was the fluctuation
                        positionAtStart = 1;
                        positionAtEnd = B;
                    }
                }
            }
        }
        catch(MalformedQueryException e) {
            ;// judge system does not send any response any longer, we need to terminate to see the warning and not get timeout exception instead
        }
        catch(TooManyQueriesException e) {
            //we could not guess the array in 150 queries, we need to guess
            
        }
    }
    
    /**
     * Helper method to convert the current solution into string and compare that with every different fluctuation of the previous solution as string.
     * If there is only one fluctuation to get the same strings, then we figured out what happened.
     * 
     * @param solution
     * @param previousSolution
     * @return 
     */
    private static QuantumFluctoation guessFluctuation(Bit[] solution, Bit[] previousSolution) {
        String currentSolution = getSolution(solution);
        String prevSolution = getSolution(previousSolution);
        byte[] previousSolutionBytes = convertStringSolution(prevSolution);
        String prevSolComplemented = getSolution(complement(Arrays.copyOf(previousSolutionBytes, previousSolutionBytes.length)));
        String prevSolreversed = getSolution(reverse(Arrays.copyOf(previousSolutionBytes, previousSolutionBytes.length)));
        String prevSolComplementedAndReversed = getSolution(complementAndReverse(Arrays.copyOf(previousSolutionBytes, previousSolutionBytes.length)));
        List<QuantumFluctoation> guesses = new ArrayList();
        if(currentSolution.equals(prevSolComplemented)) {
            guesses.add(QuantumFluctoation.COMPLEMENTED);
        }
        if(currentSolution.equals(prevSolreversed)) {
            guesses.add(QuantumFluctoation.REVERSED);
        }
        if(currentSolution.equals(prevSolComplementedAndReversed)) {
            guesses.add(QuantumFluctoation.COMPLEMENTED_AND_REVERSED);
        }
        if(currentSolution.equals(prevSolution)) {
            guesses.add(QuantumFluctoation.NOTHING);
        }
        return (guesses.size() == 1) ? guesses.get(0) : QuantumFluctoation.UNKNOWN;
    }
    
    /**
     * Helper method to convert a solution string like "0010????1100" into its corresponding byte array with NULL_BYTE=-1 where questionmark was.
     * 
     * @param solutionStr
     * @return 
     */
    private static byte[] convertStringSolution(String solutionStr) {
        byte[] solution = new byte[solutionStr.length()];
        for(int i=0; i<solutionStr.length(); i++) {
            String bit = solutionStr.substring(i, i+1);
            if(NULL.equals(bit)) {
                solution[i] = NULL_BYTE;
            }
            else if(ONE_STR.equals(bit)) {
                solution[i] = ONE;
            }
            else {
                solution[i] = ZERO;
            }
        }
        return solution;
    }
    
    /**
     * Helper method to return our current solution with probably some unknown bits still. E.g.: "0011???1011"
     * 
     * @param solution 
     */
    private static String getSolution(Bit[] solution) {
        StringBuilder sb = new StringBuilder();
        for(Bit bit : solution) {
            sb.append((bit == null || bit.BIT_VALUE == NULL_BYTE) ? NULL : bit.BIT_VALUE);
        }
        return sb.toString();
    }
    
    /**
     * Helper method to return our current solution with probably some unknown bits still. E.g.: "0011???1011"
     * 
     * @param solution 
     */
    private static String getSolution(byte[] solution) {
        StringBuilder sb = new StringBuilder();
        for(byte bit : solution) {
            sb.append((bit == NULL_BYTE) ? NULL : bit);
        }
        return sb.toString();
    }
    
    /**
     * Helper test method to cause fluctuation
     * @param originalArray
     * @return 
     */
    private static byte[] quantumFluctuation(byte[] originalArray) {
        byte[] array = Arrays.copyOf(originalArray, originalArray.length);
        long event = Math.round(Math.random() * 100);
        if(event < 25) {
            testPrint("complement");
            return complement(array);
        }
        else if(event < 50) {
            testPrint("reverse");
            return reverse(array);
        }
        else if(event < 75) {
            testPrint("complementAndReverse");
            return complementAndReverse(array);
        }
        else {
            testPrint("doNothing");
            return doNothing(array);
        }
    }
    
    /**
     * Helper method for testing to return a random bit array of the given size.
     * 
     * @param size
     * @return 
     */
    private static byte[] generateTestArray(int size) {
        byte[] array = new byte[size];
        for(int i=0; i<size; i++) {
            array[i] = (byte) Math.round(Math.random());
        }
        return array;
        //return new byte[]{0,0,0,1,1,0,1,1,1,1};
    }
    
    /**
     * Helper test method to complement the given array, that is to make from each 1 bit to a 0 and vica versa.
     * 
     * @param array
     * @return 
     */
    private static byte[] complement(byte[] array) {
        for(int i=0; i<array.length; i++) {
            if(array[i] == NULL_BYTE) {
                continue;
            }
            array[i] = (array[i] == ZERO) ? ONE : ZERO;
        }
        return array;
    }
    
    /**
     * Helper method to return the complement of this bit.
     * 
     * @param bit
     * @return 
     */
    private static byte complement(Bit bit) {
        if(bit.BIT_VALUE == NULL_BYTE) {
            return NULL_BYTE;
        }
        else if(bit.BIT_VALUE == ONE) {
            return ZERO;
        }
        return ONE;
    }
    
    /**
     * Helper test method to reverse the given array.
     * 
     * @param array
     * @return 
     */
    private static byte[] reverse(byte[] array) {
        final int HALF_OF_ARRAY = array.length / 2; //int rounds down
        for(int i=0; i<HALF_OF_ARRAY; i++) {
            byte temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
    
    /**
     * Helper test method to complement the given array, that is to make from each 1 bit to a 0 and vica versa, and then to reverse it.
     * (complement+reverse = reverse+complement)
     * 
     * @param array
     * @return 
     */
    private static byte[] complementAndReverse(byte[] array) {
        byte[] temp = complement(array);
        temp = reverse(temp);
        return temp;
    }
    
    /**
     * Helper test method to simulate the 4th case, when nothing happens to the array.
     * 
     * @param array
     * @return 
     */
    private static byte[] doNothing(byte[] array) {
        return array;
    }
    
    /**
     * Helper test method for printing debug messages, which can be turned off easily only changing this 1 line here not to do anything.
     * 
     * @param array 
     */
    private static void testPrint(String str) {
        //System.err.println(str);
    }
}