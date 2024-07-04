import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Sol{
         private static Scanner s;
         static int n=1;
         public static void main(String args[]){
             s=new Scanner(System.in);
             int t=s.nextInt();
             s.nextLine();
             while(t-->0){
                 kro();
        }
         }
private static void kro(){  
        int size=s.nextInt();
        int[][] m=new int[size][size];
        int k=0;
          for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                m[i][j]=s.nextInt();
                if(i==j) k+=m[i][j];
            }
        }
    int r=A(m);
    int c=B(m);
      
       System.out.println("case #"+ (n++)+": "+ k +" "+ r +" "+c);
       }
      
     private static int A(int[][] m){
        int res=0;
           for(int i=0;i<m.length;i++){
             Set<Integer> set=new HashSet<>();
             
             for(int j=0;j<m[i].length;j++){
                if(set.contains(m[i][j])){
                    res++;
                    break;
                }
            set.add(m[i][j]);
        }
    }
    return res;
}
  private static int B(int[][] m){
        int res=0;
           for(int i=0;i<m.length;i++){
             Set<Integer> set=new HashSet<>();
             
             for(int j=0;j<m[i].length;j++){
                if(set.contains(m[j][i])){
                    res++;
                    break;
                }
            set.add(m[j][i]);
        }
    }
    return res;
}
  }   
          
    