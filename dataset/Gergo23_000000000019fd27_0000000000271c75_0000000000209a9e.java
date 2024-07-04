import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    public static int querries = 0;
    public static int indexOfDiffBits = -1;
    public static int indexOfEQBits = -1;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for(int ks = 1; ks <= T; ks++) {
            solve(B, input);
        }
    }
    
    
    public static void solve(int bitCount, Scanner input) {
        int[] bits = new int[bitCount];
        Arrays.fill(bits, 0);
        querries = 0;
        int cOfRounds = 0;
        if(bitCount == 10) {
            cOfRounds = 1;
        } else if(bitCount == 20) {
            cOfRounds = 3;
        } else if(bitCount == 100) {
            cOfRounds = 13;
        }
        
        
        for(int i = 0; i < cOfRounds; i++) {
            if(i != 0) {
                //guess magic
                
                int mDiff = -1;
                int mEQ = -1;
                // different bits
                if(indexOfDiffBits != -1) {
                    int front = querry(input, indexOfDiffBits + 1);
                    mDiff = front == bits[indexOfDiffBits] ? 2 : 1;
                } else {
                    querry(input, 1);
                }
                //equal bits
                if(indexOfEQBits != -1) {
                    int front = querry(input, indexOfEQBits + 1);
                    mEQ = front == bits[indexOfEQBits] ? 2 : 1;
                } else {
                    querry(input, 1);
                }
                
                
                
                int magicCode = 0;
                if(mDiff == -1) {
                    if(mEQ == 1) {
                        magicCode = 2;
                    }
                } else if(mEQ == -1) {
                    if(mDiff == 1) {
                        magicCode = 2;
                    }
                } else {
                    //both have stuff
                    if(mDiff == 1) {
                        if(mEQ == 1) {
                            magicCode = 2;
                        } else {
                            magicCode = 1;
                        }
                    } else {
                        if(mEQ == 1) {
                            magicCode = 3;
                        }
                    }
                }
                
                
                
                if(magicCode == 1) {
                    //reverse
                    bits = reverse(bits);
                } else if(magicCode == 2) {
                    //flip
                    bits = flip(bits);
                } else if(magicCode == 3) {
                    //both
                    bits = flip(bits);
                    bits = reverse(bits);
                }
                
            }
            doQuerries(bits, i == 0 ? 5 : 4, bitCount, input);
        }
        
        //convert [] to string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bitCount; i++) {
            sb.append(bits[i]);
        }
        System.out.println(sb.toString());
        input.next();
    }
    
    public static int[] doQuerries(int[] bits, int numOfQ, int bitCount, Scanner input) {
        int querriesAtStart = querries;
        for(int i = querriesAtStart; i < querriesAtStart + numOfQ; i++) {
            if(i > bitCount - 1 - i) {
                return bits;
            }
            querries++;
            int a = querry(input, i + 1);
            int b = querry(input, bitCount - 1 - i + 1);
            if(indexOfDiffBits == -1 && a != b) {
                indexOfDiffBits = i;
            }
            if(indexOfEQBits == -1 && a == b) {
                indexOfEQBits = i;
            }
            bits[i] = a;
            bits[bitCount - 1 - i] = b;
        }
        return bits;
    }
    
    public static int[] reverse(int[] bits) {
        for(int i = 0; i < bits.length / 2; i++) {
            int temp = bits[bits.length - 1 - i];
            bits[bits.length - 1 - i] = bits[i];
            bits[i] = temp;
        }
        return bits;
    }
    public static int[] flip(int[] bits) {
        for(int i = 0; i < bits.length; i++) {
            if(bits[i] == 0) {
                bits[i] = 1;
            } else {
                bits[i] = 0;
            }
        }
        return bits;
    }
    
    
    
    public static int querry(Scanner input, int s) {
        System.out.println(s);
        String res = input.next();
        if(res.toUpperCase() == "N") {
            int[] temp = new int[1];
            int a = temp[-1];
        }
        return Integer.parseInt(res);
    }
    
    
    
}


