import javax.jws.WebService;

@WebService
public class Validate 
{
	public String calculate(String operand1, String operand2, String operation ){
		System.out.println("entered server");
		System.out.println("entered server and the operation is "+operation);
		switch(operation) {
		case "+":
			return Double.toString(Double.parseDouble(operand1)+Double.parseDouble(operand2));
		case "-":
			return Double.toString(Double.parseDouble(operand1)-Double.parseDouble(operand2));
		case "*":
			return Double.toString(Double.parseDouble(operand1)*Double.parseDouble(operand2));
		case "/":
			return Double.toString(Double.parseDouble(operand1)/Double.parseDouble(operand2));
		default:
			String result = "Something went wrong";
			return result;
		}
	}

}
