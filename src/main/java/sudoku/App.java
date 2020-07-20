package sudoku;
import java.util.Arrays;
import java.util.List;


public class App {
	
	public static final List<List<Integer>> groupList = Utils.loadGroupList();
	public static final List<List<Integer>> tileGroups = Utils.loadTileGroupsList();
	
	public static void main(String[] args) {
		
		int[] board = Utils.loadSudoku();	
		
		System.out.println("Problem....");
		for(int i = 0 ; i < 81 ; i++) {
			if ((i)%27==0 && i!=0) {
				System.out.println();
			}
			if ((i+1)%9 == 0) {
				System.out.println(board[i] + " ");
			} else if ((i+1)%3 == 0) {
				System.out.print(board[i] + "     ");
			} else {
				System.out.print(board[i] + " ");
			}
		}
		System.out.println("\n");
		long startTime = System.currentTimeMillis();
		
		int[] solution = Arrays.copyOf(board, 81);	
		int firstTile = Utils.getFirstTile(solution);
		if(firstTile == -1) throw new IllegalArgumentException("Problem already solved!!!");
		int [] finalSolution = Calculation.solveTheProblem(solution, groupList, tileGroups, firstTile);
		System.out.println("Solution....");
		if (finalSolution != null) {
			for(int i = 0 ; i < 81 ; i++) {
				if ((i)%27==0 && i!=0) {
					System.out.println("\n");
				}
				if ((i+1)%9 == 0) {
					System.out.println(finalSolution[i] + " ");
				} else if ((i+1)%3 == 0) {
					System.out.print(finalSolution[i] + "     ");
				} else {
					System.out.print(finalSolution[i] + " ");
				}
			}
		} else {
			System.out.println("Not solved.");
		}
		System.out.println();
		System.out.println("Yapılan işlem sayısı : " + Calculation.COUNTER);
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Süre (ms) : " + (endTime - startTime));

	}

	

}
