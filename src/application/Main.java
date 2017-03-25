package application;

import java.io.File;

import Database.getFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import saifulIslam.AlgorithmForCheck.cheatChecker;
import saifulIslam.frameWorkForUser.mainFrame;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//new mainFrame(primaryStage);
		new mainFrame().init(primaryStage);

	}

	/*
	 *
	 */
	public static void main(String[] args) {


		//System.out.println(stringProcessor.ignorDot("liton.djfhdj"));


		//  getFactory.getObservableListOfInformations("dataStore");


		cheatChecker cc = new cheatChecker();
		//cc.Processor();
		/*
		for(int i=0;i<getFactory.getObservableListOfInformations("dataStore").size();i++)
		{
			System.out.println(getFactory.getObservableListOfInformations("dataStore").get(i));
		}*/
		 launch(args);
	}
}
