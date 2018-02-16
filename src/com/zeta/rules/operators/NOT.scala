package com.zeta.rules.operators

import com.zeta.rules.bean.OperandValues

/**
  * The NOT operator
  *
  * @author Aravindh Chinnasamy
  */
class NOT extends Operator {

  override def execute(firstOperations: OperandValues,
                       secondOperations: OperandValues,
                       dataMap : collection.mutable.Map[String, String]): Boolean = {

    !executeOperations(firstOperations, dataMap)
  }
}
