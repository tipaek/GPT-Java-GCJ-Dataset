import java.util.*;
import java.util.logging.*;
import java.io.*;
import java.time.LocalDateTime;

public class Solution {
	private static Logger logger = Logger.getLogger(Solution.class.getName());	
	
	private FileHandler fh;  
	private Scanner inScanner;
	private static final int _MAX_QUERIES = 150;
	private static final double _CHUNK_AMOUNT = 9.0;
	/**
	 * Constructor
	 */
	public Solution() {
		//Set the file logger
		setLogFile();
		
		//Read Interactive inputs
		inScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	}

	
	/**
	 * Set uf a file handler to output the logs
	 */
	public void setLogFile() {

	    try {  
	    	//Create file
	    	File myFile = new File("loggin.txt");
	        if (myFile.createNewFile()) {
	            logger.info("File created: " + myFile.getName());
	          } else {
	        	  logger.info("File already exists: "+ myFile.getCanonicalPath());
	          }
	        
	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("loggin.txt");  
	        logger.addHandler(fh);
	        
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  


	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    LocalDateTime ldt = LocalDateTime.now().plusDays(1);
	    logger.info(ldt.toString());  
	}
	
	public void closeLogFile() {
		logger.info("******** END OF LOG");
		fh.close();
	}
	
	public String getOneLine() {
		return inScanner.nextLine();
	}
	
	private boolean requestOneBit(int position) {
		//Request first bit:
        System.out.println(position);
        int receivedBit = inScanner.nextInt();
        logger.info(String.format("Requested bit #%d: received %d", position, receivedBit));
        return receivedBit==1;
	}
	

	/**
	 * Request all necessary bits and 
	 * @param B size of array
	 * @return decodedArray
	 */
	public boolean receiveAndDecodeArray(int B) {
		int chunksNumber = (int) Math.ceil(B/_CHUNK_AMOUNT);
		logger.info(String.format("Number of %d bits chunks: %d ", B, chunksNumber));
		
		boolean[][] bitArray = new boolean[chunksNumber][(int)_CHUNK_AMOUNT];
		boolean[][] bitArrayRevered = new boolean[chunksNumber][(int)_CHUNK_AMOUNT];
		boolean[][] bitArrayReveredComplemented = new boolean[chunksNumber][(int)_CHUNK_AMOUNT];

		//Requests all bits once
		int numRequests = B;
		for (int i=1; i<=B; i++) {
			//Request the one bit, then store the result in a list
			int requestBitPosition = i%B;
			if (requestBitPosition == 0)
				requestBitPosition = B; //count from 1
			boolean bit = requestOneBit(requestBitPosition);
			//Update no changes and complemented arrays
			int currentChunk = (int) Math.ceil(requestBitPosition/_CHUNK_AMOUNT)-1;
			int currentChunkPosition = (int) (requestBitPosition%(_CHUNK_AMOUNT))-1;
			if (currentChunkPosition == -1)
				currentChunkPosition = (int)_CHUNK_AMOUNT-1; //count from 1
			//Build no change and complement arrays
			bitArray [currentChunk][currentChunkPosition] = bit;

		}
		//Try to see if we are lucky and only no changes or complemented happened
		//Number of possible permutations: chunksNumber^2
		int permutations = (int) Math.pow(chunksNumber,2);
		String[] decodedArrays  = new String[permutations];
		String []decodedChunks = new String[2] ;
		decodedChunks[0]="";
		decodedChunks[1]="";

		//Initialize:
		for (int i=0; i<(int) Math.pow(chunksNumber,2); i++)
			decodedArrays[i]="";
		
		for (int i=0; i<chunksNumber; i++) {
			//Bit chunks value options
			for (int j=0; j<_CHUNK_AMOUNT && !(i==chunksNumber-1 && j+1==B%_CHUNK_AMOUNT); j++) { //exit at the last chunk, last filled bit
				decodedChunks[0] += Boolean.compare(bitArray[i][j], false);
				decodedChunks[1] += Math.abs(Boolean.compare(bitArray[i][j], true)); //inverse
			}
			//Update in the resulting strings
			decodedArrays[0]+=decodedChunks[0]; //TT
			decodedArrays[1]+=decodedChunks[1]; //FF

			decodedArrays[2]+=decodedChunks[i]; //TF
			decodedArrays[3]+=decodedChunks[Math.abs(Integer.compare(i, 1))]; //FT
		}
		
		//Send the decode arrays and see if there is any result
		for (String array: decodedArrays) {
			if (sendContentsOfArray(array))
				return true;
		}
			
		return false;
	}
	
	public boolean sendContentsOfArray(String array) {
		logger.info("Send array: "+array);
		System.out.println(array);
		
		String response = getOneLine();
		switch(response) {
			case "Y":
				return true;
			default:
			case "N":
				return false;
		}
	}
	
	/**
	 * main method
	 * @param args arguments
	 */
	public static void main(String[] args) {
		
		Solution solution = new Solution();

		
		//1. Get first line
		String firstLine= solution.getOneLine();
		String[] tb = firstLine.split(" ");
		int T = Integer.parseInt(tb[0]);
		int B = Integer.parseInt(tb[1]);
		logger.info(String.format("Cases %d and bits %d", T, B));

		//2. For all cases (arrays) try to decode and send correct result
		int t=1;
		while (t<=T) {
			//For each case:
			if (solution.receiveAndDecodeArray(B))
				t++;
		}
			

        
        //Close file log
        solution.closeLogFile();
       
        
	}
	

}
