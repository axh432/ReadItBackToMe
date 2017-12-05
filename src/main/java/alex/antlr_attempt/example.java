//declaration of the package itself doesnt help us here.
package alex.antlr_attempt;

//declaration of the class itself doesn't really help.
public class example {

	/* public/private - doesnt really effect us we want to give prediction of how the function will act
	 * static - n/a
	 * boolean - n/a we're not really paying attention to what it returns
	 * name - n/a
	 * int value - we're paying attention to the variable id because it will be used again and we 
	 * take note of its type and the possible range of values that it has*/
	public static boolean isOk(int value){
		
		/*if - take note of an if statement
		 *boolean expression - has sub expressions the we would need to look at:
		 *multiplication expression - has two operands
		 *literal expression
		 *use a library to solve algebraic equations?
		 *for now just write the equation needed to trigger the if statement*/
		if(value * 2 == 42){
			//return - take note of return statement and count the steps that have led there.
			//there needs to be a type of program state that can replay the steps.
			return true;
		}else{
			return false;
		}
		
		//output: I intended that if value * 2 equals 42 then return true
		//output: I intended that if value * 2 does not equal 42 then return false
		
	}
	
}
