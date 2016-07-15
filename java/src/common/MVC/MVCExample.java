package common.MVC;

/**
 * Created by alex.hernandez on 6/18/16.
 */
public class MVCExample {

    public static void main(String[] args) {

        //Create a new computer using default computer info
        Computer model = ComputerUtil.defaultComputer();

        //Create a view : to write computer details on console
        ComputerView view = new ComputerView();

        ComputerController controller = new ComputerController(model, view);

        controller.updateView();

        System.out.println("\n\n");

        //Update model data after computer upgrade
        controller.setComputerManufacturer("Dell");
        controller.setModelNumber(3001);
        controller.setMemory(4096);

        controller.updateView();

    }

}
