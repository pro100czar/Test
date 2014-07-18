package naumen2;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class testseacher {

	int sizeArrays = 100000;
	String[] globalClassNames = generateClasses(sizeArrays);
	long[] globalDates = generateDates(sizeArrays);
	
	
	long[] generateDates(int sizeArray){
		long[] Dates= new long[sizeArray];
		Random generatorArrayElements = new Random();
			for (int i = 0; i < sizeArray; i++) {
				Dates[i] = System.currentTimeMillis()
						- generatorArrayElements.nextInt(10) * 1000;
				// modificationDates[i]=1404897399300l;
			}	
			return Dates;
	}
	
	String[] generateClasses(int sizeArray){
		String[] classNames = new String[sizeArray];
		String ForClassGenerator = "ABCDEFGHIJKLMNOPQRSTUVWZ";
		Random generatorArrayElements = new Random();
			for (int i = 0; i < sizeArray; i++) {
				classNames[i] = "Class"
						+ ForClassGenerator.charAt(generatorArrayElements
								.nextInt(22))
						+ generatorArrayElements.nextInt(10);
				// modificationDates[i]=1404897399300l;
			}	
			return classNames;
	}
	
	@Test
	public void testBaseLogic3() {
		Searcher searcher3 = new Searcher();
		searcher3.refresh(globalClassNames, globalDates);
		String[] actualResult = searcher3.guess("Class");
		
	}
	
	//@Ignore
	@Test
	public void testBaseLogic() {
		int ArraySize = 100000;
		int MultiTestTimes = 1000;
		int BigTestTimes = 1; //=1 for one time
		boolean MultiTestRefresh = true;
		boolean MultiTestGuess = false;
		boolean AdvancedMultiTestGuess = false;
		boolean showArrays = false;
		boolean cloneTest = false;
		long[] Dates = new long[ArraySize];
		String searchName = "Class";
		String[] classNames = new String[ArraySize];
		Random generatorArrayElements = new Random();
		String ForClassGenerator = "ABCDEFGHIJKLMNOPQRSTUVWZ";
		
		for (int k = 0; k < BigTestTimes; k++) {
			for (int i = 0; i < ArraySize; i++) {
				classNames[i] = "Class"
						+ ForClassGenerator.charAt(generatorArrayElements
								.nextInt(22))
						+ generatorArrayElements.nextInt(10);
				Dates[i] = System.currentTimeMillis()
						- generatorArrayElements.nextInt(10) * 1000;
				// modificationDates[i]=1404897399300l;
			}
			
			Searcher searcher = new Searcher();
			searcher.refresh(classNames.clone(), Dates.clone());
			
			if (MultiTestRefresh) {
				for (int i = 0; i < MultiTestTimes; i++) {
					searcher.refresh(classNames.clone(), Dates.clone());
				}
			}
			
			if (MultiTestGuess) {
				for (int i = 0; i < MultiTestTimes; i++) {
					String[] actualResult = searcher.guess("Class");
				}
			}
			
			if (AdvancedMultiTestGuess) {
				for (int i = 0; i < MultiTestTimes; i++) {
					String[] actualResult = searcher.guess("Class"
							+ ForClassGenerator.charAt(generatorArrayElements
									.nextInt(22)));
				}
			}
			
			if (cloneTest) {
				String[] forCloneTestClasses;
				long[] forCloneTestDates;
				for (int i = 0; i < MultiTestTimes; i++) {
					forCloneTestClasses = classNames.clone();
					forCloneTestDates = Dates.clone();
				}
			}
			
			String[] actualResult = searcher.guess(searchName);
			if (showArrays) {
				System.out
						.println("---------------------------------------------------------");
				for (int i = 0; i < actualResult.length; i++) {
					System.out.println(actualResult[i]);
				}
			}
		}
	}

        //Assert.assertArrayEquals(expectedResult, actualResult);
    
	
	 @Test
	    public void testBaseLogic2()
	    {
	        String[] classNames = new String[] {
	                "ClassA1",
	                "ClassA2",
	                "ClassA3",
	                "ClassA4",
	                "ClassA5",
	                "ClassA6",
	                "ClassA7",
	                "ClassA8",
	                "ClassA9",
	                "ClassB" ,
	                "ClassC" ,
	                "ClassD1",
	                "ClassD2"
	        };

	        long[] modificationDates = {
	                1322191917000l,
	                1322191918000l,
	                1322191913000l,
	                1322191913000l,
	                1322191913000l,
	                1322191913000l,
	                1322191913000l,
	                1322191913000l,
	                1322191913000l,
	                1322191914000l,
	                1322191915000l,
	                1322191916000l,
	                1322191916000l
	        };


	        Searcher searcher = new Searcher();
	        searcher.refresh(classNames, modificationDates);
	        String[] actualResult = searcher.guess("Class");

	        String[] expectedResult = new String[] {
	                "ClassA2",
	                "ClassA1",
	                "ClassD1",
	                "ClassD2",
	                "ClassC",
	                "ClassB",
	                "ClassA3",
	                "ClassA4",
	                "ClassA5",
	                "ClassA6",
	                "ClassA7",
	                "ClassA8"
	        };

	        Assert.assertArrayEquals(expectedResult, actualResult);
	    }
}
