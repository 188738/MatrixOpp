import java.util.*;
public class Matrix
{
    int numRows;
    int numCol;
    int[][] matrix;
    public Matrix(int numRow, int numCol){
        
        this.numRows = numRow;
        this.numCol = numCol;
        matrix = new int[numRows][numCol];
        
        
        Scanner console = new Scanner(System.in);
        for(int i = 0;i < numRow;i++){
            for(int j = 0;j < numCol;j++){                
              System.out.println("What value for row " + i + " column " + j);
              int val = console.nextInt();
              matrix[i][j] = val;   
              //System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
        
    }
    public int getVal(int row, int col){
        return matrix[row][col];
    }
    
        
        
        
    
    
    public int getRows(){
        return numRows;
    }
    
    public int getCol(){
        return numCol;
    }
    
    
}


