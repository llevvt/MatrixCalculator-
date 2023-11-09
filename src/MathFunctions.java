import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathFunctions {

    public static void gaussAlgorithm(Matrix obj_matrix){
        int matrix_size = obj_matrix.getMatrixSize();
        int row_size = obj_matrix.getMatrixRowSize();
        for (int i = 0; i < matrix_size - 1; i++){
            boolean flag = false;
            for (int d  = i + 1; d < matrix_size; d++) {
                List<Double> cur_row = obj_matrix.getRow(i);
                double divider = cur_row.get(i);
                if (divider != 0) {
                    flag = true;
                    break;
                } else {
                    List<Double> row = obj_matrix.cutRow(i);
                    obj_matrix.addRow(row);
                }
            }
            if (!flag){
                continue;
            }
            for (int j = i + 1; j < matrix_size; j++){
                List<Double> cur_row = obj_matrix.getRow(i);
                List<Double> row = obj_matrix.getRow(j);
                double divider = cur_row.get(i);
                double numerator = row.get(i);
                double multiplier = numerator / divider;
                List<Double> new_row = new ArrayList<>();
                for (int y = 0; y < row_size; y++){
                    double new_elem = row.get(y) - (cur_row.get(y) * multiplier);
                    new_row.add(new_elem);
                }
                obj_matrix.setRow(j, new_row);
                }
        }
    }

    public static List<Double> sleSolution(Matrix obj_matrix) {
        gaussAlgorithm(obj_matrix);
        removeZeroRows(obj_matrix);
        matrixTransformForSLE(obj_matrix);
        gaussAlgorithm(obj_matrix);
        removeZeroRows(obj_matrix);
        matrixTransformForSLE(obj_matrix);
        List<Double> solution = findingSolution(obj_matrix);
        return solution;
    }


    private static void sleMatrixCompilation(Matrix obj_matrix, List<Double> solution_vector) {
        List<List<Double>> matrix = obj_matrix.getMatrix();
        for (int i = 0; i < matrix.size(); i++) {
            List<Double> cur_row = matrix.get(i);
            double cur_elem = solution_vector.get(i);
            cur_row.add(cur_elem);
        }
        obj_matrix.setMatrix(matrix);
    }

    private static void matrixTransformForSLE(Matrix obj_matrix){
        List<List<Double>> matrix = obj_matrix.getMatrix();
        List<List<Double>> new_matrix = new ArrayList<>(matrix);
        Collections.reverse(new_matrix);

        int max_index = matrix.get(0).size() - 1;
        for (List<Double> row : new_matrix) {
            Double lastElement = row.get(max_index);
            row.remove(max_index);
            Collections.reverse(row);
            row.add(lastElement);
        }
    obj_matrix.setMatrix(new_matrix);
    }

    public static void removeZeroRows(Matrix obj_matrix){
        int matrix_size = obj_matrix.getMatrixSize();
        int row_size = obj_matrix.getMatrixRowSize();
        boolean flag = false;
        List<List<Double>> new_matrix = new ArrayList<>();
        for (int i = 0; i < matrix_size; i++){
            List<Double> row = obj_matrix.getRow(i);
            for (int j = 0; j < row_size; j++){
                double num = row.get(j);
                if (num != 0.0){
                    flag = true;
                    break;
                }
            }
            if (flag){
                new_matrix.add(row);
            }
        }
        obj_matrix.setMatrix(new_matrix);
    }

    private static List<Double> findingSolution(Matrix obj_matrix){
        List<Double> right_side = new ArrayList<>();
        int row_len = obj_matrix.getMatrixRowSize();
        int matrix_size = obj_matrix.getMatrixSize();

        for (int i = 0; i < matrix_size; i++){
            List<Double> new_row = obj_matrix.getRow(i);
            double num = new_row.remove(row_len - 1);
            obj_matrix.setRow(i, new_row);
            right_side.add(num);
        }
        row_len = obj_matrix.getMatrixRowSize();
        List<Double> solution = new ArrayList<>();
        for (int i = 0; i < matrix_size; i++){
            List<Double> cur_row = obj_matrix.getRow(i);
            for (int j = 0; j < row_len; j++){
                double num = cur_row.get(j);
                if (num != 0){
                    double solution_value = right_side.get(j) / num;
                    solution.add(solution_value);
                }
            }
        }
        return solution;
    }
}



