import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //insert code here
        Scanner in=new Scanner(System.in);
        int testcases=in.nextInt();
        for(int l=1;l<=testcases;l++){
            int sz=in.nextInt();
            int store[][]=new int[sz][5];
        for(int k=0;k<sz;k++){
            store[k][0]=-1;
            store[k][1]=in.nextInt();
            store[k][2]=k;
            store[k][3]=in.nextInt();
            store[k][4]=1;
        }
        sorter(store);
        int task_man[]=assigner(store,sz);
        generator(task_man,sz,l);

        }

    }
    public static void generator(int task[],int sz, int l){
        String ans="";
        int flag=0;
        for(int k=0;k<sz;k++){
            if(task[k]==1)
                ans+="C";
                else if(task[k]==2)
                    ans+="J";
                else{
                    flag=1;
                    break;
            }
        }
        if(flag==1)
            ans="IMPOSSIBLE";
        System.out.println("Case #"+l+": "+ans);
    }
    public static void custom_sort(int data[][], int row)
    {

        Arrays.sort(data, new Comparator<int[]>() {

            @Override
            public int compare(final int[] val1, final int[] val2) {
          if (val1[row-1] > val2[row-1])
                    return 1;
                else
                    return -1;
            }
        });  }
    public static void sorter(int data[][] ){
        custom_sort(data,2);
    }
    public static int[]assigner(int data[][], int sz){
        int task_man[]=new int[sz];
        int cj=Integer.MIN_VALUE;
        int cc=Integer.MIN_VALUE;
        for(int k=0;k<sz;k++){
            if(data[k][1]>=cc)
            {
                task_man=tasker(task_man,data[k][2],1);
                cc=updater(cc,data[k][3]);
            }
            else if(data[k][1]>=cj)
            {
                task_man=tasker(task_man,data[k][2],2);
                cj=updater(cj,data[k][3]);
            }
            else
            {
                task_man=tasker(task_man,data[k][2],3);
            }
        }
        return task_man;
    }
    public static int[]tasker(int task_man[],int tsk,int p){
        task_man[tsk]=p;
        return task_man;
    }
    public static int updater(int in, int fin){
        int v=fin-in;
        int ne=in+v;
        return ne;
    }
}
