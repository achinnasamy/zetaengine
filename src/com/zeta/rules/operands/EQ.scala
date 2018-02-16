package com.zeta.rules.operands

/**
  * The Equals operator for comparison
  *
  * @author Aravindh Chinnasamy
  */
class EQ extends Operand {

  override def execute(firstOperand: Any, secondOperand: Any): Boolean = {

    val secondOperatorList = secondOperand.asInstanceOf[List[String]]

    if (firstOperand.isInstanceOf[String] && secondOperatorList(0).isInstanceOf[String])
      firstOperand.asInstanceOf[String].equals(secondOperatorList(0).asInstanceOf[String])
    else if (firstOperand.isInstanceOf[Int] && secondOperatorList(0).isInstanceOf[Int])
      firstOperand.asInstanceOf[Int] == (secondOperatorList(0).asInstanceOf[Int])
    else
      false
  }


}
