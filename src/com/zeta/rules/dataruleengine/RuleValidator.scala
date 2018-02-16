package com.zeta.rules.dataruleengine

import com.zeta.rules.ZetaUtil
import com.zeta.rules.bean.Rule
import com.zeta.rules.operators.Operator

/**
  * Validator triggers all the rules
  *
  * @author Aravindh Chinnasamy
  */
class RuleValidator {


  def validateRule(dataMap : collection.mutable.Map[String, String], rule : Rule) : Boolean = {

      val listOfOperandValueRules = rule.retrieveRule()
      val operatorName = rule retrieveOperator

      val operator = ZetaUtil.instantiateOperator(operatorName).asInstanceOf[Operator]

      var successFactor = false

      if (rule.retrieveRule().size >=2)
        successFactor = operator.execute(rule.retrieveRule()(0), rule.retrieveRule()(1), dataMap)
      else
        successFactor = operator.execute(rule.retrieveRule()(0), rule.retrieveRule()(0), dataMap)

      successFactor

  }



}
