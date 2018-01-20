/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem/0/?ref=self
 */
class BFSQueueNode{
   private int node, level;

   public BFSQueueNode(int node, int level)
   {
      this.node = node;
      this.level = level;
   }

   public int getNode()
   {
      return node;
   }

   public int getLevel()
   {
      return level;
   }
}

class GameBoard{
   private List<Integer>[] boardGraph; //It'll be a DIRECTED graph
   private int size;

   public GameBoard(int nodes){
      size = nodes+1;
      boardGraph = new ArrayList[size];
      for(int i=1; i<size; ++i){
         boardGraph[i] = new ArrayList<>(7);
         for(int j=1; j<=6; ++j)
            if(i+j<=nodes)
               this.addEdge(i, i+j);
      }
   }

   public int getSize()
   {
      return size;
   }

   public void addEdge(int source, int destination){
      if(!boardGraph[source].contains(destination))
         boardGraph[source].add(destination);
   }

   public void destroyEdges(int source){
      if(!(source >= size))
         boardGraph[source].clear();
   }

   public List<Integer> getNeighbours(int source){
      if(source >= size)
         return null;
      return boardGraph[source];
   }
}

public class SnakesAndLadder
{
   private static int minMovesToFinish(GameBoard gameBoard, Map<Integer, Integer> ladders){
      int size = gameBoard.getSize();
      boolean[] visited = new boolean[size];
      Queue<BFSQueueNode> bfsQueue = new LinkedList<>();
      int start = 1;
      bfsQueue.add(new BFSQueueNode(start, 0));

      while (!bfsQueue.isEmpty()){
         BFSQueueNode curr = bfsQueue.remove();
         if(curr.getNode() == size-1)
            return curr.getLevel();
         for(int neighbour:gameBoard.getNeighbours(curr.getNode())){
            if(!visited[neighbour]){
               if(ladders.containsKey(curr.getNode()) && ladders.get(curr.getNode()) == neighbour) //It's a ladder; Don't increase level
                  bfsQueue.add(new BFSQueueNode(neighbour, curr.getLevel()));
               else
                  bfsQueue.add(new BFSQueueNode(neighbour, curr.getLevel()+1));
            }
         }
      }
      return -1;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      Map<Integer, Integer> ladders = new HashMap<>();
      while(tests-- > 0){
         int snakesAndLaddersCount = in.nextInt();
         GameBoard snakeAndLadderBoard = new GameBoard(30);
         //Scan Snake and Ladder Edges
         for(int i=0; i<snakesAndLaddersCount; ++i) {
            int src = in.nextInt(), dest = in.nextInt();
            snakeAndLadderBoard.addEdge(src, dest);
            if(dest>src)
               ladders.put(src, dest);
            if(dest<src) //It's a snake; remove all the other edges from this node;
               snakeAndLadderBoard.destroyEdges(src);
         }
         System.out.println(minMovesToFinish(snakeAndLadderBoard, ladders));
      }
   }
}
