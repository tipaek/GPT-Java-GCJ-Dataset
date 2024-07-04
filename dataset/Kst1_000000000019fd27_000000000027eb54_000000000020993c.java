import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
 class Sol{
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
                if(i==j)
                k+=m[i][j];
            }
        }
    int r=A(m);
    int c=B(m);
      
       System.out.println("case #"+ (n++)+":"+ k +" "+ r +" "+c  );
       }
      
     private static int A(int[][] m1){
        int res=0;
           for(int i=0;i<m1.length;i++){
             Set<Integer> set=new HashSet<>();
             
             for(int j=0;j<m1[i].length;j++){
                if(set.contains(m1[i][j])){
                    res++;
                    break;
                }
            set.add(m1[i][j]);
        }
    }
    return res;
}
  private static int B(int[][] m2){
        int res=0;
           for(int i=0;i<m2.length;i++){
             Set<Integer> set=new HashSet<>();
             
             for(int j=0;j<m2[i].length;j++){
                if(set.contains(m2[i][j])){
                    res++;
                    break;
                }
            set.add(m2[i][j]);
        }
    }
    return res;
}
  }   
          
    