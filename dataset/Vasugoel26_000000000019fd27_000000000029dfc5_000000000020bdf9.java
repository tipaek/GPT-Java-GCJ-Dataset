import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
         Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int notc = in.nextInt();
        for (int i = 0; i < notc; i++) {
            in.nextLine();
            int case_no = i + 1;
            int noa = in.nextInt();

            System.out.print("\nCase #" + case_no + ": ");

            int endtime[] = new int[noa];
            int starttime[] = new int[noa];
            int endloc[] = new int[noa];
            int startloc[] = new int[noa];
            int endt[] = new int[noa];
            String ansarr[] = new String[noa];
            String ansf[] = new String[noa];

            boolean impo = false;


            for (int j = 0; j < noa; j++) {
                in.nextLine();
                int st = in.nextInt();
                int et = in.nextInt();
                starttime[j] = st;
                startloc[j] = st;
                endtime[j] = et;
                endloc[j] = et;
            }


            Arrays.sort(starttime);
            Arrays.sort(endtime);

            for (int x = 0; x < noa; x++) {
                endt[x] = endloc[findIndex(startloc, starttime[x])];
            }

            int jfre = 0;
            int cfre = 0;

            for (int y = 0; y < noa; y++) {
                if (cfre <= starttime[y]) {
                    cfre = endt[y];
                    ansarr[y] = "C";
                } else if (jfre <= starttime[y]) {
                    jfre = endt[y];
                    ansarr[y] = "J";
                } else {
                    impo = true;
                    break;
                }
            }

            if (impo == false) {
                for (int x = 0; x < noa; x++) {
                    int ind = findIndex(startloc, starttime[x]);
                    ansf[ind] = ansarr[x];
                }
                 String ans ="";
                for(int r =0;r<noa;r++){
                    ans = ans.concat(ansf[r]);
                }
                System.out.print(ans);
            }else{
                System.out.print("IMPOSSIBLE");
            }




        }



        

    }




    public static int findIndex(int arr[], int t)
    {


        int len = arr.length;
        int i = 0;


        while (i < len) {

            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
}
























/*
                if(j==0){
                    ansarr[j]="C";
                }
                if(j==1){
                    ansarr[j]="J";

                }
                if(j>1){
                    for(int k = j-1;k>=0;k--){
                        boolean prob =false;

                        if(starr[j]>starr[k] && etarr[j]<etarr[k]){
                            for(int l =j-1;l>=0;l--)
                            {
                                if(starr[j]<etarr[l] && etarr[l]<etarr[j]){
                                    prob=true;
                                    break;
                                }
                            }
                            if(prob == false){
                                if(ansarr[k]=="C"){
                                    ansarr[j]="J";
                                    break;
                                }else {ansarr[j]="C";
                                    break;}
                            }


                        }else if(starr[j]>=etarr[k] ){
                            for(int m =j-1;m>=0;m--){
                                if(etarr[k]<starr[m] && starr[m]<starr[j]){
                                    if(etarr[m]<=starr[j]){
                                        if(ansarr[m]=="C"){
                                            ansarr[j]="J";
                                            break;
                                        }else {ansarr[j]="C";
                                            break;}
                                    } else{
                                        if(ansarr[k]=="C"){
                                            ansarr[j]="J";
                                            break;
                                        }else {ansarr[j]="C";
                                            break;}

                                    }
                                }
                            }

                        }else{
                            impossible=true;
                            break;
                        }

                    }
                }
                 if(impossible==true){
                     break;
                 }



            }
            if(impossible==true){
                System.out.print("IMPOSSIBLE");
            }else{
                for(int z =0 ; z<noa;z++){
                    System.out.print(ansarr[z]);
                }*/