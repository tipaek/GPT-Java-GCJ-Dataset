/**
 *
 * @author EngOsm
 */
import java.util.Scanner;
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input =new Scanner(System.in); 
        int T = input.nextInt();
  
          char pos='P'; 
     for (int i=0;i<T;i++)
         { 
          pos='P';
            int N = input.nextInt();
             int AC=1441;int BC =0;
             int AJ=1441;int BJ=0;
             char []MT =new char [N] ;      
    for (int j=0;j<N;j++)
    {       
           int A= input.nextInt();
       int B= input.nextInt(); 
       if ((BC<=A)||((B<=AC))) {
           MT[j]='C';
           if (B<AC){AC=A;}
           if (B>BC){BC=B;}}
       else if ((BJ<=A)||((B<=AJ))) {
           MT[j]='J';
           if (B<AJ){AJ=A;}
           if (B>BJ){BJ=B;}
               }
       else { 
           pos='I';
           break; }}
    {System.out.print("Case #" );  
     System.out.print(i+1); 
     System.out.print(": ");
     for (int i2=0;i2<N;i2++)
     { 
    if (pos=='I')
      {   
       System.out.print("Impossible" );
        pos='P';
          break; 
    }
    else { 
     System.out.print(MT[i2]);
         }  
    }
      System.out.println();
    }}}}