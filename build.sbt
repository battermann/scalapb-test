name         := "scalapb-test"
scalaVersion := "2.13.2"

libraryDependencies ++= {
  val scalaPbVersion = "0.10.1"
  Seq(
    "com.thesamet.scalapb" %% "scalapb-runtime"      % scalapb.compiler.Version.scalapbVersion % "protobuf",
    "com.thesamet.scalapb" %% "scalapb-json4s"       % scalaPbVersion,
    "io.grpc"              % "grpc-netty"            % scalapb.compiler.Version.grpcJavaVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion
  )
}

PB.targets in Compile := Seq(
  // scalapb.gen() -> (sourceManaged in Compile).value / "scalapb"
  scalapb.gen(grpc = true) -> (sourceManaged in Compile).value / "scalapb"
)

sourceDirectories in Compile += baseDirectory(_ / "src" / "main" / "protobuf").value
