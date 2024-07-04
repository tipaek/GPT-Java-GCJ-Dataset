

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
            int indLar=0;
            int indLarPost=0;
            arr[0]=in.nextLine();
            int minPostL=arr[0].split("\\*")[1].length();
            int minPreL=arr[0].split("\\*")[0].length();
            int maxPostL=arr[0].split("\\*")[1].length();
            for(int j=1;j<n;j++){
                arr[j]=in.nextLine();
                if(arr[j].length()>arr[indLar].length()){
                    indLar=j;
                }
                int postL=arr[j].split("\\*")[1].length();
                if(postL<minPostL){
                    minPostL=postL;
                    indexWithMinPostL=j;
                }
                if(postL>maxPostL){
                    maxPostL=postL;
                    indLarPost=j;
                }
                int preL = arr[j].split("\\*")[0].length();
                if(preL<minPreL){
                    minPreL=preL;
                    indexWithMinPreL=j;
                }


            }
            String prev =arr[indexWithMinPreL].split("\\*")[0];
            String post = arr[indexWithMinPostL].split("\\*")[1];
            for(int j=0;j<n;j++){

                if(!prev.isEmpty()&&!arr[j].startsWith(prev)){
                    System.out.println("Case #"+i+": *");
                    continue outer;
                }
                if(!post.isEmpty()&&!arr[j].endsWith(post)){
                    System.out.println("Case #"+i+": *");
                    continue outer;
                }
            }
            System.out.println("Case #"+i+": "+arr[indexWithMinPreL].split("\\*")[0]+arr[indLarPost].split("\\*")[1]);
        }
    }
}
