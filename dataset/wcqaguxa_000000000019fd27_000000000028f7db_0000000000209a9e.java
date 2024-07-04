import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        //read in values
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        int length = scanner.nextInt();

        //iteration over test cases
        for (int i = 1; i <= cases; i++) {
            //create collection of bits to discover
            BitsArray bits = new BitsArray(length);

            int indexOfSame = -1;
            int indexOfDiff = -1;
            boolean found = false;
            int queryIndex = 1;
            int discoverIndex = 0;
            while(!found) {
                //if it's time to evaluate
                if((queryIndex -1) >=10 && (queryIndex -1) % 10 ==0) {
                    boolean evenChanged = false;

                    //if same-valued elements changed, set evenchanged to true
                    if (indexOfSame >= 0) {
                        boolean value = getBit(indexOfSame+1, scanner);
                        if (value  != bits.getValue(indexOfSame)) { evenChanged = true; }
                    } else { getBit(1, scanner); }

                    //if different-valued elements changed, make changes in code
                    if (indexOfDiff >= 0) {
                        boolean value = getBit(indexOfDiff+1, scanner);
                        //its either reverse or complement
                        if (value != bits.getValue(indexOfDiff)) {
                            if (evenChanged) {
                                bits.complement();
                            } else { bits.reverse(); }
                        } else {
                            //nothing changed or it's both actions
                            if (evenChanged) { bits.complementAndReverse(); }
                        }
                    } else {
                        getBit(1, scanner);
                        if (evenChanged) { bits.complementAndReverse(); }
                    }
                } else {
                    //retrieve bits from start and end, set their values
                   Bit start =  bits.get(discoverIndex);
                   start.setValue(getBit(discoverIndex+1, scanner));
                   Bit end =  bits.get(length - discoverIndex-1);
                   end.setValue(getBit(length - discoverIndex, scanner));

                   //assign relation to bit on opposit side of the array
                   if (start.getValue() == end.getValue()) {
                       start.setNeighbor(Neighbor.SAME);
                       end.setNeighbor(Neighbor.SAME);
                       if (indexOfSame < 0) { indexOfSame = discoverIndex; }
                   } else {
                       start.setNeighbor(Neighbor.DIFF);
                       end.setNeighbor(Neighbor.DIFF);
                       if (indexOfDiff < 0) { indexOfDiff = discoverIndex; }
                   }
                   discoverIndex++;
                   //System.err.print("dI:"+discoverIndex+" cV: "+((length/2)));
                   if (discoverIndex == length/2) {found = true; }
                }
                queryIndex+=2;
            }
            //asssumes it's found. print out th
            bits.print();
            String judge = scanner.nextLine();
            if(judge.equals("N")) {
                return;
            }
        }
    }

    static boolean getBit(int index, Scanner scanner) {
        System.out.println(index);
        System.out.flush();
        int result = scanner.nextInt();
        if (result == 0) {
            return false;
        }
        return true;
    }

}

class BitsArray {
    ArrayList<Bit> bits;
    int size;

    BitsArray(int size){
        this.size = size;
        bits = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bits.add(new Bit());
        }
    }

    boolean getValue(int index) {
        return bits.get(index).getValue();
    }

    Bit get(int index) {
        return bits.get(index);
    }

    void reverse() {
        for(int i = 0; i < size; i++) {
            if (bits.get(i).isFound()) {
                bits.get(i).reverse();
            }
        }
    }

    void complement() {
        for(int i = 0; i < size; i++) {
            if (bits.get(i).isFound()) {
                bits.get(i).complement();
            }
        }
    }

    void complementAndReverse() {
        for(int i = 0; i < size; i++) {
            if (bits.get(i).isFound()) {
                bits.get(i).complementAndReverse();
            }
        }
    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(bits.get(i).getIntValue());
        }
        System.out.print('\n');
    }
}



class Bit{
    boolean value;
    boolean found;
    Neighbor neighbor;

    Bit() {
        this.found = false;
        this.neighbor = Neighbor.UNDISCOVERED;
    }

    void setValue(boolean value) {
        this.found = true;
        this.value = value;
    }

    boolean getValue() {
        return value;
    }

    int getIntValue() {
        if (value) { return 1; }
        return 0;
    }

    boolean isFound() {
        return found;
    }

    void setNeighbor(Neighbor n) {
        this.neighbor = n;
    }

    void complement() {
        value = !value;
    }

    void reverse() {
        if (neighbor == Neighbor.DIFF) {
            value = !value;
        }
    }

    void complementAndReverse() {
        if (neighbor == Neighbor.SAME) {
            value = !value;
        }
    }


}

enum Neighbor {
    SAME,
    DIFF,
    UNDISCOVERED
}

