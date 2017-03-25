package saifulIslam.AlgorithmForCheck;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class percentageOfCopy {
	public percentageOfCopy(String mother, String child, String question, double percent) {
		this.motherReg = mother;
		this.childReg = child;
		this.percentage = percent;
		this.questionName = question;

	}

	public double getPercentage() {
		return this.percentage;
	}

	public String getMotherReg() {
		return this.motherReg;
	}

	public String getChildReg() {
		return this.childReg;
	}

	public String getQuestionName() {
		return this.questionName;
	}

	private String motherReg, childReg, questionName;
	private double percentage;
	@Override
	public String toString() {
		return "percentageOfCopy [motherReg=" + motherReg + ", childReg=" + childReg + ", questionName=" + questionName
				+ ", percentage=" + percentage + "]";
	}
}
