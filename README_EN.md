# weex-java-sdk

A Java sdk for weex exchange API


## api sdk Instructions

1. Add the following dependencies to the pom.xml of the maven project

```xml
<dependency>
    <groupId>com.weex.openapi</groupId>
    <artifactId>weex-java-sdk</artifactId>
    <version>1.0.0-SNAPSHOT</version>
 </dependency>
```

Since the snapshot version is currently released, you need to set the following repository in maven settings.xml or pom.xm

```Xml
  <repository> 
       <id>oss-sonatype</id>
       <url>https://oss.sonatype.org/content/groups/staging/</url>
       <releases>
           <enabled>true</enabled>
           <updatePolicy>always</updatePolicy>
       </releases>

       <snapshots>
           <enabled>true</enabled>
           <updatePolicy>always</updatePolicy>
       </snapshots>
   </repository>
```



2. Create WeexRestClient

```java
    /**
     * User apiKey, which needs to be filled in by the user, 
     * create apikey in https://www.weex.com
     */
    String apiKey = "";

    /**
     * User secretKey, which needs to be filled in by the user, 
     * and can be obtained from https://www.weex.com/user api part
     */
    String secretKey = "";

    /**
     * Passwphrase, which needs to be filled in by the user, obtained from
     * https://www.weex.com/user api part(set by the user when created)
     */
    String passphrase = "";

    /**
     * open api Root path
     */
    String baseUrl = "http://127.0.0.1:8081/api/swap/v3/";

    ClientParameter parameter = ClientParameter.builder()
            .apiKey(apiKey)
            .secretKey(secretKey)
            .passphrase(passphrase)
            .baseUrl(baseUrl)
            .build();

    weexRestClient weexClient = weexRestClient.builder()
                .configuration(parameter)
                .build();
```



3. Interface call

-  After creating weexClient, you can call the service interface to obtain trading pair information as an example

```java
ServerTime serverTime = this.weexClient.contract().market().getTime()
```

- Refer to the test case for other interface calls. In addition, because weex-java-sdk-api uses lombok, please install the lombok plug-in in the compiler

 