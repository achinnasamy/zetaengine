package com.zeta.rules.operators

import com.zeta.rules.bean.OperandValues

/**
  * OR operator effectuation
  *
  * @author Aravindh Chinnasamy
  */
class OR extends Operator {

  override def execute(firstOperations: OperandValues, secondOperations: OperandValues, dataMap : collection.mutable.Map[String, String]): Boolean = {
    if (executeOperations(firstOperations, dataMap) || executeOperations(secondOperations, dataMap)) true else false
  }

}
