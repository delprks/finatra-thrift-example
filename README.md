## Fintra thrift example

### thrift-idl
IDL => Interface definition language
Thrift idl holds the thrift service contract and the generate code. We use the scrooge sbt plugin to generate the rpc service code (scroogeGen).
The thrift-idl is in a seperate project and should be packaged into a jar. This jar can then be used to call the rpc server (thrift-core).
The contract can be found in employee_service.thrift

#### Scrooge
Scrooge allows you to generate the source code for several languages that want to make rpc calls. Use the proper plugin for your language
to generate the rpc contract. In this case we use scala.

* employee_service.thrift

** Finatra is currently limited to hold one thrift service (controller). If you want to have multiple service you have to run multiple rpc server by thrift service (on a different port). **

#### Compile
* Compile => scroogeGen (check plugins.sbt for the scrooge plugin)
* Package => publish or publishLocal

### thrift-core
The thrift core is the RPC server (Bootstrap). The implemenation of the idl can be found in the ThriftController. 
Due that the controller can get big we do not implement directly in the controller but delegate this to the Router.
In this case we have one Router that is injected as a module (ThriftRouter).
Our services always return twitter futures as finatra handle these automatically. **Never block futures**

* Bootstrap => RPC thrift server
* Default port => 9999
* Admin server is enabled by default. Set property to true in Bootstrap if you don't need it.

#### Client white list
The client white list yaml file holds identications of cients that can call the RPC server. 
@see ThriftClientSampleSpec to authenticate you as client.

### Run
* Run the bootstrap
* Run the test ThriftClientSample (bootstrap must be running.) 
