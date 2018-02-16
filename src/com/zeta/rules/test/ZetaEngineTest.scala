package com.zeta.rules.test

import com.zeta.rules.bean.Rule
import com.zeta.rules.dataruleengine.RuleValidator
import com.zeta.rules.json.{JSONFileReckoner, RuleReckoner}

/**
  * Custom Test class for testing
  *
  * @author Aravindh Chinnasamy
  */
class ZetaEngineTest() {

  val ruleReckoner = new RuleReckoner
  val jSONFileReckoner = new JSONFileReckoner
  val ruleValidator = new RuleValidator

  def test_not_in_operator(): Unit = {

    val rule = ruleReckoner readRule "rules/rule4.txt"
    val jsonDATA = jSONFileReckoner readJSONFile "data/data2.txt"

    assertTrue(ruleValidator.validateRule(jsonDATA, rule))

  }

  def test_or_in_lt_operator(): Unit = {

    val rule = ruleReckoner readRule "rules/rule5.txt"
    val jsonDATA = jSONFileReckoner readJSONFile "data/data1.txt"

    assertTrue(ruleValidator.validateRule(jsonDATA, rule))

  }

  def test_and_in_lt_operator(): Unit = {

    val rule = ruleReckoner readRule "rules/rule6.txt"
    val jsonDATA = jSONFileReckoner readJSONFile "data/data1.txt"

    assertFalse(ruleValidator.validateRule(jsonDATA, rule))

  }

  def test_and_eq_gt_operator(): Unit = {

    val rule = ruleReckoner readRule "rules/rule7.txt"
    val jsonDATA = jSONFileReckoner readJSONFile "data/data1.txt"

    assertTrue(ruleValidator.validateRule(jsonDATA, rule))

  }

  private def assertTrue(input:Boolean) = {
    if (input) println("Test case passed") else println("Test case failed")
  }

  private def assertFalse(input:Boolean) = {
    if (!input) println("Test case passed") else println("Test case failed")
  }
}



