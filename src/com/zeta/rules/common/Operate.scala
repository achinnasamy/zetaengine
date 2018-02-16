package com.zeta.rules.common


/**
  * Base trait for all operations and operands
  *
  * @author Aravindh Chinnasamy
  */
trait Operate {

  def instantiateOperands(clazzName : String): Any = {
    Class.forName("com.zeta.rules.operands." + clazzName).newInstance()
  }

}
