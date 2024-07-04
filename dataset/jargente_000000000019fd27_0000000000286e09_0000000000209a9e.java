import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int[] solution= new int[B];
            int index=0;
            int indiceSame=-1;
            int indiceDis=-1;
            boolean cambiarBits=false;
            boolean cambiarPos=false;

            boolean cambioSame=false;
            boolean cambioDist=false;
            int i=0;
            boolean known=false;
            while(i<150 && !known){
                if(i%10==0 && i >1){
                    if(indiceSame!=-1){
                        if(cambiarPos)
                            System.out.println(B-indiceSame);
                        else
                            System.out.println(indiceSame+1);
                        int rep1 = input.nextInt();
                        if(cambiarBits)
                            rep1 = Math.abs(rep1-1);
                        i=i+1;
                        cambioSame=rep1!=solution[indiceSame];
                    }else{
                        if(cambiarPos)
                            System.out.println(B-indiceDis);
                        else
                            System.out.println(indiceDis+1);
                        int rep2 = input.nextInt();
                        if(cambiarBits)
                            rep2 = Math.abs(rep2-1);
                        i=i+1;
                        cambioDist=rep2!=solution[indiceDis];
                    }
                    if(indiceDis!=-1){
                        if(cambiarPos)
                            System.out.println(B-indiceDis);
                        else
                            System.out.println(indiceDis+1);
                        int rep2 = input.nextInt();
                        if(cambiarBits)
                            rep2 = Math.abs(rep2-1);
                        i=i+1;
                        cambioDist=rep2!=solution[indiceDis];
                    }else{
                        if(cambiarPos)
                            System.out.println(B-indiceSame);
                        else
                            System.out.println(indiceSame+1);
                        int rep1 = input.nextInt();
                        if(cambiarBits)
                            rep1 = Math.abs(rep1-1);
                        i=i+1;
                        cambioSame=rep1!=solution[indiceSame];
                    }
                    if(cambioSame){
                        if(cambioDist){
                           cambiarBits=!cambiarBits;
                        }else{
                            cambiarBits=!cambiarBits;
                            cambiarPos=!cambiarPos;
                        }
                    }else{
                        if(cambioDist){
                            cambiarPos=!cambiarPos;
                        }
                    }
                }
                System.out.println(index + 1);
                int e1 = input.nextInt();
                i = i + 1;
                System.out.println(B - index);
                int e2 = input.nextInt();
                i = i + 1;

                if (cambiarBits) {
                    if (cambiarPos) {
                        solution[index] = Math.abs(e2 - 1);
                        solution[B - index - 1] = Math.abs(e1 - 1);
                    } else {
                        solution[index] = Math.abs(e1 - 1);
                        solution[B - index - 1] = Math.abs(e2 - 1);
                    }
                } else {
                    if (cambiarPos) {
                        solution[index] = e2;
                        solution[B - index - 1] = e1;
                    } else {
                        solution[index] = e1;
                        solution[B - index - 1] = e2;
                    }
                }

                if (e1 == e2)
                    indiceSame = index;
                else
                    indiceDis = index;
                index = index + 1;
                if(index >= B/2)
                    known=true;

            }
            if(cambiarBits){
                for(int k=0; k<solution.length; k++)
                    solution[k]=Math.abs(solution[k]-1);
            }
            if(cambiarPos){
                for(int k=0; k<solution.length/2; k++){
                    int temp = solution[k];
                    solution[k] = solution[B-k-1];
                    solution[B-k-1] = temp;
                }
            }
            String resultString = Arrays.stream(solution).boxed().map(Object::toString).collect(Collectors.joining(""));
            System.out.println(resultString);
            String computerRes = input.next("[a-zA-Z]");
            if(computerRes.equals("N")){
                return;
            }
        }
        return;
    }

}
