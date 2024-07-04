

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t =in.nextInt();
        outer:for(int i=1;i<=t;i++){
            int n = in.nextInt();
            in.nextLine();
            String[] arr = new String[n];
            int indexAhead = 0;
            int indexAfter =0;
            int indLar=0;
            int minPostL=Integer.MAX_VALUE;
            int minPreL=Integer.MAX_VALUE;
            arr[0]=in.nextLine();
            for(int j=1;j<n;j++){
                arr[j]=in.nextLine();
                if(arr[j].length()>arr[indLar].length()){
                    indLar=j;
                }
                int postL=arr[j].split("\\*")[1].length();
                if(postL<minPostL){
                    indexAhead=j;
                }
                int preL = arr[j].split("\\*")[0].length();
                if(preL<minPreL){
                    indexAfter=j;
                }
            }
            String prev =arr[indexAfter].split("\\*")[0];
            String post = arr[indexAhead].split("\\*")[1];
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
            System.out.println("Case #"+i+": "+arr[indLar].replaceAll("\\*","A"));
        }
    }
}
