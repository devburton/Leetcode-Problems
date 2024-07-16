import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        char[][] board = {
            {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

public static boolean isValidSudoku(char[][] boards) {
    HashSet<String> seen = new HashSet<>();
    for(int i = 0; i < boards[i].length; i++) {
        for(int j = 0; j < boards.length; j++) {
            if(seen.add(boards[i][j] + " at row " + i) &&
            seen.add(boards[i][j] + " at column " + j) && 
            seen.add(boards[i][j] + " at box " + i/3 + "-" + j/3)) return false;
        }
    }
    return true;
}

    /* 
    public static boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            HashMap<Character, Integer> repetitions = new HashMap<Character, Integer>();
            for (char c : row) {
                repetitions.put(c, repetitions.getOrDefault(c, 0) + 1);
            }
            repetitions.remove('.');
            for (Map.Entry<Character, Integer> entry : repetitions.entrySet()) {
                if (repetitions.get(entry.getKey()) >= 2) {
                    System.out.println("not valid row " + Arrays.toString(row));
                    return false;
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            HashMap<Character, Integer> repetitions = new HashMap<Character, Integer>();
            for (int j = 0; j < board.length; j++) {
                repetitions.put(board[j][i], repetitions.getOrDefault(board[j][i], 0) + 1);
            }
            repetitions.remove('.');
            for (Map.Entry<Character, Integer> entry : repetitions.entrySet()) {
                if (repetitions.get(entry.getKey()) >= 2) {
                    System.out.println("not valid collumn");
                    return false;
                }
            }
        }
        HashMap<Character, Integer> repetitions = new HashMap<Character, Integer>();
        for (int offset = 0; offset < 3; offset++) {
            for (int i = 0; i < board.length; i++) {
                if (i == 0 || i == 3 || i == 6)
                    repetitions.clear();
                for (int j = 0; j < board.length / 3; j++) {
                    repetitions.put(board[i][j + offset * 3], repetitions.getOrDefault(board[i][j + offset * 3], 0) + 1);
                }
                repetitions.remove('.');
                if (i == 2 || i == 5 || i == 8) {
                    for (Map.Entry<Character, Integer> entry : repetitions.entrySet()) {
                        if (repetitions.get(entry.getKey()) >= 2) {
                            System.out.println("not valid box " + "i = " + i + " repetitions = "
                                    + repetitions.get(entry.getKey()));
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }*/
}
