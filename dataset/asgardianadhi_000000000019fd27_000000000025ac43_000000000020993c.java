import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i =0; i < t; i++){
			int n = sc.nextInt();
			Integer[][] p = new Integer[n][n];
	
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					p[j][k]= Integer.valueOf(sc.nextInt());
				}
			}
			Integer[] arr = new Integer[n];
			int r=0,c=0,kx=0;
			for(int j=0;j<n;j++){
				if(areDistinct(p[j])){
					r++;
				}
				for(int k =0; k<n; k++){
					arr[k]=p[k][j];
				}
				if(areDistinct(arr)){
					c++;
				}
			}
			for(int j=0, k=0; j<n; j++,k++){
				kx+=p[j][k];
			}
			System.out.println("Case #"+(i+1)+": "+kx+" "+r+" "+c);
		}
  }
	public static boolean areDistinct(Integer arr[]) 
    { 
     
        Set<Integer> s =  new HashSet<Integer>(Arrays.asList(arr)); 
          return (s.size() != arr.length); 
    } 
}