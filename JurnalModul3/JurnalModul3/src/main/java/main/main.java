package main;

import model.LaguModel;
import view.LaguView;
import controller.LaguController;

public class main {
    public static void main(String[] args) {
        // Create Model
        LaguModel model = new LaguModel();

        // Create View (GUI)
        LaguView view = new LaguView();
        view.setVisible(true);

        // Create Controller (links Model + View)
        LaguController controller = new LaguController(model, view);
    }
}
