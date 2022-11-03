#使用openjdk:8u302-jre作为基础镜像来构建，dockerfile必须以from开头
FROM openjdk:8u302-jre
#标记镜像的时区
RUN echo "Asia/Shanghai" > /etc/timezone
#添加环境变量 profile 既标记镜像运行时使用的配置文件
ENV PROFILES druid
#添加环境变量 容器中编码格式
ENV LANG en_US.UTF-8
#添加环境变量 服务虚拟机参数设定
ENV JAVA_OPTS "-Xms500m -Xmx1024m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=256m"
#根据dockerfile所放的位置将jar包copy至容器中的目标位置
COPY hydronedemo-0.0.1-SNAPSHOT.jar /hydronedemo-0.0.1-SNAPSHOT.jar
#执行命令 该命令就是在容器中运行java工程的命令
CMD java $JAVA_OPTS  -Dspring.profiles.active=${PROFILES} -jar --server.port=8080 /hydronedemo-0.0.1-SNAPSHOT.jar
# 暴露8080端口
EXPOSE 8080