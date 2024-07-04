
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
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(j!=index&&k!=index){
                        if(!arr[j].contains(arr[k].substring(1))&&!arr[k].contains(arr[j].substring(1))){
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
