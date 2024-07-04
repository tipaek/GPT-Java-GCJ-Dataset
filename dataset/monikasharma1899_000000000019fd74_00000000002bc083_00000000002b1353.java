import java.util.*;

class Solution{
    public static List<Integer[]> findPath(int n, int mat[][],List<Integer[]> path, int sum){
        Integer arr[]=path.get(path.size()-1);
        //arr[0]=(path.get(path.size()-1)[0]).intValue();
        //arr[1]=(path.get(path.size()-1)[1]).intValue();
        Integer i=arr[0]-1, j=arr[1]-1;
        Integer[] temp= new Integer[2];
        temp[0]=i; temp[1]=j;
                if( i>0 && j>0 && !path.contains(temp)){
                    Integer pv[]=new Integer[2];
                    pv[0]=new Integer(i);
                    pv[1]=new Integer(j);
                    path.add(pv);
                    sum+=mat[i][j];
                    if(sum==n){
                        return path;
                    }
                    else if(sum<n){
                        return findPath(n,mat,path,sum);
                    }
                    else{
                        path.remove(path.size()-1);
                    }
                }
         i=arr[0]-1; j=arr[1];
         temp[0]=i; temp[1]=j;
                if( i>0 && j>0 && !path.contains(temp)){
                   Integer pv[]=new Integer[2];
                    pv[0]=new Integer(i);
                    pv[1]=new Integer(j);
                    path.add(pv);
                    sum+=mat[i][j];
                    if(sum==n){
                        return path;
                    }
                    else if(sum<n){
                        return findPath(n,mat,path,sum);
                    }
                    else{
                        path.remove(path.size()-1);
                    }       
            }
        i=arr[0]; j=arr[1]-1;
        //Integer[] temp= new Integer[2];
        temp[0]=i; temp[1]=j;
                if( i>0 && j>0 && !path.contains(temp)){
                     Integer pv[]=new Integer[2];
                    pv[0]=new Integer(i);
                    pv[1]=new Integer(j);
                    path.add(pv);
                    sum+=mat[i][j];
                    if(sum==n){
                        return path;
                    }
                    else if(sum<n){
                        return findPath(n,mat,path,sum);
                    }
                    else{
                        path.remove(path.size()-1);
                    }
                }
            i=arr[0]; j=arr[1]+1;
            //Integer[] temp= new Integer[2];
        temp[0]=i; temp[1]=j;
                if(i>0 && j>0 && !path.contains(temp)){
                 Integer pv[]=new Integer[2];
                    pv[0]=new Integer(i);
                    pv[1]=new Integer(j);
                    path.add(pv);
                    sum+=mat[i][j];
                    if(sum==n){
                        return path;
                    }
                    else if(sum<n){
                        return findPath(n,mat,path,sum);
                    }
                    else{
                        path.remove(path.size()-1);
                    }
                }
            i=arr[0]+1; j=arr[1];
            // Integer[] temp= new Integer[2];
        temp[0]=i; temp[1]=j;
                if( i>0 && j>0 && !path.contains(temp)){
                Integer pv[]=new Integer[2];
                    pv[0]=new Integer(i);
                    pv[1]=new Integer(j);
                    path.add(pv);
                    sum+=mat[i][j];
                    if(sum==n){
                        return path;
                    }
                    else if(sum<n){
                        return findPath(n,mat,path,sum);
                    }
                    else{
                        path.remove(path.size()-1);
                    }
                }
            i=arr[0]+1; j=arr[1]+1;
           //   Integer[] temp= new Integer[2];
        temp[0]=i; temp[1]=j;
                if( i>0 && j>0 && !path.contains(temp)){
               Integer pv[]=new Integer[2];
                    pv[0]=new Integer(i);
                    pv[1]=new Integer(j);
                    path.add(pv);
                    sum+=mat[i][j];
                    if(sum==n){
                        return path;
                    }
                    else if(sum<n){
                        return findPath(n,mat,path,sum);
                    }
                    else{
                        path.remove(path.size()-1);
                    }
                }
        return new ArrayList<>();
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=1;t<=T;t++){
            int n=sc.nextInt();
            int pascal[][]=new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    if(j>1 && j<i){
                        pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
                    }
                    else{
                        pascal[i][j]=1;
                    }
                }
            }
            List<Integer[]> path = new ArrayList<>();
            Integer first[]={1,1};
            path.add(first);
            path = findPath(n,pascal,path,1);
            System.out.println("Case #"+t+":");
            for(Integer[] i:path){
                System.out.println(i[0]+" "+i[1]);
            }
        }
    }
}