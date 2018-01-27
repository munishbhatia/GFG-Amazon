package medium; /***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/chocolate-station/0
 */
public class ChocolateStation
{
   private static long chocolateBuyingCost(int[] chocolatesAtStations, int chocolatePrice){
      long currChocholates = 0, buyingCost = 0;
      buyingCost += chocolatesAtStations[0]*chocolatePrice;
      for(int i=1; i<chocolatesAtStations.length; ++i){
         currChocholates+=chocolatesAtStations[i-1]-chocolatesAtStations[i];
         if(currChocholates < 0){
            buyingCost+=(currChocholates*-1*chocolatePrice);
            currChocholates=0;
         }
      }
      return buyingCost;
   }
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int stationCount = in.nextInt(), chocolatePrice;
         int[] chocolatesAtStations = new int[stationCount];

         for(int i=0; i<stationCount; ++i)
            chocolatesAtStations[i] = in.nextInt();
         chocolatePrice = in.nextInt();
         System.out.println(chocolateBuyingCost(chocolatesAtStations, chocolatePrice));
      }
   }
}
