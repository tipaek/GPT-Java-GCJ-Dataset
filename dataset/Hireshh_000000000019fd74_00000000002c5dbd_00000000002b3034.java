

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t =in.nextInt();
        outer:for(int i=1;i<=t;i++){
            int n = in.nextInt();
            in.nextLine();
            String[] arr = new String[n];
            int indexWithMinPostL = 0;
            int indexWithMinPreL =0;
            int indexWithMaxPreL=0;
            int indLar=0;
            int indLarPost=0;

            int minPostL=Integer.MAX_VALUE;
            int minPreL=Integer.MAX_VALUE;
            int maxPostL=Integer.MIN_VALUE;
            int maxPreL=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                arr[j]=in.nextLine();
                if(arr[j].length()>arr[indLar].length()){
                    indLar=j;
                }
                int postL=arr[j].split("\\*")[1].length();
                if(postL<minPostL&&postL!=0){//
                    minPostL=postL;
                    indexWithMinPostL=j;
                }
                if(postL>maxPostL){
                    maxPostL=postL;
                    indLarPost=j;
                }
                int preL = arr[j].split("\\*")[0].length();
                if(preL<minPreL&&preL!=0){//
                    minPreL=preL;
                    indexWithMinPreL=j;
                }
                if(preL>maxPreL){
                    maxPreL=preL;
                    indexWithMaxPreL=j;
                }


            }
            if(indexWithMaxPreL>=n||indexWithMaxPreL<0){
                indexWithMaxPreL=0;
            }
            if(indLarPost>=n||indLarPost<0){
                indLarPost=0;
            }
            for(int j=0;j<n;j++){

                if(!arr[indexWithMaxPreL].startsWith(arr[j].split("\\*")[0])){
                    System.out.println("Case #"+i+": *");
                    continue outer;
                }
                if(!arr[indLarPost].endsWith(arr[j].split("\\*")[1])){
                    System.out.println("Case #"+i+": *");
                    continue outer;
                }
            }
            System.out.println("Case #"+i+": "+arr[indexWithMaxPreL].split("\\*")[0]+arr[indLarPost].split("\\*")[1]);
        }
    }
}

