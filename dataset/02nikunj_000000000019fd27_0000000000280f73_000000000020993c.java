import java.io.IOException;
import java.util.*;
 class jam {
public static void main(String[] args)throws IOException{
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int test=0;
while(t-->0){
    test++;
    try{
    int n=sc.nextInt();
    int[][] arr=new int[n][n];
    int k=0;

for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
    arr[i][j]=sc.nextInt();
    if(i==j){
        k+=arr[i][j];
    }
    }
}
int r=0,c=0;
HashSet<Integer> set1=new HashSet<Integer>();
HashSet<Integer> set2=new HashSet<Integer>();

for(int d=0;d<n;d++)
{
for(int l=0;l<n;l++){

set1.add(arr[d][l]);

}
if(set1.size()<n){
    r=r+1;
}
set1.clear();
}

for(int a=0;a<n;a++){

    for(int b=0;b<n;b++){

        set2.add(arr[b][a]);

    
    }
    if(set2.size()<n){
        c=c+1;
    }
    set2.clear();
}
System.out.println("case #"+test+": "+k+" "+r+" "+c);
}
catch(Exception e){
return;
}
}
}
}