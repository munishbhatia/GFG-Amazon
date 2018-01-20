/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/betting-game/0
 */
public class BettingGame
{
   private static int getFinalAmount(String betResults, int startMoney, int firstBetAmount){
      int betAmount = firstBetAmount, currMoney = startMoney;
      for(int i=0; i<betResults.length(); ++i){
         char betResult = betResults.charAt(i);
         if(betResult == 'W'){
            currMoney += betAmount;
            betAmount = 1;
         }
         else if(betResult == 'L'){
            currMoney -= betAmount;
            betAmount*=2;
            if(currMoney < 0 || ((currMoney < betAmount) && (i < betResults.length()-1)))
               return -1;
         }
         else
            throw new InputMismatchException();
      }
      return currMoney;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         String betResults = in.next();
         System.out.println(getFinalAmount(betResults, 4, 1));
      }
   }
}
