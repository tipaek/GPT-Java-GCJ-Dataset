import java.util.*;

class Solution { 

  public static void main(String[] args) 
 { 
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 int index = 1;
	 List<String> list = new ArrayList<String>();
	while (t>0) {
		 int N = sc.nextInt();
		 int mat[][] = new int[N][N];
		 for (int i=0;i<N;i++) {
			 for (int j=0;j<N;j++) {
				 mat[i][j] = sc.nextInt();
			 }
		 } 
		 list.add("Case #"+ index +": "+ sumOfDiagonalElements(mat) +" "+ countIdenticalRows(mat) +" "+ countIdenticalColumns(mat));
	     t--;
	     index++;
	}
	for (String var:list) {
		System.out.println(var);
	}
 } 
 
 public static int countIdenticalRows(int mat[][]) 
 { 
     int count = 0; 

     for (int i = 0; i < mat.length; i++) { 
    	 
         HashSet<Integer> hs = new HashSet<>(); 

         for (int j = 0; j < mat[i].length; j++) { 
             hs.add(mat[i][j]); 
         } 
         if (hs.size() < mat.length) 
             count++; 
     } 
     return count; 
 }
 
 public static int countIdenticalColumns(int mat[][]) 
 { 
     int count = 0;

     for (int i = 0; i < mat.length; i++) { 
    	 
         HashSet<Integer> hs = new HashSet<>(); 

         for (int j = 0; j < mat[i].length; j++) { 
             hs.add(mat[j][i]); 
         } 
         if (hs.size() < mat.length) 
             count++; 
     } 
     return count; 
 }

 public static int sumOfDiagonalElements(int mat[][]) 
 { 
     int sum = 0; 

     for (int i = 0; i < mat.length; i++) { 

         for (int j = 0; j < mat[i].length; j++) { 
           if (i == j) 
        	  sum+=mat[i][j];
         }  
     } 
     return sum; 
 }
} 