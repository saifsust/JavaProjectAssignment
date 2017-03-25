package saifulIslam.AlgorithmForCheck;

import java.io.File;
import java.util.Comparator;

public class compare implements Comparator<File> {

	@Override
	public int compare(File first, File second) {
		// TODO Auto-generated method stub
		return first.getName().compareTo(second.getName());
	}
}
