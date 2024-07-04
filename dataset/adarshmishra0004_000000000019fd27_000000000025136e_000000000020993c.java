import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner scnr=new Scanner(System.in);
        int tcases=scnr.nextInt();//test cases
        while(tcases>0){
            tcases--;
            int sum=0,countrow=0,countcol=0,sn=1;
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
                     /*if(j>0){
                        for(int l=j-1;l>=0;l--){
                            if(arr[i][j]==arr[i][l]){
                                countrow++;
                            }
                            break;
                        }
                    }
                    /*if(i==size-1){
                        for(int k=i-1;k>=0;k--){
                            if(arr[i][j]==arr[k][j]){
                                countcol++;
                            }
                            break;
                        }
                    }*/
                }
                System.out.println();
            }
            int c=Test.show(arr,size,sum);
            int d=Test.show1(arr,size,sum);
            System.out.println("case "+sn+":"+sum+" "+c+" "+d);
            sn++;
            //System.out.println("case :"+sum+" "+countrow+" "+countcol);
        }
    }
    public static int show(int[][] a,int size,int sum){
        int count=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    if(j!=k){
                        if(a[i][j]==a[i][k]){
                            count++;
                            //break;
                        }
                    }
                    break;
                }
            }
        }
        return count;
    }
    public static int show1(int[][] a,int size,int sum){
        int countc=0;
        for(int j=0;j<size;j++){
            for(int i=0;i<size;i++){
                for(int k=0;k<size;k++){
                    if(i!=k){
                        if(a[i][j]==a[k][j]){
                            countc++;
                        }
                    }
                    break;
                }
            }
        }
        return countc;
    }
}