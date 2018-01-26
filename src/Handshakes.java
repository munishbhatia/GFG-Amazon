/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/handshakes/0
 */
public class Handshakes
{
   private static int getNonCrossingHandshakes(int persons){
      return 0;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int persons = in.nextInt();
         System.out.println(getNonCrossingHandshakes(persons));
      }
   }
}
