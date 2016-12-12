package calculatorServer;
import javax.jws.WebService;
@WebService
public class calculator {
	public String Calculator(String operand1, String operand2, String Operation){
		System.out.println("entered server");
		String result;
		switch(Operation) {
		case "+":
			result = operand1 + operand2;
			return result;
		case "-":
			result = operand1 + operand2;
			return result;
		case "*":
			result = operand1 + operand2;
			return result;
		case "/":
			result = operand1 + operand2;
			return result;
		default:
			result = "Something went wrong";
			return result;
		}
	}
}
