import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int B = s.nextInt();
        for (int i = 0; i < T; i++) {
            boolean[] bitArray = new boolean[B + 1];
            Stack<DataStatus> ds = new Stack<>();
            int query = 0;
            int index = 1;
            int sameIndex = -1, diffIndex = -1;
            boolean same = false, diff = false, prevDiff = false;
            int complement = 0;
            int exchange = 0;
            while (query < 150 && index < (B / 2) + 1) {
                System.out.println(index);
                query++;
                boolean left = s.nextInt() == 1;
                bitArray[index] = left;
                query++;
                System.out.println(B + 1 - index);
                boolean right = s.nextInt() == 1;
                bitArray[B + 1 - index] = right;
                if (sameIndex == -1 && left == right) {
                    sameIndex = index;
                    same = left;
                } else if (diffIndex == -1 && left != right) {
                    diffIndex = index;
                    diff = left;
                }
                index++;
                if (query % 10 == 0) {
                    if (sameIndex != -1) {
                        System.out.println(sameIndex);
                        query++;
                        boolean newSame = s.nextInt() == 1;
                        if (same != newSame) {
                            complement++;
                            same = newSame;
                            if (diffIndex != -1) {
                                System.out.println(diffIndex);
                                query++;
                                boolean newDiff = s.nextInt() == 1;
                                if (diff == newDiff) {
                                    exchange++;
                                }
                            }
                        } else {
                            if (diffIndex != -1) {
                                System.out.println(diffIndex);
                                query++;
                                boolean newDiff = s.nextInt() == 1;
                                if (diff != newDiff) {
                                    exchange++;
                                    diff = newDiff;
                                }
                            }
                        }
                    }else{
                        System.out.println(diffIndex);
                        query++;
                        boolean newDiff = s.nextInt() ==1;
                        if (newDiff != diff){
                            complement++;
                            diff = newDiff;
                        }
                    }
                    if (query %10 ==1){
                        System.out.println(1);
                        s.nextInt();
                    }
                    ds.push(new DataStatus(complement, exchange));
                }

            }
            int counter = 1;
            DataStatus d = ds.pop();
            while (counter <= 5){
                if (d.complement/2 == 1){
                    bitArray[counter] = !bitArray[counter];
                    bitArray[B+1-counter] = !bitArray[B+1-counter];
                }
                if(d.exchange/2 == 1){
                    boolean temp = bitArray[counter];
                    bitArray[counter] = bitArray[B+1-counter];
                    bitArray[B+1-counter] = temp;
                }
                counter++;
            }
            while (counter <= B/2 && ds.size() != 0){
                DataStatus dataStatus = ds.pop();
                for (int j = 1; j < 5 && counter <= B/2; j++) {
                    if (dataStatus.complement/2 == 1){
                        bitArray[counter] = !bitArray[counter];
                        bitArray[B+1-counter] = !bitArray[B+1-counter];
                    }
                    if(dataStatus.exchange/2 == 1){
                        boolean temp = bitArray[counter];
                        bitArray[counter] = bitArray[B+1-counter];
                        bitArray[B+1-counter] = temp;
                    }
                    counter++;
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j < B+1; j++) {
                if (bitArray[j]){
                    stringBuilder.append(1);
                }else {
                    stringBuilder.append(0);
                }
            }
            System.out.println(stringBuilder.toString());

        }
    }
}

class DataStatus {
    int complement;
    int exchange;

    DataStatus(int complement, int exchange){
        this.complement = complement;
        this.exchange = exchange;
    }
}
