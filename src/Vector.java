import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vector {
    private List<Double> vector = setVector();

    public List<Double> setVector(){
        List<Double> new_vector = new ArrayList<>();
        Scanner user_in = new Scanner(System.in);
            System.out.print("Enter your vector.\n" +
                    "Pay attention that you are entering float numbers (e.g. 2.5, 1.0)\n" +
                    "Also, please, enter numbers separated by SPACE character\n" +
                    "If you are done, just press ENTER...\n");
            String new_row = user_in.nextLine();
            user_in.close();
            String[] new_rowArray = new_row.split(" ");
            for (String numStr : new_rowArray) {
                double num = Double.parseDouble(numStr);
                new_vector.add(num);
            }
        return new_vector;
    }

    public void setVector(List<Double> new_vector){
        vector = new_vector;
    }

    public List<Double> getVector(){
        return vector;
    }
}

