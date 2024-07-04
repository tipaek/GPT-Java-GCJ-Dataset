import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            int r=input.nextInt();
            int c=input.nextInt();
            int arr[][]=new int[r][c];
            for(int i=0;i<r;i++) {
                for(int j=0;j<c;j++) {
                    arr[i][j]=input.nextInt();
                }
            }
            int sum=0;
            while(true) {
                for(int i=0;i<r;i++) {
                    for(int j=0;j<c;j++) {
                        sum+=arr[i][j];
                    }
                }
                ArrayList<Integer> i_rem=new ArrayList<>();
                ArrayList<Integer> j_rem=new ArrayList<>();
                for(int i=0;i<r;i++) {
                    for(int j=0;j<c;j++) {
                        if(arr[i][j]==0) {
                            continue;
                        }
                        int neigh=0;
                        int indx_i=i-1,indx_j=j;
                        int count=0;
                        while(indx_i>=0) {
                            if(arr[indx_i][j]!=0) {
                                neigh+=arr[indx_i][j];
                                count++;
                                break;
                            }
                            indx_i--;
                        }
                        
                        indx_i=i+1;
                        indx_j=j;
                        while(indx_i<r) {
                            if(arr[indx_i][j]!=0) {
                                neigh+=arr[indx_i][j];
                                count++;
                                break;
                            }
                            indx_i++;
                        }
                        
                        indx_i=i;
                        indx_j=j-1;
                        while(indx_j>=0) {
                            if(arr[i][indx_j]!=0) {
                                neigh+=arr[i][indx_j];
                                count++;
                                break;
                            }
                            indx_j--;
                        }
                        
                        indx_i=i;
                        indx_j=j+1;
                        while(indx_j<c) {
                            if(arr[i][indx_j]!=0) {
                                neigh+=arr[i][indx_j];
                                count++;
                                break;
                            }
                            indx_j++;
                        }
                        
                        if((double)arr[i][j]<(double)neigh/(double)count) {
                            i_rem.add(i);
                            j_rem.add(j);
                        }
                    }
                    
                }
                if(i_rem.size()==0) {
                    break;
                }
                while(i_rem.size()!=0) {
                    arr[i_rem.get(0)][j_rem.get(0)]=0;
                    i_rem.remove(0);
                    j_rem.remove(0);
                }
            }
            
//            for(int i=0;i<r;i++) {
//                for(int j=0;j<c;j++) {
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }
            System.out.println("Case #"+t+": "+sum);
        }
    }
}
