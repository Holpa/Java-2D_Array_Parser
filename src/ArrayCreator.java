import java.util.Random;

public class ArrayCreator
{
	
   public static void main(String args[])
   {
      Random generator = new Random();

      final int MAXROW = 5;
      final int MAXCOL = 7;

      // generate a random array of integers
      Integer data[][] = new Integer[MAXROW][MAXCOL];
      for (int r = 0; r < MAXROW; r++)
         for (int c = 0; c < MAXCOL; c++)
         {
             Integer value = generator.nextInt(10);
             data[r][c] = value;
             
             // guarantee is >= to value below it
             if (r > 0 && data[r][c] < data[r-1][c])
                 data[r][c] += data[r-1][c];
             // guarantee is >= to value left of it
             if (c > 0 && data[r][c] < data[r][c-1])
                 data[r][c] += data[r][c-1];
         }     

      System.out.println("The array is:");  
      for (int r = 0; r < MAXROW; r++)
      {
         for (int c = 0; c < MAXCOL; c++)
         {
             System.out.print(data[r][c] + "  ");
         }
         System.out.println();
      }

      System.out.println("Verify that we can find the data in each of the corners");
      System.out.println("Each of the following should be found in the array");
      System.out.println("Found data[0][0] is " + SearchAlgorithms.search(data, new Integer(data[0][0])));
      System.out.println("Found data[0][MAXCOL-1] is " + SearchAlgorithms.search(data, new Integer(data[0][MAXCOL-1])));
      System.out.println("Found data[MAXROW-1][0] is " + SearchAlgorithms.search(data, new Integer(data[MAXROW-1][0])));
      System.out.println("Found data[MAXROW-1][MAXCOL-1] is " + SearchAlgorithms.search(data, new Integer(data[MAXROW-1][MAXCOL-1])));

      System.out.println("Verify that we can find every data value in the array");
      boolean foundAll = true;
      for (int r = 0; r < MAXROW; r++)
      {
         for (int c = 0; c < MAXCOL; c++)
         {
             if (SearchAlgorithms.search(data, new Integer(data[0][MAXCOL-1])) != true)
             {
                 foundAll = false;
                 System.out.println("Could not find data at [" + r + "[]" +c+"]");
             }   
         }
      }

      if (foundAll)
         System.out.println("Found them all");
         
      System.out.println("Verify that we don't find anything that isn't in the array");
      boolean allMatch = true;
      for (int value = data[0][0]-100; value < data[MAXROW-1][MAXCOL-1] + 100; value++)
         if (SearchAlgorithms.search(data, new Integer(value)) != SearchAlgorithms.bruteForceSearch(data, new Integer(value)))
         {
             allMatch = false;
             System.out.println("Search failed on data " + value);
         }
         
      if(allMatch)
         System.out.println("Everything worked");
   } // end main
} // end ArrayCreator

