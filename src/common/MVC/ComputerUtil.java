package common.MVC;

/**
 * Created by alex.hernandez on 6/18/16.
 */
public class ComputerUtil {

    public static Computer defaultComputer() {
        Computer computer = new Computer();
        computer.setManufacturer("Asus");
        computer.setModelNumber(4489);
        computer.setMemory(2048);
        return computer;
    }

}
