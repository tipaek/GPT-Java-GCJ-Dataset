import java.util.*;
class Vestigium{

  public static void main(String[] args) {

    int test=2,size,trace=0;
   int[][] matrix=new int[100][100];
   int[][] casesoutput=new int[100][3];
     Scanner s=new Scanner(System.in);

     test=s.nextInt();
     size=s.nextInt();

    // Round1Problem1 r=new Round1Problem1();
     for(int itest=0;itest<test;itest++)
     {

       int rcount=0,ccount=0;
      //Input
        for(int r=0;r<size;r++){                        //row
            for(int c=0;c<size;c++)                     //column
            matrix[r][c]=s.nextInt();
          }

      //Processing

      for(int i=0;i<size;i++)                               //trace
      {
        trace=trace+matrix[i][i];
      }

      for(int r=0;r<size;r++)                           //rcount
      {
          for(int c=0;c<size;c++)
          {
              int ele=matrix[r][c];

                      if(ele==matrix[r][c+1])
                      {
                        rcount++;
                      }
          }
      }
      for(int r=0;r<size;r++)                          //ccount
      {
          for(int c=0;c<size;c++)
          {
              int ele=matrix[r][c];

                      if(ele==matrix[r+1][c])
                      {
                        ccount++;
                      }
          }
      }


      int csize=0;

      casesoutput[csize][0]=trace;
      casesoutput[csize][1]=rcount;
      casesoutput[csize][2]=ccount;
      csize++;


     }
     for(int i=0;i<test;i++)
        for(int j=0;j<3;j++)
        {
          System.out.print(casesoutput[i][j]+" ");
        }
        System.out.println();


    }
}
