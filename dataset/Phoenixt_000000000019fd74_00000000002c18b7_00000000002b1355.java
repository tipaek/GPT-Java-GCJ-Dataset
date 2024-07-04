import java.util.*;

class cell{
    int s,e;
    cell(int s,int e)
    {
        this.s=s;
        this.e=e;
    }
}

class Solution{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int p=0;p<t;p++){
            int r=in.nextInt();
            int c=in.nextInt();
            int[][] mat=new int[r][c];
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    mat[i][j]=in.nextInt();
            System.out.print("Case #"+(p+1)+": ");
            dance(mat,r,c);
        }
    }
    
    static void dance(int[][] mat,int r,int c){
        int sum=0;
        int tsum=findSum(mat,r,c);
        ArrayList<cell> elim;
        int t=3;
        do{
            //t--;
            sum+=tsum;
            elim=new ArrayList<>();
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    {
                     if(mat[i][j]==-1)
                        continue;
                     double navg=find(mat,i,j,r,c);
                    // System.out.println(navg);
                     if(mat[i][j]<navg)
                          elim.add(new cell(i,j));
                    }
            for(int k=0;k<elim.size();k++)
            {
                cell tmp=elim.get(k);
                tsum-= mat[tmp.s][tmp.e];
                mat[tmp.s][tmp.e]=-1;
                
            }

           // System.out.println(elim.size());
             //       System.out.println(sum);

        }while(elim.size()>0);
        System.out.println(sum);
    }
    
    static double find(int[][] mat,int i,int j,int r,int c){
        int up,down,left,right,count=0;
        up=down=left=right=0;
        for(int z=i-1;z>=0;)
               { if(mat[z][j]==-1)
                    z--;
                else
                   { up=mat[z][j]; count++; break;}
                }
        
        for(int z=j-1;z>=0;)
               { if(mat[i][z]==-1)
                    z--;
                else
                   { left=mat[i][z];count++; break;}
                }
               
        for(int z=i+1;z<r;)
               { if(mat[z][j]==-1)
                    z++;
                else
                   { down=mat[z][j];count++; break;}
                }
        for(int z=j+1;z<c;)
               { if(mat[i][z]==-1)
                    z++;
                else
                   { right=mat[i][z];count++; break;}
                }
        if(count==0)
            return 0;
        //System.out.println(up+" "+down+" "+left+" "+right);
        return (up+down+left+right)/(count*1.0);
    }
    
    static int findSum(int[][] mat,int r,int c){
        int sum=0;
        for(int i=0;i<r;i++)
           { for(int j=0;j<c;j++)
                {
                  //  System.out.print(mat[i][j]+" ");
                    if(mat[i][j]!=-1)
                    {sum+=mat[i][j];}
                }
//System.out.println();
           }
        return sum;
    }
    
}