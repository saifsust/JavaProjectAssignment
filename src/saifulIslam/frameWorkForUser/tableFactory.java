package saifulIslam.frameWorkForUser;

import Database.getFactory;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class tableFactory implements constant {

	public static TableView<Information> getMainTable(ObservableList<Information> list) {

		setReg_numberColumn();

		setCopyColumn();
		setSolvesColumn();
		setMarksColumn();
		mainTable.getColumns().addAll(Reg_number,marks,copy,solves);
		mainTable.setItems(list);
		return mainTable;
	}

	public static TableView<Information> getCopyTable(ObservableList<Information> list) {

		setReg_numberColumn();
		setCopyColumn();
		copyTable.getColumns().addAll(Reg_number,copy);
		copyTable.setItems(list);
		return copyTable;
	}

	private static void setMarksColumn() {
		marks.setCellValueFactory(new PropertyValueFactory<Information, Double>("Marks"));
		marks.setPrefWidth(tableColumnPrefWidth);
		marks.setResizable(false);
		// marks.setStyle("-fx-background-color: YELLOW;");

	}

	private static void setSolvesColumn() {
		solves.setCellValueFactory(new PropertyValueFactory<Information, Integer>("Solves"));
		solves.setPrefWidth(tableColumnPrefWidth);
		solves.setResizable(false);
		// solves.setStyle("-fx-background-color: YELLOW;");

	}

	private static void setCopyColumn() {
		copy.setCellValueFactory(new PropertyValueFactory<Information, Double>("AverageCopy"));
		copy.setPrefWidth(tableColumnPrefWidth);
		copy.setResizable(false);
		// copy.setStyle("-fx-background-color: RED;");

	}

	private static void setReg_numberColumn() {
		Reg_number.setCellValueFactory(new PropertyValueFactory<Information, String>("Registration_number"));
		Reg_number.setPrefWidth(tableRegPrefWidth);
		Reg_number.setResizable(false);
		// Reg_number.setStyle("-fx-background-color: GREEN;");

	}

	private static TableColumn<Information, Double> copy = new TableColumn<>("Copy");
	private static TableColumn<Information, Integer> solves = new TableColumn<>("Solves");
	private static TableColumn<Information, String> Reg_number = new TableColumn<>("Reg_number");
	private static TableColumn<Information, Double> marks = new TableColumn<>("Marks");
	private static TableView<Information> mainTable = new TableView<>();
	private static TableView<Information> copyTable = new TableView<>();

}
