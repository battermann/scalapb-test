# scalapb-test

Generating gRPC stubs should be enabled by default according to the documentation: https://scalapb.github.io/sbt-settings.html#grpc

But it looks like it is not. It needs to be explicitly enabled. With the line 15 in the `build.sbt` it doesn't work:

```scala
scalapb.gen() -> (sourceManaged in Compile).value / "scalapb"
```

The object `com.example.protos.hello.GreeterGrpc` is not generated.

Like this it works:

```scala
scalapb.gen(grpc = true) -> (sourceManaged in Compile).value / "scalapb"
```

Now the object `com.example.protos.hello.GreeterGrpc` is not generated.
