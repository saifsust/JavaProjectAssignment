package saifulIslam.AlgorithmForCheck;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReaderMaster extends abstractReader {

	public ReaderMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReaderMaster(String direction) {
		super(direction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void FolderByFolderRead() {
		// TODO Auto-generated method stub

		FolderByFolderList = new ArrayList<File>();
		FolderByFolderList.clear();
		folder = nameRead(super.Direction);

		for (int i = 0; i < folder.length; i++) {
			if (folder[i].isDirectory()) {
				FolderByFolderList.add(folder[i]);
			}
		}

	}

	@Override
	public void FileByFileRead() {
		// TODO Auto-generated method stub

		FileByFileList = new ArrayList<File>();
		FileByFileList.clear();

		folder = nameRead(super.Direction);

		for (int i = 0; i < folder.length; i++) {
			if (folder[i].isFile()) {
				FileByFileList.add(folder[i]);
			}
		}

	}

	public void WordByWordRead() {
		// TODO Auto-generated method stub
		WordByWordList = new ArrayList<>();
		WordByWordList.clear();
		scan = Scan();

		while (scan.hasNext()) {
			WordByWordList.add(scan.next());
		}

		closeFile();

	}

	@Override
	public String LineByLineRead(String direction) {
		super.Direction = direction;
		scan = Scan();
		String mother = null, child = null, str;
		child = "";
		boolean commentFound = false;
		while (scan.hasNext()) {

			mother = scan.nextLine();

			str = "";

			// comment ignor

			str = stringProcessor.ignorBackSlashComment(mother);
			if (str != null) {
				child += str;
				str = "";
				continue;
			}

			str = stringProcessor.ignorBackSlashStar(mother);
			if (str != null && commentFound == false) {
				child += str;
				str = "";
				commentFound = true;
				continue;
			}

			str = stringProcessor.ignorStarBackslash(mother);
			if (str != null && commentFound == true) {
				child += str;
				str = "";
				commentFound = false;
				continue;
			}
			if (commentFound)
				continue;

			// ignor comment end

			// ignor header ,import, package

			if (stringProcessor.ignor(mother))
				continue;

			child += mother;

		}

		child = stringProcessor.ingorSpace(child);
		child = stringProcessor.ignorCaseSensitivity(child);
		///System.out.println(child);

		closeFile();

		return child;

	}

	@Override
	public List<File> FileList(File direction) {

		List<File> list = new ArrayList<File>();
		list.clear();

		// System.out.println(direction.getParent());

		folder = nameRead(direction.getParent() + "/" + direction.getName());

		for (int i = 0; i < folder.length; i++) {
			if (folder[i].isFile()) {
				list.add(folder[i]);
			}
		}
		return list;
	}

}
