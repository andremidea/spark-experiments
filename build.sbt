name := "learning-spark"

version := "0.0.0"

scalaVersion := "2.11.8"
sbtVersion := "0.13.9"

resolvers ++= Seq(
  "nu-maven" at "s3://nu-maven/releases/")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.1" % "provided" exclude("org.apache.hadoop", "hadoop-client"),
  "org.apache.spark" %% "spark-sql" % "1.6.1" % "provided",
  "org.apache.spark"  %% "spark-hive" % "1.6.1" % "provided",
  "org.apache.hadoop" % "hadoop-client" % "2.7.2" % "provided" excludeAll ExclusionRule(organization="javax.servlet"),
  "org.apache.hadoop" % "hadoop-aws" % "2.7.2" % "provided" excludeAll ExclusionRule(organization="javax.servlet"),
  "com.databricks" %% "spark-csv" % "1.4.0",
  "common-etl" %% "common-etl" % "0.5.2",

  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

fork in run := true

version := "1.0"

mainClass := Some("learning_spark.LearningRDD")

scalaVersion := "2.11.8"
    