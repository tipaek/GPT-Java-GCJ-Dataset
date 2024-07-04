import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {//Rename to Solution
    static Scanner scan;
    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        int t = scan.nextInt();
        int b = scan.nextInt();
        for(int i = 0; i < t; i++){
            int[] bits = new int[b];//We get 10 bits to check
            for(int j = 0; j < 5; j++){
                bits[j] = req(j+1);
                bits[b-j-1] = req(b-j-1+1);
            }
            //Loop through all possible combos of three
            int[] chk = new int[3];//Indexes to check
            int[] pChk = new int[3];
            for(int j = 7; j <= 28; j++){
                if(Integer.bitCount(j) != 3) continue;//Small so Idc about inefficiency
                int[] b0 = new int[5];
                int[] b1 = new int[5];
                int count = 0;
                for(int k = 0; k < 5; k++){
                    if ((j&1<<k)>=1){
                        b0[k] = bits[k];
                        b1[k] = bits[b-k-1];//Reflected
                        chk[count++] = k;
                    }
                }
                if (!(b0[0] == b1[0] && b0[1] == b1[1] && b0[2] == b1[2]) && !(b0[0] != b1[0] && b0[1] != b1[1] && b0[2] != b1[2])) {
                    pChk = b0;
                    break;//This condition must be true at some point or the problem is impossible (I hope)
                }
            }
            int[] nChk = new int[3];
            int count = 5;
            for(int j = 10; j < 150 && count < b-5; j++){
                if (j%10 < 3)
                    nChk[j%10] = req(chk[j%10]+1);
                if (j%10 == 3){//Assume ind condition is right(It's not)
                    if(nChk[0]==pChk[0] && nChk[1]==pChk[1]  && nChk[2]==pChk[2])
                        continue;//Nothing changed
                    else if(nChk[0]!=pChk[0] && nChk[1]!=pChk[1]  && nChk[2]!=pChk[2]){
                        for(int k = 0; k < b; k++){
                            bits[k] = (bits[k] == 0) ? 1:0;
                        }//inverted
                        pChk = Arrays.copyOf(nChk,3);
                    }
                    else if(nChk[0] == pChk[2] && nChk[1] == pChk[1] && nChk[2] == pChk[1]){
                        //Reflected
                        for(int k = 0; k < b/2; k++){
                            int temp = bits[k];
                            bits[k] = bits[b-1-k];
                            bits[b-1-k] = temp;
                        }
                        pChk = Arrays.copyOf(nChk,3);
                    }
                    else if(nChk[0] != pChk[2] && nChk[1] != pChk[1] && nChk[2] != pChk[1]){
                        //Reflected and inverted
                        for(int k = 0; k < b/2; k++){
                            int temp = bits[k];
                            bits[k] = bits[b-1-k];
                            bits[b-1-k] = temp;
                        }
                        for(int k = 0; k < b; k++){
                            bits[k] = (bits[k] == 0) ? 1:0;
                        }
                        pChk = Arrays.copyOf(nChk,3);
                    }
                }
                if (j%10 >= 3){
                    bits[count] = req(count+1);
                    count++;
                }
            }
            for(int a : bits)
                System.out.print(a);
            System.out.println();
            scan.nextLine();
            if (scan.nextLine().contains("N")) break;
        }
        scan.close();
    }
    public static int req(int i){
        System.out.println(i);//Flushes
        return scan.nextInt();
    }
}