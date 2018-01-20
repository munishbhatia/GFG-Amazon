/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/steps-by-knight/0
 */
class BoardPoint
{
   private int x, y, level;

   public BoardPoint(int x, int y, int level)
   {
      this.x = x;
      this.y = y;
      this.level = level;
   }

   public int getX()
   {
      return x;
   }

   public int getY()
   {
      return y;
   }

   public int getLevel()
   {
      return level;
   }
}

public class StepsByKnight
{
   private static boolean isInBoardLimits(int x, int y, int size){
      return (x>=0 && x<size && y>=0 && y<size);
   }

   public static List<BoardPoint> getNeighbours(BoardPoint[][] chessBoard, BoardPoint currPoint){
      List<BoardPoint> neighbours = new ArrayList<>(8);
      int x = currPoint.getX(), y = currPoint.getY(), level = currPoint.getLevel(), size = chessBoard.length;

      if(isInBoardLimits(x-1, y+2, size)){
         if(chessBoard[x-1][y+2] == null)
            chessBoard[x-1][y+2] = new BoardPoint(x-1, y+2, level+1);
         neighbours.add(chessBoard[x-1][y+2]);
      }

      if(isInBoardLimits(x+1, y+2, size)){
         if(chessBoard[x+1][y+2] == null)
            chessBoard[x+1][y+2] = new BoardPoint(x+1, y+2, level+1);
         neighbours.add(chessBoard[x+1][y+2]);
      }

      if(isInBoardLimits(x-1, y-2, size)){
         if(chessBoard[x-1][y-2] == null)
            chessBoard[x-1][y-2] = new BoardPoint(x-1, y-2, level+1);
         neighbours.add(chessBoard[x-1][y-2]);
      }

      if(isInBoardLimits(x+1, y-2, size)){
         if(chessBoard[x+1][y-2] == null)
            chessBoard[x+1][y-2] = new BoardPoint(x+1, y-2, level+1);
         neighbours.add(chessBoard[x+1][y-2]);
      }

      if(isInBoardLimits(x-2, y+1, size)){
         if(chessBoard[x-2][y+1] == null)
            chessBoard[x-2][y+1] = new BoardPoint(x-2, y+1, level+1);
         neighbours.add(chessBoard[x-2][y+1]);
      }

      if(isInBoardLimits(x-2, y-1, size)){
         if(chessBoard[x-2][y-1] == null)
            chessBoard[x-2][y-1] = new BoardPoint(x-2, y-1, level+1);
         neighbours.add(chessBoard[x-2][y-1]);
      }

      if(isInBoardLimits(x+2, y+1, size)){
         if(chessBoard[x+2][y+1] == null)
            chessBoard[x+2][y+1] = new BoardPoint(x+2, y+1, level+1);
         neighbours.add(chessBoard[x+2][y+1]);
      }

      if(isInBoardLimits(x+2, y-1, size)){
         if(chessBoard[x+2][y-1] == null)
            chessBoard[x+2][y-1] = new BoardPoint(x+2, y-1, level+1);
         neighbours.add(chessBoard[x+2][y-1]);
      }
      return neighbours;
   }

   private static int getMinStepsToDestination(int size, int startx, int starty, int destx, int desty){
      boolean[][] visited = new boolean[size][size];
      BoardPoint[][] chessBoard = new BoardPoint[size][size];
      Queue<BoardPoint> visitTrace = new LinkedList<>();
      int level = 0;
      chessBoard[startx][starty] = new BoardPoint(startx, starty, level);

      visitTrace.add(chessBoard[startx][starty]);

      while(!visitTrace.isEmpty()){
         BoardPoint curr = visitTrace.remove();
         if(curr.getX() == destx && curr.getY() == desty)
            return curr.getLevel();
         visited[curr.getX()][curr.getY()] = true;
         List<BoardPoint> neighbours = getNeighbours(chessBoard, curr);
         for (BoardPoint neighbour:neighbours){
            if(false == visited[neighbour.getX()][neighbour.getY()])
               visitTrace.add(neighbour);
         }
      }
      return -1; //-1 on GFG Evaluator in case of No Solution
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt();
         int startx = in.nextInt();
         int starty = in.nextInt();
         int destx = in.nextInt();
         int desty = in.nextInt();
         System.out.println(getMinStepsToDestination(size, startx-1, starty-1, destx-1, desty-1));
      }
   }
}
