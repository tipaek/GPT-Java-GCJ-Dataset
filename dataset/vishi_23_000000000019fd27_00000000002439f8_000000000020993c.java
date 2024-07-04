import java.util.Scanner;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        int t=1;
        while(tc>0){
           
          int l=sc.nextInt();
          int a[][]=new int[l][l];
          for(int i=0;i<l;i++){
              for(int j=0;j<l;j++){
                  a[i][j]=sc.nextInt();
              }
          }
          
          int trace=mtrace(a,l);
          int r=row(a,l);
          int c=col(a,l);
          System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
          t++;
          tc--;  
        }
        sc.close();
    }
    
    static int mtrace(int a[][],int l){
        int sum=0;
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                if(i==j){
                    sum=sum+a[i][j];
                    break;
                }
            }
        }
        return sum;
    }
    
    static int row(int a[][],int l){
        int count=0;
        boolean flag=false;
        for(int i=0;i<l;i++){
            for(int j=0;j<l-1;j++){
                for(int k=j+1;k<l;k++){
                    if(a[i][j]==a[i][k]){
                        flag=true;
                        count++;
                        break;
                    }
                }
                if(flag==true){
                    break;
                }
            }
            flag=false;
        }
        return count;
    }
    
    static int col(int a[][],int l){
        int count=0;
        boolean flag=false;
        for(int i=0;i<l;i++){
			for(int j=0;j<l-1;j++){
				for(int k=j+1;k<l;k++){
					if(a[j][i]==a[k][i]){
						count++;
						flag=true;
						break;
					}
				}
				if(flag=true){
					break;
				}
			}
			flag=false;
		}
        return count;
    }
}