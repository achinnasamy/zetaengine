package com.zeta.rules.operands


/**
  * The IN operator for comparing the contents
  *
  * @author Aravindh Chinnasamy
  */
class IN extends Operand {

  override def execute(firstOperand: Any, secondOperand: Any): Boolean = {

    val fop = firstOperand.asInstanceOf[String]
    val secondOperatorList = secondOperand.asInstanceOf[List[String]]

    secondOperatorList.contains(fop)
  }


}
