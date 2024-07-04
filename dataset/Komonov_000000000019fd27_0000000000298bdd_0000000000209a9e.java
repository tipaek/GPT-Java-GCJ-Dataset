import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        QuantumRetrieval qr = new QuantumRetrieval();
    }
}
class QuantumRetrieval{
    LinkedList<Integer> symetric;
    LinkedList<Integer> non_symetric;
    int[] arr;
    int ldi=-1;
    int rdi=-1;
    int j=0;
    Scanner sc;
    public QuantumRetrieval(){
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        for(int i=0;i<T;++i){
            arr = new int[B];
            symetric = new LinkedList<>();
            non_symetric = new LinkedList<>();
            ldi=-1;
            rdi=-1;
            // ldi means "last left defined index"
            // rdi means "last right defined index"
            j=0;

            while(ldi!=B/2-1+((B%2==1)?1:0)){
                if(j%10==0){
                    if(!symetric.isEmpty()){
                        System.out.println(symetric.getFirst()+1);
                        j++;
                        int response = sc.nextInt();
                        if(response!=arr[symetric.getFirst()]) reverse_symmetric();
                    }
                    if(!non_symetric.isEmpty()){
                        System.out.println(non_symetric.getFirst()+1);
                        j++;
                        int response = sc.nextInt();
                        if(response!=arr[non_symetric.getFirst()]) reverse_non_symmetric();
                    }
                    if(symetric.isEmpty() && non_symetric.isEmpty()){
                        ask_index(0);
                    }
                }
                else{
                    if(j%10<9) ask_index(ldi);
                    else {
                        System.out.println(1);
                        j++;
                        sc.nextInt();
                    }
                }
            }
            if(try_to_answer()) break;
        }
    }

    private boolean try_to_answer() {
        char[] res = new char[arr.length];
        for(int k=0;k<arr.length;++k) res[k]=(arr[k]==1) ? '1' : '0';
        System.out.println(new String(res));
        String response = sc.next();
        if(response.equals("Y")) return true;
        else return false;
    }

    private void ask_index(int i) {
        System.out.println(i+1);
        j++;
        int response = sc.nextInt();
        arr[i]=response;
        ldi=i;

        System.out.println(arr.length-i);
        i++;
        response = sc.nextInt();
        arr[arr.length-1-i]=response;
        rdi=i;
        if(arr[i]==arr[arr.length-1-i]) symetric.addLast(i);
        else non_symetric.addLast(i);
    }

    private void reverse_non_symmetric() {
        for(int s : non_symetric){
            arr[s]=(arr[s]+1)%2;
            arr[arr.length-1-s]=(arr[arr.length-1-s]+1)%2;
        }
    }

    private void reverse_symmetric() {
        for(int s : symetric){
            arr[s]=(arr[s]+1)%2;
            arr[arr.length-1-s]=(arr[arr.length-1-s]+1)%2;
        }
    }
}
