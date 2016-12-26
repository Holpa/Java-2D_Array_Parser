/**
 * Searching Algorithms
 * 
 * @author Ahmad
 *
 */
public class SearchAlgorithms
{
    public static <T extends Comparable<? super T>> boolean search(T[][] data, T desiredItem)
    {
        
         int rowL = 0;
         int colL = 0;
         int rowH = data.length - 1;
         int colH = data[0].length - 1;
         int rowM, colM;
         
         //findNum(data, rowL, rowH, colL, colH, desiredItem);
         
         //only works for sorted as in Readme file.
         while(rowL <= rowH && colL <= colH)
         {
            rowM = (rowL + rowH)/2;
            colM = (colL + colH)/2;
            
            if(colM == 0)
            {
                if(data[rowM][colM].compareTo(desiredItem) < 0)
                {
                    rowL = rowM + 1;
                }
                else if(data[rowM][colM].compareTo(desiredItem) > 0)
                {
                    rowH = rowM - 1;
                }
                else if(data[rowM][colM].compareTo(desiredItem) == 0)
                {
                    return true;
                }
            }
            
            else
            {
                if(data[rowM][colM].compareTo(desiredItem) < 0)
                {
                    rowL = rowM + 1;
                    colL = colM + 1;
                }
                else if(data[rowM][colM].compareTo(desiredItem) > 0)
                {
                    rowH = rowM - 1;
                    colH = colM - 1;
                }
                else if(data[rowM][colM].compareTo(desiredItem) == 0)
                {
                    return true;
                }
            } 
         }
        
         return false;
    }
    
    /** A brute-force, inefficient search used merely to check
     * the correctness of our more efficient search. 
     */
     public static <T extends Comparable<? super T>> boolean bruteForceSearch(T[][] data, T desiredItem)
     {
         for(int i = 0; i < data.length - 1; i++)
         {
            for(int j = 0; j< data[i].length - 1; j++)
            {
                if(data[i][j].compareTo(desiredItem) == 0)
                {
                    return true;
                }
            }   
         }
         return false;
     }
}
