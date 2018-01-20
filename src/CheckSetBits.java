/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/check-set-bits/0/?ref=self
 */
public class CheckSetBits
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int num = in.nextInt();
         if(0==num)
            System.out.println("NO");
         else{
            double power = Math.log10(num+1)/Math.log10(2); //Performant Way To Check if num is a power of two -> (n&n-1)==0
            int power2 = (int)power;
            if(power==power2)
               System.out.println("YES");
            else
               System.out.println("NO");
         }
      }
   }
}
