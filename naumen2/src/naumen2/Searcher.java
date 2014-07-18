package naumen2;

import java.util.Arrays;

public class Searcher implements ISearcher {
	long[] modificationDates;
	String[] classNames;

	public void refresh(String[] Names, long[] Dates) {
		modificationDates = Dates.clone();
		classNames = Names.clone();
		CombSortForDates();
		abcSortForNames();
	}

	void CombSortForDates() {
		float loadFactor = 1.247f;
		int step = modificationDates.length;
		boolean end = false;
		while (!end) {
			end = true;
			step /= loadFactor;
			if (step < 1) {
				step = 1;
			}
			for (int i = 0; i < modificationDates.length - 1; i++) {
				if ((i + step) < modificationDates.length) {
					if (modificationDates[i] < modificationDates[i + step]) {
						swap(modificationDates, classNames, i, i + step);
					}
				} else {
					end = false;
				}
			}

		}
	}

	void abcSortForNames() {
		int startSameDate = 0, endSameDate = 0;
		for (int i = 0; i < modificationDates.length - 1; i++) { // сортировка
																	// по имени
			if (modificationDates[i] == modificationDates[i + 1]) {
				startSameDate = i;
				for (int j = i + 1; j < modificationDates.length; j++) {
					if (j == modificationDates.length - 1) {
						endSameDate = j;
						break;
					} else {
						if (modificationDates[j] != modificationDates[j + 1]) {
							endSameDate = j;
							break;
						}
					}
				}
				Arrays.sort(classNames, startSameDate, endSameDate + 1);
				i = endSameDate;
			}
		}

	}

	void swap(long[] Dates, String[] ClassNames, int fromThis, int toThis) {
		String tempString = ClassNames[fromThis];
		long tempLong = Dates[fromThis];

		Dates[fromThis] = Dates[toThis];
		ClassNames[fromThis] = ClassNames[toThis];

		Dates[toThis] = tempLong;
		ClassNames[toThis] = tempString;

	}

	public String[] guess(String start) {
		String[] classNameBuffer = new String[12];
		int countResults = 0;
		
		for (int i = 0; i < classNames.length && countResults < 12; i++) {
			if (classNames[i].startsWith(start)) {
				classNameBuffer[countResults] = classNames[i];
				countResults++;
			}
		}
		return cutArray(classNameBuffer, countResults);
	}

	String[] cutArray(String[] inArray, int howManyCut) {
		String[] outArray = new String[howManyCut];
		
		for (int i = 0; i < howManyCut; i++) {
			outArray[i] = inArray[i];
		}
		return outArray;
	}
}

