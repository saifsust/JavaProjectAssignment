package saifulIslam.AlgorithmForCheck;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import Database.databaseCreationFactory;
import Database.dropFactory;
import Database.insertionFactory;
import Database.tableCreationFactory;

/*
 * <h1> SAIFUL ISLAM </h1>
 *
 * SUST CSE 2013
 * Reg 201331007
 * Mobile 01686654727
 *
 *
 *
 */
public class cheatChecker extends ReaderMaster {
	public static final String direction = "dataStore";
	public static double maxMarks= 20,minMarks=0.0;
    public static int problems = 11;
	public void Processor() {

		setDirection(direction);
		FolderByFolderRead();
		listFirst = new ArrayList<File>();
		listSecond = new ArrayList<File>();

		int size = getFolderByFolderList().size();
		double motherMax;
		double motherCopy = 0.0;
		/**
		 * database Name setUp
		 */
		dropFactory.dropDatabase(databaseName);
		databaseCreationFactory.setDatabaseName(databaseName);
		tableCreationFactory.createInformationTable(databaseName);

		/*
		 *
		 * data Name setUp finished
		 */

		int solves ;
		for (int i = 0; i < size; i++) {

			/*
			 * Individual Table Creation Finished
			 *
			 */
			String motherName = FolderByFolderList.get(i).getName();
			tableCreationFactory.createIndividualDataTable(databaseName, motherName);

			listFirst.clear();
			listFirst = FileList(FolderByFolderList.get(i));
			Collections.sort(listFirst, new compare());

			solves = listFirst.size();
			totalCopy=0.0;
			for (int j = 0; j < solves; j++) {

				/*
				 * Create Percentage Of Copy Table Finished
				 */
				String childName = stringProcessor.ignorDot(listFirst.get(j).getName());
				// System.out.println(childName);
				// dropFactory.dropTable(database,motherName+childName);
				tableCreationFactory.createPercentageOfCopyTable(databaseName, motherName + childName);

				mother = LineByLineRead(listFirst.get(j).getParent() + "/" + listFirst.get(j).getName());

				motherMax = 0.0;

				for (int k = 0; k < size; k++) {

					if (k == i)
						continue;

					listSecond.clear();
					listSecond = FileList(FolderByFolderList.get(k));
					Collections.sort(listSecond, new compare());

					String RegNum = FolderByFolderList.get(k).getName();

					int Index = Collections.binarySearch(listSecond, listFirst.get(j), new compare());

					if (Index >= 0) {
						child = LineByLineRead(
								listSecond.get(Index).getParent() + "/" + listSecond.get(Index).getName());

						long match = CopyPaste(mother, child);

						if (match > -1) {
							motherCopy = 100.0;
							insertionFactory.insertPercentageOfCopy(databaseName, motherName + childName, RegNum,
									100.00);
						} else {

							double lcsSize = LCS.lcsCheck(mother, child);
							motherCopy =Math.floor((lcsSize / (mother.length() - 1) * 1.0) * 100.0);
							insertionFactory.insertPercentageOfCopy(databaseName, motherName + childName, RegNum,
									motherCopy);

						}

					} else {
						insertionFactory.insertPercentageOfCopy(databaseName, motherName + childName, RegNum, 0.00);

					}
					if (motherMax < motherCopy) {
						motherMax = motherCopy;
					}

				}

				totalCopy += motherMax;
				insertionFactory.insertIndividualData(databaseName, motherName, motherName, childName, motherMax);

			}
            double deserveMarks = (maxMarks/(double) problems)*solves; 
            double averageCopy = Math.floor(totalCopy/solves);
            double Marks = Math.ceil(deserveMarks*(1.0-averageCopy/100.0));
			insertionFactory.insertInformation(databaseName, motherName, averageCopy,solves,Marks);
		}

		FolderByFolderList.clear();

	}

	private static double totalCopy=0.0;
	private static String mother, child;
	protected static List<File> listFirst, listSecond;
	protected static List<String> wordList;
	private final String databaseName = direction;
}
