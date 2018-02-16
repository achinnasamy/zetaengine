package com.zeta.rules.json

import com.zeta.rules.ZetaUtil
import com.zeta.rules.bean.{OperandValues, Rule}
import scala.collection.mutable.ArrayBuffer

/**
  *
  *
  * @author Aravindh Chinnasamy
  */
class RuleReckoner {

  def readRule(filePath:String) : Rule = {

    val jSONFileReckoner = new RuleFileReckoner
    var completeRule = jSONFileReckoner.readFile(filePath)

    // Remove the first and last
    completeRule = completeRule.substring(1, completeRule.length() - 1).trim;
    new Rule(fetchTheOperator(completeRule), fetchTheOperandAndValues(completeRule))

  }

  private def fetchTheOperator(rule : String) : String = {
    val operator = rule.split(",")(0)

    // Remove the preceding and trailing quotes and retrieve the operator
    ZetaUtil.removeFirstAndLastCharacters(operator.trim)
  }


  private def fetchTheOperandAndValues(rule:String) : List[OperandValues] = {

    var listOfOperandsAndValues = ArrayBuffer.empty[String]
    val numPattern = "\\[(.*?)\\]".r


    numPattern.findAllIn(rule).foreach(each => {
      if (!(each.trim.equals("")))
        listOfOperandsAndValues.+=(ZetaUtil.removeFirstAndLastCharacters(each))
    })


    val operandValues = listOfOperandsAndValues.toList.map(eachElement => {
                val columns = eachElement.split(",")
                var listOfValues = ArrayBuffer.empty[String]

                  for(counter <- 2 to columns.size-1) {
                    listOfValues.+=(ZetaUtil.removeLeadingAndTrailingWhiteSpaces(
                                    ZetaUtil.removeAllQuotes(ZetaUtil.removeLeftSquareBrackets(columns(counter)))))
                  }
                  OperandValues(ZetaUtil.removeFirstAndLastCharacters(columns(0).trim), ZetaUtil.removeFirstAndLastCharacters(columns(1).trim), listOfValues.toList)

    })

    operandValues

  }
}
