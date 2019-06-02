1. 编写 docker-compose.yml 文件

      略
      
2. logstash.conf 

监控4560端口，logback日志的输出将全部输出到4560端口 logstash获取数据 输入到es中，实现监控

3. 启动镜像

docker-compose up -d

4. 相关问题整理

4.1目录无权限问题

即：java.nio.file.AccessDeniedException: /usr/share/elasticsearch/data/nodes

相关目录上执行 chown 1000:1000 data 或 chmod 777 data












