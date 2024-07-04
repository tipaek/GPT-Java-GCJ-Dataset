import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        String[] x = s.nextLine().split(" ");
        int T= Integer.parseInt(x[0]);
        int B=Integer.parseInt(x[1]);
        while(true){
            startNewOne(s,B);
        }
    }

    public static int startNewOne(Scanner s, int n /* n = B */) {
        int questionCount=1;
        int[] original = new int[n];
        int max = (n/2)-1;
        int min = n/2;
        boolean solved=false;

        // todo: read in a loop
        boolean readmin=false;
        while(!solved) {
            if (questionCount != 1 && questionCount % 10 == 1) {
                int[] reversed = reverse(original);
                int[] complementArray = complement(original);
                int[] both = complement(reversed);
                int nleft = 4;
                for (; nleft > 1; ) {
                    int index = indexToUse(max, min, original, reversed, complementArray, both);
                    if (index != -1) {
                        questionCount += 1;
                        int eleven = readValue(s, index);
                        if (original != null && original[index] != eleven) {
                            original = null;
                            nleft -= 1;
                        }
                        if (reversed != null && reversed[index] != eleven) {
                            reversed = null;
                            nleft -= 1;
                        }
                        if (complementArray != null && complementArray[index] != eleven) {
                            complementArray = null;
                            nleft -= 1;
                        }
                        if (both != null && both[index] != eleven) {
                            both = null;
                            nleft -= 1;
                        }
                    } else {
                        break;
                    }
                }
                if (reversed != null) {
                    original = reversed;
                }
                if (complementArray != null) {
                    original = complementArray;
                }
                if (both != null) {
                    original = both;
                }
            }
            // did we solve the problem?
            if(min==0 && max==n-1){
                solved=true;
            } else {
                if(readmin){
                    min-=1;
                    original[min]=readValue(s,min);
                    readmin=false;
                } else {
                    max+=1;
                    original[max]=readValue(s,max);
                    readmin=true;
                }
                questionCount+=1;
            }
        }
        String ret="";
        for(int i:original){
            ret+=i;
        }
        //System.err.println("questionCount " + questionCount);
        System.out.println(ret);
        String val = s.nextLine();
        questionCount+=1;
        if(val.equals("N")){
            System.exit(0);
        }
        return questionCount;
    }
    public static int readValue(Scanner s, int index){
        System.out.println(index+1);
        String val = s.nextLine();
        if(val.equals("Y")){
            return 2;
        }
        else if(val.equals("N")){
            System.exit(0);
        }
        return Integer.parseInt(val);
    }
    public static int indexToUse(int startIndex, int minIndex, int[] original, int[] reversed, int[] complementArray, int[] both){
        if(startIndex < minIndex){
            return -1;
        }
        int howmany=0;
        int sum=0;
        if(original!=null){
            howmany+=1;
            sum+=original[startIndex];
        }
        if(reversed!=null){
            howmany+=1;
            sum+=reversed[startIndex];
        }
        if(complementArray!=null){
            howmany+=1;
            sum+=complementArray[startIndex];
        }
        if(both!=null){
            howmany+=1;
            sum+=both[startIndex];
        }

        // howmany  sum
        if(sum == 0 || sum == howmany){
            return indexToUse(startIndex-1, minIndex, original, reversed, complementArray, both);
        }
        return startIndex;
    }
    public static int[] reverse(int[] nums){
        int[] ret = new int[nums.length];
        for(int i = 0, j = nums.length-1; i < nums.length/2; i++, j--){
            ret[i] = nums[j];
            ret[j] = nums[i];
        }
        return ret;
    }
    public static int[] complement(int[] nums){
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                ret[i] = 1;
            }
            else{
                ret[i] = 0;
            }
        }
        return ret;
    }
}
