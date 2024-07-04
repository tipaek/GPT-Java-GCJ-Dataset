import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    private static Scanner in;

    private static int findEqual(char[] result, int dk){
        for(int i = 0; i<dk; i++){
            if(result[i] == result[result.length-1-dk]){
                return i;
            }
        }
        return -1;
    }

    private static int findOdd(char[] result, int dk){
        for(int i = 0; i<dk; i++){
            if(result[i] != result[result.length-1-dk]){
                return i;
            }
        }
        return -1;
    }

    private static char read(int ind){
        System.out.println(ind+1);
        return in.next().charAt(0);
    }

    private static void fixCompl(char[] result, int dk){
        for(int i = 0; i<dk; i++){
            if(result[i] == '0'){
                result[i] = '1';
            }else{
                result[i] = '0';
            }
            int ind = result.length - 1 - i;
            if(result[ind]=='0'){
                result[ind] = '1';
            }else{
                result[ind] = '0';
            }
        }
    }

    private static void fixRev(char[] result, int dk){
        for(int i = 0; i < dk; i++){
            char temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = result[i];
        }
    }

    private static void fixSpecial(char[] result, int dk){
        read(0);
        if(read(0)!=result[0]){
            fixCompl(result, dk);
        }
    }
    private static void fix(char[] result, int dk){
        int eqInd = findEqual(result, dk), odInd = findOdd(result, dk);
        if(eqInd==-1){
            if(odInd==-1){
                read(0);
                read(0);
                return;
            }else{
                fixSpecial(result, dk);
                return;
            }
        }
        if(odInd==-1){
            fixSpecial(result, dk);
            return;
        }
        System.out.println(eqInd+1);

        boolean complOrCr = (read(eqInd) != result[eqInd]);
        boolean complOrRev = (read(odInd) != result[odInd]);

        if(complOrRev && complOrCr){
            fixCompl(result, dk);
            return;
        }
        if(complOrRev){
            fixRev(result, dk);
            return;
        }
        if(complOrCr){
            fixRev(result, dk);
            fixCompl(result, dk);
            return;
        }
    }
    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i<=t; i++){
            int b = in.nextInt();
            int dk = 0;
            char[] result = new char[b];
            boolean finished = false;
            while(dk<b/2){
                fix(result, dk);
                for(int j = 0; j<4; j++){
                    result[dk + j] = read(dk + j);
                    result[b - dk - j] = read(b - dk - j);
                }
                dk+=4;
            }
            System.out.println(new String(result));
            if((char)(in.nextByte()) == 'N'){
                break;
            }
        }
    }
}
