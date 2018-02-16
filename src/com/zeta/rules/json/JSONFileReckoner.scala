package com.zeta.rules.json

import scala.io.Source
import scala.util.parsing.json.JSON

/**
  * Elucidator for JSON processing
  *
  * @author Aravindh Chinnasamy
  */
class JSONFileReckoner extends FileReckoner {

  var linearDataMap = collection.mutable.Map[String, String]()

  def readJSONFile(filePath: String): collection.mutable.Map[String, String] = {
    val file = JSON.parseFull(Source.fromFile(filePath).getLines().mkString)
    val dataMap = file.asInstanceOf[Some[Map[String,Any]]]
    recursiveMapIterator(dataMap.get.head._1, dataMap.get.head._2.asInstanceOf[Map[String, Any]])
    linearDataMap
  }

  private def recursiveMapIterator(key : String, input : Map[String, Any]) : Unit = {
    input.foreach(i =>

                        if (i._2.isInstanceOf[Map[String, Any]]) {
                          recursiveMapIterator(key + "." + i._1, i._2.asInstanceOf[Map[String, Any]])
                        }
                        else {
                          linearDataMap += key+"."+i._1 -> i._2.asInstanceOf[String]
                        }
                 )
  }


}
