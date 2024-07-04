import java.util.*;
import java.io.*;

public class parentjob {

	public static void main(String[] args) {

	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int notc = in.nextInt();
	    for (int i = 0; i < notc; i++) {
	        in.nextLine();
	        int case_no = i + 1;
	        int noa = in.nextInt();

	        System.out.print("\nCase #" + case_no + ": ");

	        int endtime[] = new int[noa];
	        int starttime[] = new int[noa];
	        int endloc[] = new int[noa];
	        int startloc[] = new int[noa];
	        int endt[] = new int[noa];
	        String ansarr[] = new String[noa];
	        String ansf[] = new String[noa];

	        boolean impo = false;


	        for (int j = 0; j < noa; j++) {
	            in.nextLine();
	            int st = in.nextInt();
	            int et = in.nextInt();
	            starttime[j] = st;
	            startloc[j] = st;
	            endtime[j] = et;
	            endloc[j] = et;
	        }


	        Arrays.sort(starttime);
	        Arrays.sort(endtime);

	        for (int x = 0; x < noa; x++) {
	            endt[x] = endloc[findIndex(startloc, starttime[x])];
	        }

	        int jfre = 0;
	        int cfre = 0;
	        for (int y = 0; y < noa; y++) {
	            if (jfre <= starttime[y]) {
	                jfre = endt[y];
	                ansarr[y] = "J";
	            } else if (cfre <= starttime[y]) {
	                cfre = endt[y];
	                ansarr[y] = "C";
	            } else {
	                impo = true;
	                break;
	            }
	        }

	        if (impo == false) {
	            for (int x = 0; x < noa; x++) {
	                int ind = findIndex(startloc, starttime[x]);
	                ansf[ind] = ansarr[x];
	            }

	            for(int r =0;r<noa;r++){
	                System.out.print(ansf[r]);
	            }
	        }else{
	            System.out.print("IMPOSSIBLE");
	        }

	 


	    }




	}
	public static int findIndex ( int arr[], int t)
	{


	    int len = arr.length;
	    int i = 0;


	    while (i < len) {

	        if (arr[i] == t) {
	            return i;
	        } else {
	            i = i + 1;
	        }
	    }
	    return -1;
	}
}
