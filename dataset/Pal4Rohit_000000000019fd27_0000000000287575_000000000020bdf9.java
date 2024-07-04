import java.util.Scanner;
public class Solution {

    static int pos_1,pos_0;
    public static void main(String []args) {

        int n, t, itr;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (itr=1;itr <= t;itr++) {
            n = sc.nextInt();
            int arr[][] = new int[n][3];
            int a[][] = new int[n][3];

            //input
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                a[i][0] = arr[i][0];
                a[i][1] = arr[i][1];
            }
            sort(n, a);

            System.out.print("Case #"+itr+": ");
            if (parenting(a, n) == -1)
                System.out.print("IMPOSSIBLE");
            else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][0] == a[j][0] && arr[i][1] == a[j][1]) {
                            if (a[j][2] == 1)
                                System.out.print("C");
                            else
                                System.out.print("J");

                            break;
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    static void print(int a[][],int n){

        for(int i=0;i<n;i++){
            System.out.println(a[i][0]+" "+a[i][1]);
        }
    }
    static void sort(int n,int a[][]){

        //sort according to start time
        int index=0,min=0,flag=0;
        for(int i=0;i<n-1;i++){
            min=a[i][0];index=-1;
            for(int j=i+1;j<n;j++){
                if(a[j][0]<min){
                    index=j;
                    min=a[j][0];
                }
            }

            //swapping
            if(index != -1) {
                int t1 = a[i][0], t2 = a[i][1];
                a[i][0] = a[index][0];
                a[i][1] = a[index][1];
                a[index][0] = t1;
                a[index][1] = t2;
            }
        }
    }

    static int parenting(int a[][],int n){

        pos_1=0;pos_0=0;
        int one[][]= new int[n][2] ;int zero[][]=new int[n][2];
        one[0][0]=a[0][0];one[0][1]=a[0][1];a[0][2]=1;pos_1++;
        for(int i=1;i<n;i++){
            if(a[i][0]>a[i-1][0] && a[i][0]<a[i-1][1]) {  //start and end comes in-between of previous it toggles
                if(a[i-1][2]==0){  //goto one
                    for(int k=0;k<pos_1;k++){
                        if(a[i][0]<one[k][1] && a[i][0]>one[k][0])   // 1 to 150 and a[k][0]=100 then impossible
                            return -1;
                    }
                    a[i][2]=1;
                    //update one list
                    one[pos_1][0]=a[i][0];one[pos_1][1]=a[i][1];pos_1++;
                }
                else{   //goto zero
                    for(int k=0;k<pos_0;k++){
                        if(a[i][0]<zero[k][1] && a[i][0]>zero[k][0])   // 1 to 150 and a[k][0]=100 then impossible
                            return -1;
                    }
                    zero[pos_0][0]=a[i][0];zero[pos_0][1]=a[i][1];pos_0++;
                }

                a[i][2] = 1 - a[i - 1][2];
            }
            else if(a[i][0]>=a[i-1][1]) {  //start is bigger than previous end
                a[i][2] = a[i - 1][2];
                if(a[i-1][2]==1){  //goto one
                    for(int k=0;k<pos_1;k++){
                        if(a[i][0]<one[k][1] && a[i][0]>one[k][0])   // 1 to 150 and a[k][0]=100 then impossible
                            return -1;
                    }

                    //update one list
                    one[pos_1][0]=a[i][0];one[pos_1][1]=a[i][1];pos_1++;
                }
                else{   //goto zero
                    for(int k=0;k<=pos_0;k++){
                        if(a[i][0]<zero[k][1] && a[i][0]>zero[k][0])   // 1 to 150 and a[k][0]=100 then impossible
                            return -1;
                    }

                    zero[pos_0][0]=a[i][0];zero[pos_0][1]=a[i][1];pos_0++;
                }

            }
        }
        return 1;
    }

}
