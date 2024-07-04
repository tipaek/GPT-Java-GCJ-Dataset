import java.util.Scanner;

class Solution {

    public static void main(String[] args){

        Scanner stdScanner = new Scanner(System.in);
        String[] stream = stdScanner.nextLine().trim().split(" ");
        int testCases = Integer.parseInt(stream[0]);
        int numberOfBits = Integer.parseInt(stream[1]);
        int requests = 0;
        int[] bits;
        int knownBits = 0;
        int requestPostion = 0;
        int leftFound;
        int rightFound;
        while(testCases-- > 0){

            bits = new int[numberOfBits];
            requestPostion = 1;
            requests = 0;
            knownBits = 0;
            leftFound = -1;
            rightFound = numberOfBits;

            while(knownBits < numberOfBits && requests < 150){

                if(requests == 0 || requests%10 != 0){

                    bits[requestPostion-1] = query(stdScanner, requestPostion);
                    requests++;
                    knownBits++;
                    if(requestPostion <= numberOfBits/2){

                        leftFound = requestPostion;
                        requestPostion = numberOfBits - requestPostion + 1;
                    }
                    else{
                        rightFound = requestPostion;
                        requestPostion = numberOfBits - requestPostion + 2;
                    }
                }
                else{

                    boolean isMirror = isMirror(bits, leftFound, rightFound);
                    boolean isComplement = isComplement(bits, leftFound, rightFound);
                    if(isMirror || isComplement){

                        int bit = query(stdScanner, 1);
                        if(bit != bits[0]){

                            complement(bits);
                        }
                        bit = query(stdScanner, 1);
                    }
                    else{

                        int mirrorPosition = getMirrorBitPosition(bits, leftFound);
                        int complementPosition = getComplementBitPosition(bits, leftFound);
                        int bit0 = query(stdScanner, mirrorPosition+1);
                        int bit1 = query(stdScanner, complementPosition+1);
                        if(bit0 == bits[mirrorPosition]){

                            if(bit1 != bits[complementPosition]){

                                reverse(bits);
                            }
                        }
                        else{

                            if(bit1 == bits[complementPosition]){
                                reverse(bits);
                            }
                            complement(bits);
                        }
                    }

                    requests +=2;
                }
            }

            StringBuilder out = new StringBuilder("");
            for(int i = 0 ; i < numberOfBits ; i++){
                out.append(bits[i]);
            }
            System.out.println(out);
            String in = stdScanner.nextLine().trim();
            if(in.equals("N")){
                break;
            }
        }
    }

    private static int getMirrorBitPosition(int[] bits, int leftFound) {

        for(int i = 0 ; i < leftFound; i++){

            if(bits[i] == bits[bits.length - i -1]){
                return i;
            }
        }
        return -1;
    }

    private static int getComplementBitPosition(int[] bits, int leftFound) {

        for(int i = 0 ; i < leftFound; i++){

            if(bits[i] == 1 - bits[bits.length - i -1]){
                return i;
            }
        }
        return -1;
    }

    private static int query(Scanner stdScanner, int requestPostion) {
        System.out.println(requestPostion);
        return Integer.parseInt(stdScanner.nextLine().trim());
    }

    static boolean isMirror(int[] bits, int leftFound, int rightFound){

        boolean ans = true;
        for(int i = 0 ; i< leftFound; i++){

            ans = ans && (bits[i] == bits[bits.length - i -1]);
        }
        return ans;
    }

    static boolean isComplement(int[] bits, int leftFound, int rightFound){

        boolean ans = true;
        for(int i = 0 ; i< leftFound; i++){

            ans = ans && (bits[i] == 1 - bits[bits.length - i -1]);
        }
        return ans;
    }

    static void complement(int[] bits){

        for(int i = 0 ; i < bits.length ; i++){

            bits[i] = 1 - bits[i];
        }
    }

    static void reverse(int[] bits){

        for(int i = 0 ; i < bits.length/2 ; i++){

            int temp = bits[i];
            bits[i] = bits[bits.length - i -1];
            bits[bits.length - i -1] = temp;
        }
    }
}
