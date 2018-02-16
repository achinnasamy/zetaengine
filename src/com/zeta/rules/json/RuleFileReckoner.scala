package com.zeta.rules.json

import scala.io.Source

/**
  * File reader for rule files
  *
  * @author Aravindh Chinnasamy
  */
class RuleFileReckoner  extends FileReckoner {

  override def readFile(filePath: String): String = {
    Source.fromFile(filePath).getLines().mkString
  }
}
