package com.zeta.rules.engine

import com.zeta.rules.dataruleengine.RuleValidator
import com.zeta.rules.json.{JSONFileReckoner, RuleReckoner}
import com.zeta.rules.test.ZetaEngineTest


/**
  * Job which triggers the engine
  *
  * @author Aravindh Chinnasamy
  */
object ZetaEngineJob extends App {

  val zetaTest = new ZetaEngineTest
  zetaTest.test_not_in_operator
  zetaTest.test_or_in_lt_operator
  zetaTest.test_and_in_lt_operator
  zetaTest.test_and_eq_gt_operator

}
