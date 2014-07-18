package naumen2;




public class RunForSearcher2 {
	public static void main(String args[]){
Searcher Search1 = new Searcher();
		
		String[] classes = new String[] {
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

	    long[] Dates = {
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
		
	    Search1.refresh(classes,Dates);
		
		String[] fin=Search1.guess("Class");
		for(int i=0;i<fin.length;i++){
			System.out.println(fin[i]);
		}
		
		
		System.out.println("done");
	}
}
