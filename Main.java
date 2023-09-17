
import java.util.*;
public class Main
{
    

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Number of Matrices 1 or 2?");
        int numM = console.nextInt();
        if(numM == 1){
            //First Matrice Data 
            System.out.println("First matrice number of rows");
            int rows = console.nextInt();
            System.out.println("First matrice number of col");
            int col = console.nextInt();
            //Initialize Matrix
            Matrix m1 = new Matrix(rows,col);
            
            //Prompt Operations
            String[] operations = {"RREF","Rank"};
            System.out.println("What operation do you want to apply?");
            String operation = console.nextLine();
            if(operation.equals(operations[0])){
                
                RREF(m1);
            }
            else if(operation.equals(operations[1])){
                System.out.println("Rank is " + m1.getRows());
                
            }
        }
        else{
            //First Matrice Data 
            System.out.println("First matrice number of rows");
            int rows = console.nextInt();
            System.out.println("First matrice number of col");
            int col = console.nextInt();
            //Initialize Matrix
            Matrix m1 = new Matrix(rows,col);
            //Second Matrice Data
            System.out.println("Second matrix number of rows");
            int sRows = console.nextInt();
            System.out.println("Second matrix number of col");
            int sCol = console.nextInt();
            Matrix m2 = new Matrix(sRows,sCol);
            String[] operations = {"Addition", "Subtraction", "Multiplication"};
            System.out.println("What operation do you want to apply?");
            String operation = console.nextLine();
            if(operation.equals(operations[0])){
                
                
            }
            else if(operation.equals(operations[1])){
                
            }
            else if(operation.equals(operations[2])){
                
            }
        }
        
        
        
    }
    public static void addMatrice(Matrix m1, Matrix m2){
        if(m1.getRows() != m2.getRows() || m1.getCol() != m2.getCol()){
            System.out.println("Not valid");
        }
        else{
             for(int i = 0;i < m1.getRows();i++){
            for(int j = 0;j < m1.getCol();j++){                
              System.out.print(m1.getVal(i,j) + m2.getVal(i,j) + " ");
              
            }
            System.out.println();
        }
        
        }
    }
    public static void subMatrice(Matrix m1, Matrix m2){
        if(m1.getRows() != m2.getRows() || m1.getCol() != m2.getCol()){
            System.out.println("Not valid");
        }
        else{
             for(int i = 0;i < m1.getRows();i++){
                for(int j = 0;j < m1.getCol();j++){                
                  System.out.print(m1.getVal(i,j) - m2.getVal(i,j) + " ");
              
                }
                System.out.println();
            }
        
        }
        
    }
    public static void multMatrice(Matrix m1, Matrix m2){
        if(m1.getRows() != m2.getCol() || m1.getCol() != m2.getRows()){
            System.out.println("Not valid");
        }
        else{
             int[][] result = new int[m1.getRows()][m2.getCol()];

            for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m2.getCol(); j++) {
                    int sum = 0;
                for (int k = 0; k < m1.getCol(); k++) {
                    sum += m1.getVal(i,k) * m1.getVal(k,j);
                }
                result[i][j] = sum;
            }
            }
            for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
            }
        
        }
        
    }
    public static void scalarMultplications(Matrix m1, int s){
        for(int i = 0;i < m1.getRows();i++){
            for(int j = 0;j < m1.getCol();j++){
                System.out.print(m1.getVal(i, j) * s + " ");
            }
            System.out.println();
        }
        
    }
    public static void determinant(Matrix m1){
        
        if(m1.getRows() != 2 && m1.getCol() != 2){
            System.out.println("Invalid");
        }else{
            int determinant = m1.getVal(0,0) * m1.getVal(1,1) + m1.getVal(0,1) * m1.getVal(1,0); 
            System.out.println(determinant);
        }
        
    }
    public static void RREF(Matrix m1){
        int[][] matrix = m1.matrix;
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        double[][] rrefMatrix = new double[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            System.arraycopy(matrix[i], 0, rrefMatrix[i], 0, numCols);
        }

        int lead = 0;
        for (int row = 0; row < numRows; row++) {
            if (lead >= numCols) {
                break;
            }

            int pivotRow = row;
            while (rrefMatrix[pivotRow][lead] == 0) {
                pivotRow++;
                if (pivotRow == numRows) {
                    pivotRow = row;
                    lead++;
                    if (lead == numCols) {
                        break;
                    }
                }
            }

            if (pivotRow != row) {
                double[] temp = rrefMatrix[row];
                rrefMatrix[row] = rrefMatrix[pivotRow];
                rrefMatrix[pivotRow] = temp;
            }

            double pivotValue = rrefMatrix[row][lead];
            for (int col = 0; col < numCols; col++) {
                rrefMatrix[row][col] /= pivotValue;
            }

            for (int i = 0; i < numRows; i++) {
                if (i != row) {
                    double factor = rrefMatrix[i][lead];
                    for (int col = 0; col < numCols; col++) {
                        rrefMatrix[i][col] -= factor * rrefMatrix[row][col];
                    }
                }
            }

            lead++;
        }
        
    }
    public static void transpose(Matrix m1)
    {
        int[][] x = m1.matrix;
        int[][] y = new int[x.length][x[0].length];
        for(int row = 0; row < x.length; row++)
        {
            for(int col = 0; col < x[row].length; col++)
            {
                y[row][col] = x[col][row];
            }
        }
        for(int i = 0;i < m1.getRows();i++){
            for(int j = 0;j < m1.getCol();j++){
                System.out.print(m1.getVal(i,j) + " ");
            }
            System.out.println();
        }
    }
    
    
}

