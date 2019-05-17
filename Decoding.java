import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class Decoding {

	static void deCodeMethod1(Scanner inFile, PrintWriter writer, int[][] imgAry){
		
		while (inFile.hasNextInt()){
			int startRow = inFile.nextInt();
			int startCol = inFile.nextInt();
			int greyScale = inFile.nextInt();
			int runLength = inFile.nextInt();
			
			for (int i = 0; i < runLength; i++){
				imgAry[startRow][startCol+i] = greyScale;
			}
		}
	}
	
	static void deCodeMethod2(Scanner inFile, PrintWriter writer,int[][] imgAry,int numCols){
		while (inFile.hasNextInt()){
			int startRow = inFile.nextInt();
			int startCol = inFile.nextInt();
			int greyScale = inFile.nextInt();
			int runLength = inFile.nextInt();
			int currentRow = startRow;
			int currentCol = startCol;
			while (runLength != 0){
				if (currentCol == numCols){
					currentRow++;
					currentCol = 0;
				}
				imgAry[currentRow][currentCol] = greyScale;
				currentCol++;
				runLength--;
			}
		}
	}
	
	static void deCodeMethod3(Scanner inFile, PrintWriter writer, int[][] imgAry){
		while (inFile.hasNextInt()){
			int startRow = inFile.nextInt();
			int startCol = inFile.nextInt();
			int greyScale = inFile.nextInt();
			int runLength = inFile.nextInt();
			
			for (int i = 0; i < runLength; i++){
				imgAry[startRow][startCol+i] = greyScale;
			}
		}
	}
	
	static void deCodeMethod4(Scanner inFile, PrintWriter writer,int[][] imgAry, int numCols){
		while (inFile.hasNextInt()){
			int startRow = inFile.nextInt();
			int startCol = inFile.nextInt();
			int greyScale = inFile.nextInt();
			int runLength = inFile.nextInt();
			int currentRow = startRow;
			int currentCol = startCol;
			while (runLength != 0){
				if (currentCol == numCols){
					currentRow++;
					currentCol = 0;
				}
				imgAry[currentRow][currentCol] = greyScale;
				currentCol++;
				runLength--;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner inFile;
		try {
			inFile = new Scanner(new FileReader(args[0]));
			int numRows = inFile.nextInt();
			int numCols = inFile.nextInt();
			int minVal = inFile.nextInt();
			int maxVal = inFile.nextInt();
			int methodUsed = inFile.nextInt();
			
			PrintWriter writer = new PrintWriter(args[1]);
			writer.println(numRows + " " + numCols + " " + minVal + " " + maxVal);
			
			int imgAry[][] = new int[numRows][numCols];
			
			if (methodUsed == 1){
				for (int i = 0; i < numRows; i++){
					for (int j = 0; j < numCols; j++){
						imgAry[i][j] = 0;
					}
				}
				deCodeMethod1(inFile,writer,imgAry);
			}
			else if (methodUsed == 2){
				for (int i = 0; i < numRows; i++){
					for (int j = 0; j < numCols; j++){
						imgAry[i][j] = 0;
					}
				}
				deCodeMethod2(inFile,writer,imgAry,numCols);
			}
			else if (methodUsed == 3) deCodeMethod3(inFile,writer,imgAry);
			else if (methodUsed == 4) deCodeMethod4(inFile,writer,imgAry,numCols);
			else System.out.println("Method not within 1-4");
					
			for (int i = 0; i < numRows; i++){
				for (int j = 0; j < numCols; j++){
					writer.print(imgAry[i][j] + " ");
				}
				writer.println();
			}
			
			inFile.close();
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
