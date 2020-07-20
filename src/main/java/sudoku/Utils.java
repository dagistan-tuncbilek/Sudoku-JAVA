package sudoku;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Utils {
	
	public static List<List<Integer>> loadTileGroupsList() {
		
		List<List<Integer>> tempGroupList = new ArrayList<List<Integer>>();
		
		for (int i=0 ; i<81 ; i++) {
			Integer[] intArray = {i/9, i%9+9, ((i/9)/3)*3 + (i % 9)/3 + 18};
			tempGroupList.add(Arrays.asList(intArray));
		}
		return Collections.unmodifiableList(tempGroupList);
		
	}


	public static List<List<Integer>> loadGroupList() {
		
		List<List<Integer>> groupList = new ArrayList<List<Integer>>();
		
		for (int x=0 ; x < 9 ; x++) {
			List<Integer> groupRow = new ArrayList<Integer>();
			List<Integer>  groupCol = new ArrayList<Integer>();
			for (int y=0 ; y < 9 ; y++) {
				groupRow.add(y + x*9);
				groupCol.add(x + y*9);
			}
			groupList.add(x, groupRow);
			groupList.add(groupCol);
		}	
		int [] squareArray = {0,1,2,9,10,11,18,19,20};
		int line=0;
		for (int j = 0 ; j<3 ; j++) {
			for(int k = 0 ; k<3 ; k++) {
				List<Integer> squareList = new ArrayList<Integer>();
				for(int i=0 ; i<9 ; i++) {
					squareList.add(squareArray[i]+k*3+line);
				}
				groupList.add(squareList);
			}
			line+=27;
		}	
		return Collections.unmodifiableList(groupList);
	}

	public static int[] loadSudoku() {
		int[] sudokuArray = new int[81];
		try {
		      File myObj = new File("src/main/resources/sudokuEsas.txt");
		      Scanner myReader = new Scanner(myObj);
		      int col = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String [] row = data.split("");
		        for (int xIndex=0 ; xIndex < row.length ; xIndex++) {
		        	if (!row[xIndex].equals(" ")){
		        		sudokuArray [col+xIndex] = Integer.parseInt(row[xIndex]);
		        	}
		        }
		        col+=9;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		} 
		
		return sudokuArray;
	}


	public static int getFirstTile(int[] solution) {
		for (int i=0 ; i<solution.length ; i++) {
			if(solution[i]==0) return i;
		}
		return -1;
	}
}
