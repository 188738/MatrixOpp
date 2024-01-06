import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = console.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int colsA = console.nextInt();

        Matrix matrixA = new Matrix(rowsA, colsA);

        System.out.println("Enter values for Matrix A:");
        for (int i = 0; i < matrixA.getRows(); i++) {
            for (int j = 0; j < matrixA.getCols(); j++) {
                System.out.print("Enter value for Matrix A at position [" + (i) + "][" + (j) + "]: ");
                int val = console.nextInt();
                matrixA.setValue(i, j, val);
            }
        }

        System.out.println("\nMatrix A:");
        matrixA.print();

        System.out.println("Do you want a second Matrix?");
        boolean isMatrixB = console.nextBoolean();

        Matrix matrixB = null;

        if (isMatrixB) {
            System.out.print("Enter the number of rows for Matrix B: ");
            int rowsB = console.nextInt();
            System.out.print("Enter the number of columns for Matrix B: ");
            int colsB = console.nextInt();

            matrixB = new Matrix(rowsB, colsB);

            System.out.println("Enter values for Matrix B:");
            for (int i = 0; i < matrixB.getRows(); i++) {
                for (int j = 0; j < matrixB.getCols(); j++) {
                    System.out.print("Enter value for Matrix B at position [" + (i + 1) + "][" + (j + 1) + "]: ");
                    int val = console.nextInt();
                    matrixB.setValue(i, j, val);
                }
            }

            System.out.println("\nMatrix B:");
            matrixB.print();
        }

        System.out.println("What operation do you want to do on the Matrix?");
        String opp = console.next();

        if (isMatrixB) {
            MatrixOps matrixOps = new MatrixOps();

            if (opp.equals("add")) {
                Matrix result = matrixOps.add(matrixA, matrixB);
                System.out.println("Result of addition:");
                result.print();
            } else if (opp.equals("multiply")) {
                Matrix result = matrixOps.multiply(matrixA, matrixB);
                System.out.println("Result of multiplication:");
                result.print();
            } else if (opp.equals("subtract")) {
                Matrix result = matrixOps.subtract(matrixA, matrixB);
                System.out.println("Result of subtraction:");
                result.print();
            }
        }

        if (opp.equals("RREF")) {
            Matrix result = MatrixOps.rref(matrixA);
            System.out.println("Result of RREF operation:");
            result.print();
        }

        console.close();
    }
}
