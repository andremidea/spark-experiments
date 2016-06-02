/**
  * Created by andremidea on 6/1/16.
  */
package learning_spark

import org.apache.spark.{SparkConf, SparkContext}

object LerningRDD {

  def start(): Unit = {
    val sc = new SparkContext("local[*]", "learningRdd", new SparkConf())
    println(sc.parallelize(1 to 20000).sum())

    val wowRdd = sc.textFile("wowah_data.csv")
    wowRdd.take(10)

  }

  def main(argv: Array[String]): Unit =  {
    start()

  }

}
//