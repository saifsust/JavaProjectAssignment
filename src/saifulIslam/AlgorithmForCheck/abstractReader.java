package saifulIslam.AlgorithmForCheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class abstractReader  extends matchChecker {


	public abstractReader() {
		// TODO Auto-generated constructor stub
	}

	public abstractReader(String direction) {
		// TODO Auto-generated constructor stub
		this.Direction = direction;
	}

	/*
	 * all abstract method
	 */
	public abstract void FolderByFolderRead();

	public abstract void FileByFileRead();

	public abstract String LineByLineRead(String direction);

	public abstract void WordByWordRead();
	public abstract List<File>  FileList(File direction);
	/*
	 * reader
	 */

	protected File[] nameRead(String directionPath) {
		file = new File(directionPath);
		folder = file.listFiles();
		return folder;
	}

	protected String fullFileScan(String Parent, String Name) {

		path = FileSystems.getDefault().getPath(Parent,Name);
		try {
			FileStream = Files.lines(path);
			Data = FileStream.collect(Collectors.joining(""));
			return Data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected Scanner Scan() {
		try {
			file = new File(Direction);
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			scan = new Scanner(buffer);
			return scan;
		} catch (Exception ex) {
			System.out.println("Can't reader the File");
			ex.printStackTrace();
			return null;
		}
	}

	protected void closeFile() {

		try {
			scan.close();
			buffer.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void CloseStream() {
		FileStream.close();
	}

	/*
	 *
	 * all gettter togather
	 */
	public static List<String> getWordByWordList() {
		return WordByWordList;
	}

	public static List<String> getLineByLineList() {
		return LineByLineList;
	}

	public static List<File> getFileByFileList() {
		return FileByFileList;
	}

	public static List<File> getFolderByFolderList() {
		return FolderByFolderList;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		this.Direction = direction;
	}

	private Path path;
	protected String Direction, Data;
	private final String backSlash = "/";
	protected Stream<String> FileStream;
	protected static Scanner scan;
	protected static File[] folder;
	protected static File file;
	protected static FileReader reader;
	protected static BufferedReader buffer;
	protected static List<String> WordByWordList, LineByLineList;
	protected static List<File> FileByFileList, FolderByFolderList;
}
