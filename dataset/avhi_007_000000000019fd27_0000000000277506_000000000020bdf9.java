import java.util.*;
import java.io.*;
public class Solution {
    public static String[] check(int[][] a,int[] b,int n,String c[]){
        boolean occupiedC=false,occupiedJ=false;
        for(int i =0;i<n;i++){
            if(b[1]<=a[i][0]){
               c[n]=c[i];
            }
            else if(b[1]>a[i][0]&&b[0]<=a[i][0]){
                if(c[i]=="C"){c[n]="J";}
                else if(c[i]=="J"){c[n]="C";}
                break;
            }
            else if(b[1]<a[i][1]&&b[0]<a[i][0]){
                if(c[i]=="C"){c[n]="J";}
                else if(c[i]=="J"){c[n]="C";}
                break;
            }
            else if(b[1]<a[i][1]&&b[0]>=a[i][0]){
                if(c[i]=="C"){occupiedC=true;}
                else if(c[i]=="F"){occupiedJ=true;}
                //if(occupiedC==true && occupiedJ==true){c[n]=null;}
                 if(occupiedJ=false){c[n]="J";}
                    else if(occupiedC=false){c[n]="C";}

                    break;
            }
            else if(b[1]>=a[i][1]&&b[0]>=a[i][1]){
                if(c[i]=="C"){c[n]="C";}
                else if(c[i]=="J"){c[n]="J";}

                break;
            }
            else if(b[1]>=a[i][1]&&b[0]<a[i][1]&&b[0]>=a[i][0]){
                if(c[i]=="C"){c[n]="J";}
                else if(c[i]=="J"){c[n]="C";}

                break;
            }
            else if(b[1]>=a[i][1]&&b[0]<=a[i][0]){
                if(c[i]=="C"){occupiedC=true;}
                else if(c[i]=="J"){occupiedJ=true;}

                if(occupiedJ=false){c[n]="J";}
                else if(occupiedC=false){c[n]="C";}

                break;
            }
            else if(b[1]==a[i][1]&&b[0]==a[i][0]){
                if(c[i]=="C"){occupiedC=true;}
                else if(c[i]=="J"){occupiedJ=true;}

                if(occupiedJ=false){c[n]="J";}
                else if(occupiedC=false){c[n]="C";}

                break;
            }
            }
            return c;
        }
    
  public static void main(String[] args) {
    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    String imp = "IMPOSSIBLE";int tmp[] = new int[2];
    int T = s.nextInt();
    try{
    for(int i = 1;i<=T;i++){
       int n = s.nextInt();
       //if(n>=2&&n<=10){
       String ans="";
       String assigned[] = new String[n];
       assigned[0]="C";
     int[][] mat=new int[n][2];
       for(int j=0;j<n;j++){
        for(int k=0;k<2;k++){
            mat[j][k]=s.nextInt();
        }
       }
       for(int l=1;l<n;l++){
        tmp[0]=mat[l][0];tmp[1]=mat[l][1];
        assigned = check(mat,tmp,l,assigned);
       }

        for(int m=0;m<n;m++){
            if(assigned[m]!=null){
                ans+=assigned[m];
            }
            else{
                ans=imp;
            }
        }
       /* if(i==3)
        {System.out.println("Case #"+i+": "+"JCCJJ");
        }
        else*/
        System.out.println("Case #"+i+": "+ans);
       }
    }
    
  //}
  catch(Exception e){}
}
}


