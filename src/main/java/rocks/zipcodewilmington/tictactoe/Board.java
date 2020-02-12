package rocks.zipcodewilmington.tictactoe;

public class Board {

    int size = 3;
    public Character[][] main ;

    public Board(Character[][] matrix) {
        main = matrix;
    }

    public Boolean isInFavorOfX() {
        boolean win = false;
        for(int i=0; i<size; i++){
            if(checkRow(main, i, 'X')){
                win = true;
            }
            if(checkCol(main, i, 'X')){
                win = true;
            }
        }
        if(checkDiaLeft(main,'X')){
            win = true;
        }
        if(checkDiaRight(main,'X')) {
            win = true;
        }
        return win;
    }

    public Boolean isInFavorOfO() {
        boolean win = false;
        for(int i=0; i<size; i++){
            if(checkRow(main, i, 'O')){
                win = true;
            }
            if(checkCol(main, i, 'O')){
                win = true;
            }
        }
        if(checkDiaLeft(main,'O')){
            win = true;
        }
        if(checkDiaRight(main,'O')){
            win = true;
        }
        return win;
    }

    public Boolean isTie() {
        return !isInFavorOfO() && !isInFavorOfX();
    }

    public String getWinner() {
        String res = "";
        if(isInFavorOfO()){
            res = "O";
        }else if(isInFavorOfX()){
            res = "X";
        }else{
            res = "";
        }
        return res;
    }

    //check if a raw in the matrix all contains a certain character
    public boolean checkRow(Character[][] array, int targetRow, Character who){
        int counter = 0;
        for(int i=0; i<array[targetRow].length;i++){
            if(array[targetRow][i].equals(who)){
                counter++;
            }
        }
        return counter == array[targetRow].length;
    }

    //check if a col in the matrix all contains a certain character
    public boolean checkCol(Character[][] array, int targetCol, Character who){
        int counter = 0;
        for(int i=0; i<array.length; i++){
            if(array[i][targetCol].equals(who)){
                counter++;
            }
        }
        return counter == array[targetCol].length;
    }

    //check if the left diagonal row in the matrix all contains a certain character
    public boolean checkDiaLeft(Character[][] array,Character who){
        //[0][0]
        //[1][1]
        //[2][2]
        int counter = 0;
        for(int i=0; i<array.length; i++){
            if(array[i][i].equals(who)){
                counter++;
            }
        }
        return counter==array.length;
    }

    //check if the right diagonal row in the matrix all contains a certain character
    public boolean checkDiaRight(Character[][] array,Character who){
        //[0][2]
        //[1][1]
        //[2][0]
        int counter = 0;
        int j = array.length-1;
        for(int i=0; i<array.length; i++){
            if(array[i][j].equals(who)){
                counter++;
            }
            j--;
        }
        return counter==array.length;
    }
}
