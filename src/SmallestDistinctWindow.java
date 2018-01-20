/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/smallest-distant-window/0
 */
public class SmallestDistinctWindow
{
   private static int getMinDistinctWindowSize(String input){
      int distinctCharsCount = 0, length = input.length();
      int currDistinctCount = 0, currStart = 0, currEnd = 0, minLength = Integer.MAX_VALUE, minStart = 0, minEnd = 0;
      HashSet<Character> uniqueChars = new HashSet<>();
      Map<Character, Integer> characterFreqMap = new HashMap<>();

      for(int i=0; i<length; ++i) {
         if (!uniqueChars.contains(input.charAt(i))) {
            uniqueChars.add(input.charAt(i));
            ++distinctCharsCount;
         }
      }

      for(int i=0; i<length; ++i) {
         char curr = input.charAt(i);
         if (!characterFreqMap.containsKey(input.charAt(i))) {
            characterFreqMap.put(input.charAt(i), 1);
            ++currDistinctCount;
            if(currDistinctCount == distinctCharsCount){
               currEnd = i;
               while(characterFreqMap.get(input.charAt(currStart))>1) {
                  characterFreqMap.put(input.charAt(currStart), characterFreqMap.get(input.charAt(currStart))-1);
                  ++currStart;
               }
               if(minLength>(currEnd-currStart+1)){
                  minLength = currEnd-currStart+1;
                  minStart = currStart; minEnd = currEnd;
               }
               characterFreqMap.remove(input.charAt(currStart));
               currDistinctCount -= 1;
               ++currStart;
            }
         }
         else
            characterFreqMap.put(input.charAt(i), characterFreqMap.get(input.charAt(i))+1);
      }
//      System.out.println(minStart + ":" + minEnd);
      return minLength;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while (tests-- > 0){
         String input = in.next();
         System.out.println(getMinDistinctWindowSize(input));
      }
   }
}
