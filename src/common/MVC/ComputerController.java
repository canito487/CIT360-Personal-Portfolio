package common.MVC;

/**
 * Created by alex.hernandez on 6/18/16.
 */
public class ComputerController {

    private Computer model;
    private ComputerView view;

    public ComputerController(Computer model, ComputerView view) {
        this.model = model;
        this.view = view;
    }

    public void setComputerManufacturer(String manufacturer) {
        model.setManufacturer(manufacturer);
    }

    public String getManufacturer() {
        return model.getManufacturer();
    }

    public Integer getModelNumber() {
        return model.getModelNumber();
    }

    public void setModelNumber(Integer modelNumber) {
        model.setModelNumber(modelNumber);
    }

    public Integer getMemory() {
        return model.getMemory();
    }

    public void setMemory(Integer memory) {
        model.setMemory(memory);
    }

    public void updateView() {
        view.printComputerDetails(model.getManufacturer(), model.getModelNumber(), model.getMemory());
    }

}
