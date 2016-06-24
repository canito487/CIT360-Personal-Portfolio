package common.MVC;

/**
 * Created by alex.hernandez on 6/18/16.
 */
public class MVCExample {

    public static void main(String[] args) {

        //fetch student record based on his roll no from the database
        Computer model = ComputerUtil.defaultComputer();

        //Create a view : to write student details on console
        ComputerView view = new ComputerView();

        ComputerController controller = new ComputerController(model, view);

        controller.updateView();

        System.out.println("\n\n");

        //update model data
        controller.setComputerManufacturer("Dell");
        controller.setModelNumber(3001);
        controller.setMemory(4096);

        controller.updateView();

    }

}
