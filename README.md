# springboot + elk 
 - 将Spring boot 日志主动推送到Logstash
 
## ELK 搭建
 - https://github.com/a852203465/elk-docker.git
 
## 配置SpringBoot应用向Logstash输入日志

```xml
<dependency>
      <groupId>net.logstash.logback</groupId>
      <artifactId>logstash-logback-encoder</artifactId>
      <version>4.9</version>
</dependency>
```

## 在resource目录添加logback配置

### 第一种：
 - 修改 remoteHost，port 标签值
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="false" scan="false" scanPeriod="30 seconds" >
    <include resource="org/springframework/boot/logging/logback/base.xml"/>
    <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
        <param name="Encoding" value="UTF-8"/>
        <remoteHost>192.168.20.3</remoteHost>
        <port>4560</port>
        <!-- encoder is required -->
        <encoder class="net.logstash.logback.encoder.LogstashEncoder" />
    </appender>
    <logger name="com.unionman" level="TRACE" additivity="false">
        <appender-ref ref="LOGSTASH" />
        <appender-ref ref="CONSOLE" />
    </logger>

    <root level="INFO">
        <appender-ref ref="LOGSTASH" />
        <appender-ref ref="CONSOLE" />
    </root>

</configuration>
```

### 第二种：
 - 修改 destination 标签值
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/base.xml" />

    <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
        <!-- logstash 输入地址  与logstash.conf 配置文件的input对应-->
        <!-- 我这里的logstash相对地址是192.168.10.128 端口是logstash.conf input配置的端口 -->
        <destination>192.168.20.3:4560</destination>
        <!-- "appname":"longji-provider" 的作用是指定创建索引的名字时用，并且在生成的文档中会多了这个字段  -->
        <customFields>{"appname":"longji-provider"}</customFields>
        <encoder charset="UTF-8" class="net.logstash.logback.encoder.LogstashEncoder" />
    </appender>

    <root level="INFO">
        <appender-ref ref="LOGSTASH" />
        <appender-ref ref="CONSOLE" />
    </root>

</configuration>
```
    注意： 选择其中一种配置即可, 并修改xml中的destination

## 启动项目

## 登录 kibana
    浏览器 打开  ip:5601, 创建索引即可查询springboot 测试项目的日志











