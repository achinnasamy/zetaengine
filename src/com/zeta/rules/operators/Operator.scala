package com.zeta.rules.operators

import com.zeta.rules.bean.OperandValues
import com.zeta.rules.common.Operate
import com.zeta.rules.operands.Operand

/**
  * Base interface for the operators
  *
  * @author Aravindh Chinnasamy
  */
trait Operator extends Operate {

  def execute(firstOperations : OperandValues, secondOperations : OperandValues, dataMap : collection.mutable.Map[String, String]): Boolean

  protected def executeOperations(oper: OperandValues, dataMap : collection.mutable.Map[String, String]) : Boolean = {

    if (dataMap.keySet.exists(_.equals(oper.operandValueKey))) {

      val operand = instantiateOperands(oper.operandOperator).asInstanceOf[Operand]
      operand.execute(dataMap(oper.operandValueKey), oper.operandValuesValue)

    }
    else false
  }
}
