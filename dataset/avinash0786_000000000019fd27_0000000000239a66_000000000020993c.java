import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner inp=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=inp.nextInt();  //no of testCase
        for(int i=0;i<t;i++)
        {
            int N=inp.nextInt();   // Size of matrix N*N
            int arr[][]=new int[N][N];
            int trace=0;  //trace of matrix
            int rowrep=0;  //no of repetition in rows
            int colrep=0;  //no of repetitioin in cloumns

            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
                {
                    arr[j][k]=inp.nextInt();
                }
            }
            //calculating trace
            for(int x=0;x<N;x++)
                {
                    trace+=arr[x][x];
                }

            //calculating number of rows of the matrix that contain repeated elements
            for(int j=0;j<N;j++)
            {
                int count=0;
                for(int k=0;k<N;k++)
                {
                    if(rowrep>1)
                        break;
                    else
                    {
                        int key=arr[j][k];
                        for(int l=0;l<N;l++)
                        {
                            if(l==k)
                            {

                            }
                            else
                            {
                                if(arr[j][l]==key)
                                {
                                    count++;
                                    if(count>1)
                                        rowrep++;
                                    else
                                        break;
                                }
                            }
                        }
                    }
                }
            }



            //calculating number of col of the matrix that contain repeated elements
            for(int j=0;j<N;j++)
            {
                int count=0;
                for(int k=0;k<N;k++)
                {    //arr[k][j]
                    int key=arr[k][j];
                    if(count>1)
                    {
                        break;
                    }
                    for(int s=0;s<N;s++)
                    {
                        if(count>1)
                        {
                            colrep++;
                            break;
                        }
                        if(arr[s][j]==key)
                        {
                            count++;
                        }
                    }
                }
            }


            /*printing array
            for(int j=0;j<N;j++)
            {
                for(int s:arr[j])
                {
                    System.out.print(s+" ");
                }
                System.out.println();
            }*/


            System.out.println("Case #" + (i+1) + ": " + trace + " " + rowrep+" "+colrep);
    }
  }
}