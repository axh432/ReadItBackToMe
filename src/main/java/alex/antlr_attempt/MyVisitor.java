package alex.antlr_attempt;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import alex.antlr_attempt.parsers.Java8BaseVisitor;

public class MyVisitor<T> extends Java8BaseVisitor<T> {

		
	@Override
	public T visitChildren(RuleNode node) {
		T result = defaultResult();
		
		String format = "%-50s%s%n";
		System.out.printf(format, node.getClass().getSimpleName(), "text: \'" + node.getText() + "\'");
		
		int n = node.getChildCount();
		
		for (int i=0; i<n; i++) {
			ParseTree child = node.getChild(i);
			
			if(child.getClass().getSimpleName().equals("TerminalNodeImpl")){
				String out = "child-terminal: \'" + child.getText() + "\'";
				System.out.printf(format, "", out);
			}else {
				String out = "child-context: " + child.getClass().getSimpleName();
				System.out.printf(format, "", out);
			}
			
		}
		
		System.out.println();
		
		for (int i=0; i<n; i++) {
			if (!shouldVisitNextChild(node, result)) {
				break;
			}
			
			ParseTree c = node.getChild(i);
			
			T childResult = c.accept(this);
			result = aggregateResult(result, childResult);
		}

		return result;
	}
	

}
