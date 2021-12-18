import javax.swing.*;
import java.util.Scanner;
import java.security.SecureRandom;
public class GameGrid {
    public void run() {
        int xBound = 4; //Change the bounds to change the scale of the game;
        int yBound = 4;
        int[][] iGrid = new int[xBound][yBound];
        int iWallChance = 35; // Change this between 0-100 to set difficulty, higher is harder
        int iUserRow = 0;
        int iUserColumn = 0;
        int iMoveCount = 0;
        boolean bExit = false;
        LinkedList lList = new LinkedList();
        SecureRandom oRand = new SecureRandom();
        Scanner input = new Scanner(System.in);
        for (int y = 0; y < iGrid.length; y++) { // populate the grid leaving top left open
            for (int x = 0; x < iGrid[y].length; x++) {
                iGrid[y][x] = oRand.nextInt(100);
                if (iGrid[y][x] <= iWallChance) {
                    iGrid[y][x] = 1;
                } else {
                    iGrid[y][x] = 0;
                }
                if (y == 0 && x == 0) {
                    iGrid[y][x] = 0;
                }//Uncomment the two system outs if you would like to see the grid before hand
                //System.out.print(iGrid[y][x] + " ");
            }
            //System.out.println();
        }
        while (bExit == false) {
            System.out.println("Right or Down?");
            String iResponse = input.nextLine();
            if (iResponse.equals("Right") || iResponse.equals("right")) {
                iUserRow++;
                lList.addHeadNode(iUserRow, iUserColumn);
            } else if (iResponse.equals("Down") || iResponse.equals("down")) {
                iUserColumn++;
                lList.addHeadNode(iUserRow, iUserColumn);
            } else if (iResponse.equals("exit")) {
                bExit = true;
            }
            if (iGrid[iUserColumn][iUserRow] == 1) {
                System.out.println("Wall hit, Better luck Next Time...");
                bExit = true;
            }
            if (iUserColumn == xBound-1 || iUserRow == yBound-1) {
                System.out.println("You have escaped the dungeon, Great Work!");
                bExit = true;
            }
            System.out.println();
        }
        bExit = false;
        while (bExit == false) {
            Node path;
            path = lList.removeNode();
            if(iGrid[path.yPosition][path.xPosition]==1){ // Shows that a player hit a wall

                iGrid[path.yPosition][path.xPosition] = 6;
            }
            else {
                iGrid[path.yPosition][path.xPosition] = 8;
            }
            iMoveCount++;
            if (path.nextNode == null) {

                bExit = true;
                iGrid[0][0]=8;
                displayGrid(iGrid);
                System.out.println("Moves: "+iMoveCount);
            }
        }
    }

    public void displayGrid(int[][] grid){
        for (int y = 0; y < grid.length; y++) { //Output the resulting grid
            for (int x = 0; x < grid[y].length; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
    }
}




