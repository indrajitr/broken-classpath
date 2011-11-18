import sbt._
import Keys._

object Simplex3d extends Build {

  val buildSettings = Defaults.defaultSettings ++ Seq (
    scalaSource in Compile <<= baseDirectory(_ / "src")
  )

  // lazy val dummyProjectToFixSbt = Project(
  //   id = "dummy-project",
  //   base = file("."),
  //   settings = buildSettings ++ Seq (
  //     target := new File("target/dummy-project"),
  //     excludeFilter := "*"
  //   )
  // )

  // lazy val working = Project(
  //   id = "working",
  //   base = file("."),
  //   settings = buildSettings ++ Seq (
  //     target := new File("target/working")
  //   )
  // ) dependsOn(Simplex3d.dummyProjectToFixSbt)

  lazy val broken = Project(
    id = "broken",
    base = file("."),
    settings = buildSettings ++ Seq (
      // target := new File("target/broken")
      target <<= target { _ / "broken" }
    )
  )
}
