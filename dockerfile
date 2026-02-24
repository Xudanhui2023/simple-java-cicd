# 1. 基础镜像：使用官方的 OpenJDK 17 运行时环境（轻量版）
# 推荐使用 JDK 17 或 11，因为它们是 LTS（长期支持）版本
FROM openjdk:17-jdk-alpine

# 2. 维护者信息（可选）
LABEL maintainer="xudanhui@example.com"

# 3. 创建工作目录
# 在容器内创建一个目录 /app 作为工作目录
WORKDIR /app

# 4. 复制文件
# 将本地 target 目录下的 JAR 包复制到容器的 /app 目录下
#  注意：请确保这里的文件名与你 pom.xml 中定义的最终构建名称一致
COPY target/simple-java-cicd.jar /app/app.jar

# 5. 暴露端口
# 声明容器运行时监听 8080 端口（对应你 Spring Boot 的 server.port）
EXPOSE 8080

# 6. 启动命令
# 容器启动时执行的命令，运行 Java JAR 包
ENTRYPOINT ["java", "-jar", "app.jar"]