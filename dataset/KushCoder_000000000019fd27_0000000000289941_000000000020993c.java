import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++){
                int n=scan.nextInt();
                int ar[][]=new int[n][n];
                int sum=0;
                int row=0;
                int column=0;
                int flag=0;
                for(int r=0;r<n;r++){
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    flag=0;
                      for(int c=0;c<n;c++){
                            ar[r][c]=scan.nextInt();
                            if(r==c){
                                  sum=sum+ar[r][c];
                            }
                            
                            if(l.contains(ar[r][c])&&flag==0){
                                flag=1;
                                   row++;
                                   
                            }
                            else{
                                     l.add(ar[r][c]);
                            }
                      }
                }
                for(int r=0;r<n;r++){
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    flag=0;
                      for(int c=0;c<n;c++){
                           
                            if(l.contains(ar[c][r])&&flag==0){
                                flag=1;
                                column++;
                                   
                            }
                            else{
                                     l.add(ar[c][r]);
                            }
                      }
                }
                System.out.print("Case #" + (i + 1) + ": ");
                System.out.println( sum + " " + row + " " + column );
                
                
                
        }
    }
}
