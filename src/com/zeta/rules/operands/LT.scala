package com.zeta.rules.operands

import com.zeta.rules.ZetaUtil

/**
  * The LessThan operator measuring the contents
  *
  * @author Aravindh Chinnasamy
  */
class LT extends Operand {

  override def execute(firstOperand: Any, secondOperand: Any): Boolean = {

    val fop = firstOperand.asInstanceOf[String]
    val secondOperatorList = secondOperand.asInstanceOf[List[String]]
    val sop = secondOperatorList(0).asInstanceOf[String]

    if (ZetaUtil.isAllDigits(fop) && ZetaUtil.isAllDigits(sop))
      Integer.parseInt(fop) < Integer.parseInt(sop)
    else
      false
  }


}
