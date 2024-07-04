import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner scnr=new Scanner(System.in);
        int tcases=scnr.nextInt();//test cases
        while(tcases>0){
            tcases--;
            int sum=0,countrow=0,countcol=0;
            int size=scnr.nextInt();
            int[][] arr=new int[size][size];//size of matrix
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    int ele=scnr.nextInt();
                    if(ele>0&&ele<size+1){
                        arr[i][j]=ele;
                    }
                    if(i==j){
                        sum=sum+arr[i][j];
                    }
                    if(j>0){
                        for(int l=j-1;l>=0;j--){
                            if(arr[i][j]==arr[i][l]){
                                countrow++;
                            }
                            break;
                        }
                    }
                    //if()
                }
                System.out.println();
            }
            //Test.show(arr,size);
            System.out.println("case 0"+sum+countrow);
        }
    }
    /*public static void show(int[][] a,int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if()
            }
        }
    }*/
}