

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t =in.nextInt();
        outer:for(int i=1;i<=t;i++){
            int n = in.nextInt();
            in.nextLine();
            String[] arr = new String[n];
            int index = 0;
            for(int j=0;j<n;j++){
                arr[j]=in.nextLine();
                if(arr[j].length()>=arr[index].length()){
                    index=j;
                }
            }
            if(n==2){
                int no=0;
                if(index==0){
                    no=1;
                }
                if(arr[index].endsWith(arr[no])){
                    System.out.println("Case #"+i+": "+arr[index].substring(1));
                }else{
                    System.out.println("Case #"+i+": *");
                }
                continue outer;
            }
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(j!=index&&k!=index){
                        if(!arr[j].endsWith(arr[k].substring(1))&&!arr[k].endsWith(arr[j].substring(1))){
                            System.out.println("Case #"+i+": *");
                            continue outer;
                        }
                    }
                }
            }
            System.out.println("Case #"+i+": "+arr[index].substring(1));
        }
    }
}
