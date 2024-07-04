import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int notc = in.nextInt();
        for (int i =0;i<notc;i++){
            in.nextLine();
            int case_no = i+1;
            int noa = in.nextInt();
            int ansc =2;
           System.out.print("\nCase #"+case_no+": ");

            int endtime[] = new int[noa];
            int starttime[] = new int[noa];
            int endloc[] = new int[noa];
            int startloc[] = new int[noa];
            String ansarr[] = new String[noa];
            String ansf[] = new String[noa];

            boolean impo = false;



            for(int j =0;j<noa;j++){
                in.nextLine();
                int st = in.nextInt();
                int et = in.nextInt();
                starttime[j]=st;
                startloc[j]=st;
                endtime[j]=et;
                endloc[j]=et;
            }



            Arrays.sort(starttime);
            Arrays.sort(endtime);



            for(int k = 0;k<noa;k++){

                int gc =0;
                if(k ==0)
                {
                    ansarr[0]="C";

                }else
                if(k==1){
                    ansarr[1]="J";

                }
                else
                if(k>1)
                {


                    for(int l=0;l<noa;l++){
                        if(startloc[k]>=endloc[l] || startloc[k]<=startloc[l]&&endloc[k]<startloc[l]){
                            gc++;

                        }
                    }

                    if(gc>=1){

                        if(ansarr[ansc-1]=="C"){
                        ansarr[ansc]= "J";
                        ansc++;
                        }else {
                            ansarr[ansc]="C";
                            ansc++;
                        }
                    }else{
                        impo = true;
                        break;
                    }

                }

            }
            if(impo == false) {
               /* for (int x=0;x<noa;x++){
                    int ind = findIndex(startloc,starttime[x]);
                    ansf[ind]=ansarr[x];

                }*/

                for (int y = 0;y<noa;y++){
                   System.out.print(ansarr[y]);
                }
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