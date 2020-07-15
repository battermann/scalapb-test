package com.example

import io.grpc.ManagedChannelBuilder
import protos.hello._

object Main extends App {
  val channel = ManagedChannelBuilder.forAddress("localhost", 12345).usePlaintext().build
  val request = HelloRequest(name = "World")

  val blockingStub      = GreeterGrpc.blockingStub(channel)
  val reply: HelloReply = blockingStub.sayHello(request)
  println(reply)
}
