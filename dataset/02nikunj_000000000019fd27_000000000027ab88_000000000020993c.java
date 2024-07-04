import java.util.*;
 class jam {
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int test=0;
while(t-->0){
    test++;
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
HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
for(int d=0;d<n;d++)
{
for(int l=0;l<n;l++){

if(map.containsKey(arr[d][l])){
r=r+1;
break;
}
else{
    map.put(arr[d][l],l);
}
}
map.clear();
}
HashMap<Integer,Integer> sap=new HashMap<Integer,Integer>();

for(int a=0;a<n;a++){

    for(int b=0;b<n;b++){
if(sap.containsKey(arr[b][a])){
c=c+1;
break;
}
else{
    sap.put(arr[b][a], b);
}
    }
    sap.clear();
}
System.out.println("case #"+test+":"+k+" "+r+" "+c);
}
}
}