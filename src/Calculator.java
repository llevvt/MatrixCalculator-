import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.print("Hello! Here is a matrix calculator!\n " +
                "There are some options for calculations:\n" +
                "[1] Solve the SLE\n" +
                "==================\n" +
                "To stop Calculator, press 'q'\n");
        while (true) {
            System.out.print("\nInput your option: ");
            String input = user_input.nextLine();
            if (input.equals("q")){
                System.out.print("Bye-bye\n");
                break;
            } else if (input.equals("1")) {
                Matrix obj_matrix = new Matrix();
                List<Double> solution = MathFunctions.sleSolution(obj_matrix);
                System.out.print("Here is your solution: ");
                for (double val : solution){
                    System.out.print(val + ", ");
                }
            }
        }
        user_input.close();
    }
}
