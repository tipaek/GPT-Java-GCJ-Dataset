import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        List<Integer> rowlst=new ArrayList<Integer>();
        for(int i=0;i<test;i++){
            int length=sc.nextInt();
            int arr[][]=new int[length][length];
            int row=0,col=0;
            boolean flag=false;
            for(int j=0;j<length;j++){
                flag=false;
                for(int k=0;k<length;k++){
                    int elem=sc.nextInt();
                    arr[j][k]=elem;
                    if(rowlst.contains(elem)){
                        flag=true;
                    }
                    rowlst.add(elem);
                }
                if(flag){
                    row++;
                    flag=false;
                }
                rowlst.clear();
            }
            int trace=0;
            for(int j=0;j<length;j++){
                flag=false;
                for(int k=0;k<length;k++){
                    int elem=arr[k][j];
                    if(rowlst.contains(elem)){
                        flag=true;
                        k=length;
                    }
                    rowlst.add(elem);
                }
                if(flag){
                    col++;
                    flag=false;
                }
                trace+=arr[j][j];
                rowlst.clear();
            }
            System.out.println("Case #"+(i+1)+": "+ trace+" "+row+" "+col);
        }
    }
}
