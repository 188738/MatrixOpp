import java.util.*;
public class Matrix
{
    int numRows;
    int numCol;
    int[][] matrix;
    public Matrix(int numRow, int numCol){
        
        this.numRows = numRows;
        this.numCol = numCol;
        matrix = new int[numRows][numCol];
    }
    public void generateMatrix(int rows, int col){
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < col;j++){
                 //Do this now Ritvik Thota(Jagan ka Bache)
            }
        }
        
        
    }
    
    public int getRows(){
        return numRows;
    }
    
    public int getCol(){
        return numCol;
    }
    
    
}
