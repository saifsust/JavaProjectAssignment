package saifulIslam.frameWorkForUser;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Individual {

	public Individual(String RegNum, String Questions, double copy) {
		this.RegNum.setValue(RegNum);
		this.copy.setValue(copy);
		this.Questions.setValue(Questions);
	}

	/**
	 * @return the questions
	 */
	public String getQuestions() {
		return this.Questions.getValue();
	}

	/**
	 * @return the regNum
	 */
	public String getRegNum() {
		return this.RegNum.getValue();
	}

	/**
	 * @return the copy
	 */
	public double getCopy() {
		return this.copy.getValue();
	}

	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setQuestions(String Questions) {
		this.Questions.setValue(Questions);
	}

	/**
	 * @param regNum
	 *            the regNum to set
	 */
	public void setRegNum(String RegNum) {
		this.RegNum.setValue(RegNum);
	}

	/**
	 * @param copy
	 *            the copy to set
	 */
	public void setCopy(double copy) {
		this.copy.setValue(copy);
	}

	private StringProperty Questions = new SimpleStringProperty();
	private StringProperty RegNum = new SimpleStringProperty();
	private DoubleProperty copy = new SimpleDoubleProperty();
}
