import java.io.IOException;
import java.util.Arrays;

public class latin {
	public static int[] retmat(int[][] mat) {
		int countrow=0,countline=0,tr=0;
		int[] ret=new int[3];
		int[][] check1=new int[mat[0].length][mat[0].length];
		int[][] check2=new int[mat[0].length][mat[0].length];
		for(int i=0;i<mat[0].length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				check1[i][mat[i][j]-1]++;
				if(check1[i][mat[i][j]-1]>1) {
					countline++;
					break;
				}
			}
			tr+=mat[i][i];
		}
		ret[0]=tr;
		for(int i=0;i<mat[0].length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				check2[i][mat[j][i]-1]++;
				if(check2[i][mat[j][i]-1]>1) {
					countrow++;
					break;
				}
			}
		}
		ret[1]=countline;
		ret[2]=countrow;
		return ret;
		
		
	}
    public static void main(String[] args) {

    	
    }

}
