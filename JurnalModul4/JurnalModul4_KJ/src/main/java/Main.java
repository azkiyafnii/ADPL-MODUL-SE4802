import controller.BukuController;
import model.Database;
import view.BukuView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database model = new Database();
        BukuView view = new BukuView();
        new BukuController(model, view);
        view.setVisible(true);
	}

}
