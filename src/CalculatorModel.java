/*
 File name: 	CalculatorModel.java
 Author: 	Amaury Diaz Diaz, 040-738-985
 Course: 	CST8221 – JAP, Lab Section: 302
 Assignment: 1
 Date: 		October 30th 2015
 Professor:  Svillen Ranev
 Purpose: 	Responsible for taking care of the calculations performed in the calculator
 */

/**
 * This class takes care of the calculations performed in the calculator.
 * 
 * @author Amaury Diaz Diaz
 * @version 1.0
 * @since 1.8.0_20
 *
 */
public class CalculatorModel {
	/**
	 * First operand obtained from the calculator
	 */
	private String operand1;
	/**
	 * Second operand obtained from the calculator
	 */
	private String operand2;
	/**
	 * Operational Mode in the calculator (Integer(false) or float(true))
	 */
	private boolean operationalMode;
	/**
	 * Precision set in the calculator (1 place, 2 places or scientific
	 * notation)
	 */
	private String precision;
	/**
	 * Operator used in the calculator (+ - * / sign or "none by default")
	 */
	private String operator;
	/**
	 * Flag that indicates if the calculator is in error state (true if in error
	 * state false otherwise)
	 */
	private boolean errorState;
	/**
	 * Result of the calculations being performed
	 */
	private String result;

	/**
	 * Initializes the fields of the CalculatorModel class to its default values
	 */
	public CalculatorModel() {
		operand1 = "0";
		operand2 = "0";
		operationalMode = true;
		precision = ".00";
		operator = "none";
		errorState = false;
		result = "0";
	}

	public void setOperand1(String operand1) {
		this.operand1 = operand1;
	}

	/**
	 * operand1 field accessor
	 * 
	 * @return A String that contains the operand1 field
	 */
	public String getOperand1() {
		return operand1;
	}

	/**
	 * Used to set the second operand
	 * 
	 * @param operand2
	 *            Decimal The second operand used in the calculations
	 */
	public void setOperand2(String operand2) {
		this.operand2 = operand2;
	}

	/**
	 * operand2 field accessor
	 * 
	 * @return A String that contains the operand2 field
	 */
	public String getOperand2() {
		return operand2;
	}

	/**
	 * Used to set the operational mode (Integer or Float)
	 * 
	 * @param operationalMode
	 *            The Mode in which the calculations are performed (integer ==
	 *            false, float == true)
	 */
	public void setOperationalMode(boolean operationalMode) {
		this.operationalMode = operationalMode;
	}

	/**
	 * operationalMode field accessor
	 * 
	 * @return A boolean that contains the operational field
	 */
	public boolean getOperationalMode() {
		return operationalMode;
	}

	/**
	 * Used to set the precision field.
	 * 
	 * @param precision
	 *            Decimal precision that should be applied to the result
	 */
	public void setPrecision(String precision) {
		this.precision = precision;

	}

	/**
	 * precision field accessor
	 * 
	 * @return A String that contains the precision field
	 */
	public String getPrecision() {
		return precision;
	}

	/**
	 * Used to set the operator.
	 * 
	 * @param operator
	 *            Operator that should be used in the calculation.
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * operator field accessor
	 * 
	 * @return A String that contains the operator field
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Used to set the first operand
	 * 
	 * @param operand1
	 *            The first operand used in the calculations
	 */

	/**
	 * Used to set the errorState field.
	 * 
	 * @param errorState The state of the calculator(true == error false== normal)
	 */
	public void setErrorState(boolean errorState) {
		this.errorState = errorState;

	}

	/**
	 * errorState field accessor
	 * 
	 * @return A boolean that contains the errorState field
	 */
	public boolean getErrorState() {
		return errorState;
	}

	/**
	 * result field accesor
	 * 
	 * @return A String that contains the result after calculations have been
	 *         performed
	 */
	public String getResult() {
		performCalculations();
		return result;
	}

	/**
	 * This method perform the calculations according to the fields previously
	 * set by the actions performed by the user in the Calculator.
	 */
	public void performCalculations() {
		/* Used to store the result of the operations in Integer Mode */
		long resultLong = 0;
		/* Used to store the result of the operations in Float Mode */
		double resultDouble = 0.0;
		/* Calculations performed in Float Mode */
		if (operationalMode) {
			if (operator.equals("+")) {
				resultDouble = (Double.valueOf(operand1) + Double
						.valueOf(operand2));
			} else if (operator.equals("-")) {
				resultDouble = (Double.valueOf(operand1) - Double
						.valueOf(operand2));
			} else if (operator.equals("*")) {
				resultDouble = (Double.valueOf(operand1) * Double
						.valueOf(operand2));
			} else if (operator.equals("/")) {
				resultDouble = (Double.valueOf(operand1) / Double
						.valueOf(operand2));
			} else if (operator.equals("\u00b1")) {
				resultDouble = (Double.valueOf(operand1) * -1);
			}
			/* Used in case of operationalMode change */
			else if (operator.equals("none")) {

				resultDouble = Double.valueOf(operand2);
			}
			/*
			 * In case the result is infinite or not a number set the error
			 * state to true
			 */
			if (Double.isInfinite(resultDouble) || Double.isNaN(resultDouble)) {
				setErrorState(true);
			}
			/* If the result is normal set the appropriate precision */
			else {
				if (resultDouble == 0.0) {
					result = "0.0";
				} else {
					switch (precision) {
					case ".00":
						result = String.format("%.2f", resultDouble);
						break;
					case ".0":
						result = String.format("%.1f", resultDouble);
						break;
					case "Sci":
						result = String.format("%.6E", resultDouble);
					}
				}

			}

		}
		/* Calculations performed in Integer Mode */
		else {
			/*
			 * Prevent that the calculator crashes when a invalid result for the
			 * mode is obtained (Division/0)
			 */
			try {
				if (operator.equals("+")) {
					resultLong = (Long.valueOf(operand1) + Long
							.valueOf(operand2));
					/*
					 * If the result is bigger than Integer maximum value or smaller than Integer minimum value
					 * errorState to true
					 */
					if (resultLong > Integer.MAX_VALUE || resultLong< Integer.MIN_VALUE) {
						setErrorState(true);
					}
				} else if (operator.equals("-")) {
					resultLong = (Long.valueOf(operand1) - Long
							.valueOf(operand2));
					if (resultLong > Integer.MAX_VALUE || resultLong< Integer.MIN_VALUE) {
						setErrorState(true);
					}
				} else if (operator.equals("*")) {
					resultLong = (Long.valueOf(operand1) * Long
							.valueOf(operand2));
					if (resultLong > Integer.MAX_VALUE || resultLong< Integer.MIN_VALUE) {
						setErrorState(true);
					}
				} else if (operator.equals("/")) {
					resultLong = (Long.valueOf(operand1) / Long
							.valueOf(operand2));
					if (resultLong > Integer.MAX_VALUE || resultLong< Integer.MIN_VALUE) {
						setErrorState(true);
					}
				} else if (operator.equals("\u00b1")) {
					resultLong = (Long.valueOf(operand1) * -1);
					if (resultLong > Integer.MAX_VALUE || resultLong< Integer.MIN_VALUE) {
						setErrorState(true);
					}
				}
				/* Used in case of operationalMode change */
				else if (operator.equals("none")) {
					resultDouble = Double.valueOf(operand2);
			
					if (resultDouble > Integer.MAX_VALUE || resultLong< Integer.MIN_VALUE) {
						setErrorState(true);
					} else {
						resultLong = (int) resultDouble;

					}

				}
			} catch (ArithmeticException e) {
				setErrorState(true);
			}
			result = String.valueOf(resultLong);
		}

	}

}
