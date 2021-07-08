[![New Relic Experimental header](https://github.com/newrelic/opensource-website/raw/master/src/images/categories/Experimental.png)](https://opensource.newrelic.com/oss-category/#new-relic-experimental)

# New Relic Java Instrumentation for Redisson Redis Driver

> Provides instrumentation code for monitoring the Redisson Redis Driver.  Calls to Redis using Redisson will be created under Databases.
> 
> 


## Installation

> Clone this repository to your local disk or follow instructions for installing the latest release.

## Getting Started

Project can be imported into Eclipse or IntelliJ

Eclipse:
 All modules
 ./gradlew eclipse

Individual Module
 ./gradlew moduleName:eclipse
 e.g. ./gradlew redisson-3.5:eclipse

 IntelliJ
 same command except use idea rather than eclipse


## Usage
   
The calls will show up under Databases as Redisson *Redisson_Type* *method*.  
   
![image](https://user-images.githubusercontent.com/8822859/124296144-40a5aa00-db1f-11eb-8030-f1be6c98131a.png)
   
The name of the Redisson object is not captured as part of the query name in Databases as it can lead to metric name explosion.   The name is captured in a distributed trace span as an attribute.  It will be captured as Redisson_Object_Name.    
    
![image](https://user-images.githubusercontent.com/8822859/124296773-f40e9e80-db1f-11eb-8934-8d07cb977172.png)



## Building

> Set the environment variable NEW_RELIC_EXTENSIONS_DIR to the directory where you would like to build the extension jar(s)
>
> To build all modules
> ./gradlew clean install
>
> To build a modules
> ./gradlew moduleName:clean moduleName:install

## Testing

> Run gradle moduleName:test

## Verifying

> To verify that the module will load into the Java Agent used the verifyInstrumentation option
> see https://github.com/newrelic/newrelic-gradle-verify-instrumentation for more information.  
> gradle moduleName:verifyInstrumentation

## Support

New Relic hosts and moderates an online forum where customers can interact with New Relic employees as well as other customers to get help and share best practices. Like all official New Relic open source projects, there's a related Community topic in the New Relic Explorers Hub. You can find this project's topic/threads here:



## Contributing
We encourage your contributions to improve [project name]! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project.
If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company,  please drop us an email at opensource@newrelic.com.

## License
[New Relic Java Instrumentation for Redisson Redis Driver] is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.

