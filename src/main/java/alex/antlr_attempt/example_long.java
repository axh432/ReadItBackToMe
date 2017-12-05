package alex.antlr_attempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class example_long {
	
	private String content;
	
	private static class StringComparator implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

	public ArrayList<String> getValues(String pattern, String deadspace){
		
		String contentCopy = content;
		
		pattern = pattern.replace(" ", "");
		contentCopy = contentCopy.replace(" ", "");
		
		String[] removableParts = pattern.split(deadspace);
		
		Arrays.sort(removableParts, new StringComparator());
		
		for(String part : removableParts){
			
			if(part.isEmpty()){
				continue;
			}
			
			contentCopy = contentCopy.replace(part, deadspace);
		}
		
		ArrayList<String> values = new ArrayList<String>();
		String[] arrayValues = contentCopy.split(deadspace);
		
		//get rid of any empty values
		for(String val : arrayValues){
			if(!val.isEmpty()){
				values.add(val);
			}
			
		}
		
		return values;
	}
	
}
