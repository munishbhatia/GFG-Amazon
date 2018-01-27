package medium; /***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * https://practice.geeksforgeeks.org/problems/twice-counter/0/?ref=self
 */
public class TwiceCounter
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt(), countOfTwo = 0;
         Set<String> moreThanTwo = new HashSet<>();
         Map<String, Integer> wordFrequencyCount = new HashMap<>();
         for(int i=0; i<size; ++i){
            String word = in.next();
            if(moreThanTwo.contains(word));
            if(!wordFrequencyCount.containsKey(word))
               wordFrequencyCount.put(word, 1);
            else{
               if(wordFrequencyCount.get(word) == 1){
                  wordFrequencyCount.put(word, 2);
                  ++countOfTwo;
               }
               else if(wordFrequencyCount.get(word) == 2){
                  moreThanTwo.add(word);
                  wordFrequencyCount.remove(word);
                  --countOfTwo;
               }
            }
         }
         System.out.println(countOfTwo);
      }
   }
}
