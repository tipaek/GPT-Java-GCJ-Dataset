import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Solution {
 
 int id,pos,in;
 Solution(int a,int b,int c){
  id=a;
  pos=b;
  in=c;
 }
 
 public static void main(String args[]) {
  Scanner scan = new Scanner(System.in);
  
  char ans[] = new char[1005];

      int T;
      T=scan.nextInt();
      for(int ca=1;ca<=T;ca++){
       List<Solution> nodes = new ArrayList<Solution>();
          int n,st,en;
          int cnt=0;
          n=scan.nextInt();
          for(int i=0;i<n;i++){
              st=scan.nextInt();
              en=scan.nextInt();
              nodes.add(new Solution(i,st,1));
              nodes.add(new Solution(i,en,0));
              cnt+=2;
          }
          Collections.sort(nodes, new Comparator<Solution>() {
                 public int compare(Solution a, Solution b) {
                  if(a.pos==b.pos){
                         if(a.in==b.in){
                             return a.id-b.id;
                         }
                         return a.in - b.in;
                     }
                     return a.pos - b.pos;
                 }
             });
          int cur=0;
          int flag=1;
          int c=0,j=0;
          for(int i=0;i<cnt&&flag==1;i++){
           Solution no = nodes.get(i);
              if(no.in==1){
                  if(cur<2) {
                      if(c==0){
                          ans[no.id]='C';
                          c=1;
                      }
                      else if(j==0){
                          ans[no.id]='J';
                          j=1;
                      }
                  }
                  else{
                      flag=0;
                      break;
                  }
                  cur++;
              }
              else{
                  cur--;
                  if(ans[no.id]=='C'){
                      c=0;
                  }
                  else{
                      j=0;
                  }
              }
          }
          System.out.print("Case #"+ca+": ");
          if(flag==1){
              ans[n]='\0';
              for(int i=0;i<n;i++) {
               System.out.print(ans[i]);
              }
              System.out.println("");
          }
          else{
              System.out.println("IMPOSSIBLE");
          }
      }
  scan.close();
 }
}
