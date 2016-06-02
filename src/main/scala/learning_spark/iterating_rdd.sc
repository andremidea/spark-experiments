import java.time.LocalDateTime

import org.apache.spark.{SparkConf, SparkContext}
import scala.util.Try
val sc = new SparkContext("local[*]", "learningRDD", new SparkConf()
  .set("spark-executor-memory", "4g")
  .set("spark-driver-memory", "4g")
)
sc.parallelize(1 to 50).sum()
val wow_rdd = sc.textFile("resources/wowah_data.csv")
val chars = wow_rdd.take(10)
chars.foreach(println(_))
// rdd tem tipos?
wow_rdd.cache()
wow_rdd.count()
//case class WowChar(char: String, level: Int, race: String, clazz: String, zone: String, guild: String, time: LocalDateTime) {
//  def this(line: Array[String]) = {
//   this(line(0), line(1).toInt, line(2), line(3), line(4), line(5), LocalDateTime.parse(line(6)))
//  }
//}
// rdd so aceita coisas serializaveis =(
// Quando eu sudo um spark context local ele pega as informacoes de heap da onde?
val small = wow_rdd.sample(false, 0.20, System.currentTimeMillis())
small.map(_.split(","))
  .groupBy(line => line(2))
  .map(x => (x._1, x._2.map(x => Try(x(1).toInt).getOrElse(0)).reduce(_ + _) / x._2.size))
    .collect()

// wow_rdd.map(l => l.split(","))
  //       .reduce(_[1] + _[1])

