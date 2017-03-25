package saifulIslam.frameWorkForUser;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Information {

	public Information(String RegNum, Double Marks, Double AverageCopy, Integer Solves) {
		this.Registration_number = new SimpleStringProperty(RegNum);
		this.Marks.setValue(Marks);
		this.AverageCopy.setValue(AverageCopy);
		this.Solves.setValue(Solves);

	}

	public String getRegistration_number() {
		return this.Registration_number.getValue();
	}

	public void setRegistration_number(String registration_number) {
		this.Registration_number.setValue(registration_number);
	}

	public Double getAverageCopy() {
		return this.AverageCopy.getValue();
	}

	public void setAverageCopy(double averageCopy) {
		this.AverageCopy.setValue(averageCopy);
	}

	public Double getMarks() {
		return this.Marks.getValue();
	}

	public void setMarks(double marks) {
		this.Marks.setValue(marks);
	}

	public Integer getSolves() {
		return this.Solves.getValue();
	}

	public void setSolves(int solves) {
		this.Solves.setValue(solves);
	}

	@Override
	public String toString() {
		return "Information [getRegistration_number()=" + getRegistration_number() + ", getAverageCopy()="
				+ getAverageCopy() + ", getMarks()=" + getMarks() + ", getSolves()=" + getSolves() + "]";
	}

	private SimpleStringProperty Registration_number;
	private SimpleDoubleProperty AverageCopy = new SimpleDoubleProperty();
	private SimpleDoubleProperty Marks = new SimpleDoubleProperty();
	private SimpleIntegerProperty Solves = new SimpleIntegerProperty();

}
