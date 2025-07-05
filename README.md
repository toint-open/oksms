# Maven

- [Maven 中央仓库](https://central.sonatype.com/search?q=oksms)

```xml
<dependency>
    <groupId>cn.toint</groupId>
    <artifactId>oksms</artifactId>
    <version>${version}</version>
</dependency>
```

# 开始使用

支持的平台
- 阿里云短信
- 邮箱

使用`OkSmsUtil`可以快捷构造客户端.

使用时开发者需导入对应的依赖与版本才可以使用.

```xml
        <!--邮箱-->
        <dependency>
            <groupId>com.sun.mail</groupId>
            <artifactId>jakarta.mail</artifactId>
            <version>${version</version>
        </dependency>

        <!--腾讯云短信-->
        <dependency>
            <groupId>com.tencentcloudapi</groupId>
            <artifactId>tencentcloud-sdk-java-sms</artifactId>
            <version>${version</version>
        </dependency>

        <!--阿里云短信-->
        <dependency>
            <groupId>com.aliyun</groupId>
            <artifactId>dysmsapi20170525</artifactId>
            <version>${version</version>
        </dependency>
```