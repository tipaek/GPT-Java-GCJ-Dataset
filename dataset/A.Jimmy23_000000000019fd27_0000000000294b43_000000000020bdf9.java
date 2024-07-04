

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        int cas=1;
        String Snew="";
        while(cas<=t) {
            int T=scan.nextInt();
            int[] arr=new int[T*2];
            for(int i=0;i<arr.length;i++){
                arr[i]=scan.nextInt();
            }
            Snew=Snew+"J";
            char test='J';
            int impoo=0;
            int none=0;
            for(int i=1;i<arr.length;i++){
                int imp=arr[1];
                if(none==0) {
                    if ( (i+1<arr.length) &&   (arr[i + 1] < imp && arr[i + 2] < imp)) {
                        impoo++;
                    } else {
                        none++;
                    }
                }
                if(impoo>=2){
                    Snew="IMPOSSIBLE";
                    break;
                }

                if((i+1<arr.length)&&(arr[i+1]<arr[i])){
                    if(test=='J') {
                        Snew = Snew + "C";
                        test='C';
                    }else{
                        Snew=Snew+"J";
                        test='J';
                    }
                }else{
                    if(test=='J') {
                        if ((i + 1 < arr.length)) {
                            Snew = Snew + "J";
                            test='J';
                        }
                    }else {
                        if ((i + 1 < arr.length)) {
                            Snew = Snew + "C";
                            test='C';
                        }
                    }
                }

                i++;
            }


            System.out.println("Case #" + cas + ": " + Snew);
            Snew="";
            cas++;
        }
    }
}