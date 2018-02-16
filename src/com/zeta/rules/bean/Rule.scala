package com.zeta.rules.bean

/**
  * Bean holder POJO for all rules
  *
  * @author Aravindh Chinnasamy
  */
class Rule(operator : String, operandValueList: List[OperandValues]) {

  def retrieveOperator : String = operator

  def retrieveRule() : List[OperandValues] = operandValueList

}

/**
  * Helper for a rule to hold all operands and its values
  *
  * @author Aravindh Chinnasamy
  */
case class OperandValues(operandOperator : String, operandValueKey: String, operandValuesValue: List[Any])