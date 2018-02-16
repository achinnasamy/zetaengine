package com.zeta.rules.operands

import com.zeta.rules.common.Operate

trait Operand extends Operate {

  def execute(firstOperand: Any, secondOperand: Any): Boolean

}
