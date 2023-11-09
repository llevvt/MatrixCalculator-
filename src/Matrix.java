import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix {
    private List<List<Double>> matrix = setMatrix();
    public List<List<Double>> setMatrix(){
        List<List<Double>> new_matrix = new ArrayList<>();
        Scanner user_in = new Scanner(System.in);
        System.out.print("Enter your matrix row by row.\n" +
                "Pay attention that you are entering float numbers (e.g. 2.5, 1.0)\n" +
                "Also, please, enter numbers separated by SPACE character\n" +
                "If you are done, just press ENTER...\n");
        while (true) {
            String new_row = user_in.nextLine();
            if (new_row.isEmpty()) {
                break;
            }
            String[] new_rowArray = new_row.split(" ");
            List<Double> row = new ArrayList<>();
            for (String numStr : new_rowArray) {
                double num = Double.parseDouble(numStr);
                row.add(num);
            }
            new_matrix.add(row);
        }
        return new_matrix;
    }
    public void setMatrix(List<List<Double>> new_matrix){
        matrix = new_matrix;
    }

    public List<List<Double>> getMatrix(){
        return matrix;
    }

    public int getMatrixRowSize(){
        return matrix.get(0).size();
    }

    public int getMatrixSize(){
        return matrix.size();
    }

    public List<Double> getRow(int index){
        return matrix.get(index);
    }
    public void setRow(int index, List<Double> row){
        matrix.set(index, row);
    }

    public List<Double> cutRow(int index){
         return matrix.remove(index);
    }

    public void addRow(List<Double> row){
        matrix.add(row);
    }
}
