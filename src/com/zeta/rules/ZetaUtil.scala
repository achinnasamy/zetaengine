package com.zeta.rules


/**
  * Common utility functions
  *
  * @author Aravindh Chinnasamy
  */
object ZetaUtil {

  def removeFirstAndLastCharacters(input: String) : String = input.trim.substring(1, input.length() - 1)

  def removeLeadingAndTrailingWhiteSpaces(input:String) : String = input.trim.replaceAll("""^\s+(?m)""","")

  def isAllDigits(input: String) = input forall Character.isDigit

  def removeAllQuotes(input:String) : String = input.trim.replaceAll("\"","")

  def removeLeftSquareBrackets(input:String) : String = input.trim.replaceAll("\\[","")

  def instantiateOperator(clazzName : String): Any = Class.forName("com.zeta.rules.operators." + clazzName).newInstance()

 }
