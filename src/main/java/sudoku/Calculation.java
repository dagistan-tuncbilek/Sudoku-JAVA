package sudoku;
import java.util.Arrays;
import java.util.List;

public class Calculation {
	
	public static long COUNTER = 0;
	

	public static int[] solveTheProblem (int[] solution, List<List<Integer>> groupList, List<List<Integer>> tileGroups, int firstTile) {
		
		for(int i=1 ; i<10 ; i++) {		
			solution[firstTile]=i;
			boolean isTileRelevant = checkTileRelevance(solution, firstTile);
			int newFirstTile = Utils.getFirstTile(solution);
			
			if (newFirstTile == -1 && isTileRelevant) {
				return Arrays.copyOf(solution, 81);
			}
		
			if (isTileRelevant) {
				int [] newSolution = solveTheProblem(Arrays.copyOf(solution, 81), groupList, tileGroups, newFirstTile);
				if(newSolution != null) {
					return newSolution;
				}			
			} 
		}
		return null;
	}


	private static boolean checkTileRelevance (int[] solution, int tile) {
		
		COUNTER++;
		
		for (int groupNumber : App.tileGroups.get(tile)) {
			for (int groupMember : App.groupList.get(groupNumber)) {
				if (groupMember != tile) {
					if (solution[tile] == solution[groupMember]) return false;
				}
			}
		}
		
		return true;
	}
}
