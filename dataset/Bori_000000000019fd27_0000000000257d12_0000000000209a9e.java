import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Solution {

    static void findBitsInInterval(char[] bits, int start, int end, Scanner scanner){
        for(int i=start; i<=end; i++){
            System.out.println(i);
            System.out.flush();
            bits[i] = scanner.next().charAt(0);
        }
    }

    static int findMirroredBit(char bits[],int start1,  int end1, int start2, int end2){
        for(int i=start1; i<=end1; i++){
            if(bits[i]==bits[end2-(i-start1)]) return i;
        }
        return -1;
    }

    static int findUNMirroredBit(char bits[],int start1,  int end1, int start2, int end2){
        for(int i=start1; i<=end1; i++){
            if(bits[i]!=bits[end2-(i-start1)]) return i;
        }
        return -1;
    }

    static void reverseArray(char[] bits, int size, int knownNr){
        for(int i=1; i<=knownNr; i++){ //swap
            char helper = bits[i];
            bits[i] = bits[size-i+1];
            bits[size-i+1] = helper;
        }
    }

    static char complementOf(char c){
        if(c=='0') return '1';
        else return '0';
    }

    static void complementArray(char[] bits, int size, int knownNr){
        for(int i=1; i<=knownNr; i++){ //swap
            bits[i] = complementOf(bits[i]);
            bits[size-i+1] = complementOf(bits[size-i+1]);
        }
    }

    static char findBit(int pos, Scanner scanner){
        System.out.println(pos);
        System.out.flush();
        return scanner.next().charAt(0);
    }

    static void performNeededOperations(char[] bits, int size, int knownNr, int mirroredBit, int unMirroredBit, Scanner scanner){
        if(mirroredBit>0 && unMirroredBit>0){
            char newMirrored = findBit(mirroredBit, scanner);
            char newUnMirrored =  findBit(unMirroredBit, scanner);
            if(newMirrored!=bits[mirroredBit]){
                if(newUnMirrored==bits[unMirroredBit]){
                    reverseArray(bits, size, knownNr);
                    complementArray(bits, size, knownNr);
                }
                else{
                    complementArray(bits, size, knownNr);
                }
            }
            else{
                if(newUnMirrored!=bits[unMirroredBit]){
                    reverseArray(bits, size, knownNr);
                }
            }
        }
        else if(mirroredBit>0){ //all the bits are mirrored
            char newMirrored = findBit(mirroredBit, scanner);
            findBit(mirroredBit, scanner);//only two perform the same nr of check all the time
            if(newMirrored!=bits[mirroredBit]){
                complementArray(bits, size, knownNr);
            }
        }
        else //no bits are mirrored
        {
            char newUnMirrored = findBit(unMirroredBit, scanner);
            findBit(unMirroredBit, scanner);
            if(newUnMirrored!=bits[unMirroredBit]){
                reverseArray(bits, size, knownNr);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //File inFile = new File("data.in");
        Scanner input = new Scanner(System.in);
        int noTests = input.nextInt();
        int noBits = input.nextInt();
        char feedback;
        boolean exit = false;
        if(noBits==10) {
            char[] bits = new char[11];
            for (int t = 1; t <= noTests && !exit; t++) {
                for(int i=1; i<=noBits; i++){//10 queries
                    System.out.println(i);
                    bits[i] = input.next().charAt(0);
                }
                System.out.println(String.valueOf(bits, 1, 10));
                feedback = input.next().charAt(0);
                if(feedback=='N'){
                    exit = true;
                }
            }
        }
        else if(noBits==20){
            char[] bits = new char[21];
            int mirroredBit, unMirroredBit;
            for(int t=1; t<=noTests && !exit; t++){
                //find bits 1-5 and 16-20
                findBitsInInterval(bits, 1, 5, input);
                findBitsInInterval(bits, 16, 20, input); //10 queries

                mirroredBit = findMirroredBit(bits, 1, 5, 16, 20);
                unMirroredBit = findUNMirroredBit(bits, 1, 5, 16, 20);

                performNeededOperations(bits, 20, 5, mirroredBit, unMirroredBit, input); //query nr 11, 12

                findBitsInInterval(bits, 6, 9, input);
                findBitsInInterval(bits, 12, 15, input); //queries until 20

                mirroredBit = findMirroredBit(bits, 1, 9, 11, 20);
                unMirroredBit = findUNMirroredBit(bits, 1, 9, 12, 20);

                performNeededOperations(bits, 20, 9, mirroredBit, unMirroredBit, input); //queres 21, 22

               findBitsInInterval(bits, 10, 11, input); //queries 23, 24

                System.out.println(String.valueOf(bits, 1, 20));

                feedback = input.next().charAt(0);
                if(feedback=='N'){
                    exit = true;
                }

            }
        }
    }
}


