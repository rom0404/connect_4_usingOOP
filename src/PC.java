import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PC extends player{
    public PC( ) {
        super("Bot", 2);
    }

    @Override
    public void make_a_move(board game_board) {
        boolean placed = false;

        //checking for a winning move
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j < 7; j++) {
                //vertical
                if (i>2){
                    if (game_board.grid[i][j] == 0 &&
                            this.getID() == game_board.grid[i - 1][j] &&
                            this.getID() == game_board.grid[i - 2][j] &&
                            this.getID() == game_board.grid[i - 3][j]) {
                        game_board.place_disc(2,j);
                        placed = true;
                    }
                }


                //horizontal(right)
                if(!placed && j>2){
                    if (game_board.grid[i][j] == 0 &&
                            this.getID()==game_board.grid[i][j-1] &&
                            this.getID()==game_board.grid[i][j-2] &&
                            this.getID()==game_board.grid[i][j-3]){
                        game_board.place_disc(2,j);
                        placed=true;
                    }
                }

                //horizontal(left)
                if(!placed && j<4){
                    if (game_board.grid[i][j] == 0 &&
                            this.getID()==game_board.grid[i][j+1] &&
                            this.getID()==game_board.grid[i][j+2] &&
                            this.getID()==game_board.grid[i][j+3]){
                        game_board.place_disc(2,j);
                        placed=true;
                    }
                }

                //positive diagonal
                if(!placed && i>2 && j>2){
                    if (game_board.grid[i][j] == 0 &&
                            this.getID()==game_board.grid[i-1][j-1] &&
                            this.getID()==game_board.grid[i-2][j-2] &&
                            this.getID()==game_board.grid[i-3][j-3]){
                        game_board.place_disc(2,j);
                        placed=true;
                    }
                }

                //negative diagonal
                if(!placed && i>2 && j<4){
                    if (game_board.grid[i][j] == 0 &&
                            this.getID() == game_board.grid[i - 1][j + 1] &&
                            this.getID() == game_board.grid[i - 3][j + 2] &&
                            this.getID() == game_board.grid[i - 3][j + 3]) {
                        game_board.place_disc(2,j);
                        placed = true;
                    }
                }
                if (placed){
                    break;
                }
            }
        }
        if (!placed){
            //checking for opponent winning move
            for (int i = 0; i <6 ; i++) {
                for (int j = 0; j < 7; j++) {
                    //vertical
                    if (i>2){
                        if (game_board.grid[i][j] == 0 &&
                                1 == game_board.grid[i - 1][j] &&
                                1 == game_board.grid[i - 2][j] &&
                                1 == game_board.grid[i - 3][j]) {
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }


                    //horizontal(right)
                    if(!placed && j>2){
                        if (game_board.grid[i][j] == 0 &&
                                1==game_board.grid[i][j-1] &&
                                1==game_board.grid[i][j-2] &&
                                1==game_board.grid[i][j-3]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //horizontal(left)
                    if(!placed && j<4){
                        if (game_board.grid[i][j] == 0 &&
                                1==game_board.grid[i][j+1] &&
                                1==game_board.grid[i][j+2] &&
                                1==game_board.grid[i][j+3]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //positive diagonal(right)
                    if(!placed && i>2 && j>2){
                        if (game_board.grid[i][j] == 0 &&
                                1==game_board.grid[i-1][j-1] &&
                                1==game_board.grid[i-2][j-2] &&
                                1==game_board.grid[i-3][j-3]){
                            game_board.place_disc(2,j);
//                            System.out.println("positive diagonal block");
                            placed=true;
                        }
                    }

                    //positive diagonal(left)
                    if(!placed && i<4 && j<3){
                        if (game_board.grid[i][j] == 0 &&
                                1==game_board.grid[i+1][j+1] &&
                                1==game_board.grid[i+2][j+2] &&
                                1==game_board.grid[i+3][j+3]){
                            game_board.place_disc(2,j);
//                            System.out.println("positive diagonal block");
                            placed=true;
                        }
                    }

                    //negative diagonal(right)
                    if(!placed && i>2 && j<4){
                        if (game_board.grid[i][j] == 0 &&
                                1 == game_board.grid[i - 1][j + 1] &&
                                1 == game_board.grid[i - 2][j + 2] &&
                                1 == game_board.grid[i - 3][j + 3]) {
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }

                    //negative diagonal(left)
                    if(!placed && i<3 && j>2){
                        if (game_board.grid[i][j] == 0 &&
                                1 == game_board.grid[i + 1][j - 1] &&
                                1 == game_board.grid[i + 2][j - 2] &&
                                1 == game_board.grid[i + 3][j - 3]) {
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }


                    if (placed){
                        break;
                    }
                }
            }
        }


        if (!placed){
            //checking for a major threat generating move
            for (int i=0;i<6;i++){
                for (int j = 0; j < 7; j++) {
                    //vertical
                    if (i>1){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID() == game_board.grid[i - 1][j] &&
                                this.getID() == game_board.grid[i - 2][j]) {
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }


                    //horizontal(right)
                    if(!placed && j>1 && j<6){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID()==game_board.grid[i][j-1] &&
                                this.getID()==game_board.grid[i][j-2] &&
                                0==game_board.grid[i][j+1]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //horizontal(left)
                    if(!placed && j<5 && j>0){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID()==game_board.grid[i][j+1] &&
                                this.getID()==game_board.grid[i][j+2] &&
                                0==game_board.grid[i][j-1]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //positive diagonal(right)
                    if(!placed && i>1 && j>1 &&j<6){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID()==game_board.grid[i-1][j-1] &&
                                this.getID()==game_board.grid[i-2][j-2] &&
                                0==game_board.grid[i+1][j+1]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //positive diagonal(left)
                    if(!placed && i>1 && j>1 &&j<6){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID()==game_board.grid[i-1][j-1] &&
                                this.getID()==game_board.grid[i-2][j-2] &&
                                0==game_board.grid[i+1][j+1]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //negative diagonal
                    if(!placed && i>1 && j<5 && j>0){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID() == game_board.grid[i - 1][j + 1] &&
                                this.getID() == game_board.grid[i - 2][j + 2] &&
                                0 == game_board.grid[i+1][j-1]) {
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }
                    if (placed)
                        break;
                }
            }
        }

        if (!placed){
            //checking for an opponent's major threat generating move
            for (int i=0;i<6;i++){
                for (int j = 0; j < 7; j++) {
                    //vertical
                    if (i>1){
                        if (game_board.grid[i][j] == 0 &&
                                1 == game_board.grid[i - 1][j] &&
                                1 == game_board.grid[i - 2][j]) {
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }


                    //horizontal(right)
                    if(!placed && j>1 && j<6){
                        if (game_board.grid[i][j] == 0 &&
                                1==game_board.grid[i][j-1] &&
                                1==game_board.grid[i][j-2] &&
                                0==game_board.grid[i][j+1]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //horizontal(left)
                    if(!placed && j<5 && j>0){
                        if (game_board.grid[i][j] == 0 &&
                                1==game_board.grid[i][j+1] &&
                                1==game_board.grid[i][j+2] &&
                                0==game_board.grid[i][j-1]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //positive diagonal
                    if(!placed && i>1 && j>1 &&j<6){
                        if (game_board.grid[i][j] == 0 &&
                                1==game_board.grid[i-1][j-1] &&
                                1==game_board.grid[i-2][j-2] &&
                                0==game_board.grid[i+1][j+1]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //negative diagonal
                    if(!placed && i>1 && j<5 && j>0){
                        if (game_board.grid[i][j] == 0 &&
                                1 == game_board.grid[i - 1][j + 1] &&
                                1 == game_board.grid[i - 2][j + 2] &&
                                0 == game_board.grid[i+1][j-1]) {
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }
                    if (placed)
                        break;
                }
            }
        }
        if (!placed){
            //checking for a 2 generating major threat
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    //vertical
                    if (i>0){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID() == game_board.grid[i - 1][j]){
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }


                    //horizontal(right)
                    if(!placed && j>0 &&j<5){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID()==game_board.grid[i][j-1] &&
                                0==game_board.grid[i][j+1] &&
                                0==game_board.grid[i][j+2]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //horizontal(left)
                    if(!placed && j<6 && j>1){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID()==game_board.grid[i][j+1] &&
                                0==game_board.grid[i][j-1] &&
                                0==game_board.grid[i][j-2]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //positive diagonal
                    if(!placed && i>0 && j>1 && j<5){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID()==game_board.grid[i-1][j-1] &&
                                0==game_board.grid[i+1][j+1] &&
                                0==game_board.grid[i+2][j+2]){
                            game_board.place_disc(2,j);
                            placed=true;
                        }
                    }

                    //negative diagonal
                    if(!placed && i>0 && j<6 && j>1){
                        if (game_board.grid[i][j] == 0 &&
                                this.getID() == game_board.grid[i - 1][j + 1] &&
                                0 == game_board.grid[i+1][j-1] &&
                                0 == game_board.grid[i+2][j-2]) {
                            game_board.place_disc(2,j);
                            placed = true;
                        }
                    }


                    if (placed)
                        break;
                }
            }
        }
        if (!placed){
            game_board.place_disc(2,3);
        }
    }
    public void makeMove(board game_board){
        float winningValues[]=new float[7];
        float losingValues[]=new float[7];
        int playableRow=0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (game_board.grid [i][j]==0){
                    playableRow=j;
                    break;
                }
                float verticalWin=0.5F;
                float verticalLose=0;

                float horizontalWin=0.5F;
                float horizontalLose=0;

                float positiveDiagonalWin=0.5F;
                float positiveDiagonalLose=0.5F;

                float negativeDiagonalWin=0.5F;
                float negativeDiagonalLose=0.5F;



                if (j==playableRow){
                //vertical
                try{
                    for (int k = 0; k < 3; k++) {
                        if (game_board.grid[i-k][j]==2){
                            verticalWin++;
                        } else if (game_board.grid[i-k][j]==1) {
                            verticalLose++;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                    for (int k = 0; k < 4; k++) {
                        //horizontal
                        try {
                            if (game_board.grid[i][j + k - 3] == 2) {
                                horizontalWin++;
                            } else if (game_board.grid[i][j + k - 3] == 1) {
                                horizontalLose++;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                        //positive diagonal
                        try {
                            if (game_board.grid[i + k - 3][j + k - 3] == 2) {
                                positiveDiagonalWin++;
                            } else if (game_board.grid[i + k - 3][j + k - 3] == 1) {
                                positiveDiagonalLose++;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                        //negative diagonal
                        try {
                            if (game_board.grid[i + k - 3][j - k + 3] == 2) {
                                negativeDiagonalWin++;
                            } else if (game_board.grid[i + k - 3][j - k + 3] == 1) {
                                negativeDiagonalLose++;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                    }
                }
                losingValues[j] = Math.max(verticalLose, horizontalLose);
                losingValues[j] = Math.max(losingValues[j], positiveDiagonalLose);
                losingValues[j] = Math.max(losingValues[j], negativeDiagonalLose);

                winningValues[j] = Math.max(verticalWin, horizontalWin);
                winningValues[j] = Math.max(winningValues[j], positiveDiagonalWin);
                winningValues[j] = Math.max(winningValues[j], negativeDiagonalWin);
            }
        }
        int bestRow=3;
        float bestValue=0.6F;
        for (int j = 0; j < 7; j++) {
            if (winningValues[j]>bestValue){
                bestValue=winningValues[j];
                bestRow=j;
            }
            if (losingValues[j]>bestValue){
                bestValue=losingValues[j];
                bestRow=j;
            }
        }
        game_board.place_disc(2,bestRow);
    }
}
