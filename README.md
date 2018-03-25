# Spring Boot Starter [FTSI](https://github.com/bndynet/ftsi)

Spring Boot Starter Project for Full Text Search Interface (https://github.com/bndynet/ftsi)


## Usage

**Maven**

Visit http://mvnrepository.com/artifact/net.bndy/spring-boot-starter-ftsi to get more versions.

```xml
<dependency>
  <groupId>net.bndy</groupId>
  <artifactId>spring-boot-starter-ftsi</artifactId>
  <version>1.0-pre</version>
</dependency>
```

**File: application.yml**

```yml
spring:
  ftsi:
    analyzer: org.apache.lucene.analysis.standard.StandardAnalyzer      # define your analyzer, StandardAnalyzer is the default analyzer if empty 
    data-path: ./ft-folder                                              # the path to store full text index files
    highlight-pre-tag: <b class="highlight">                            # the beginning part of html tag for highlight matched text
    highlight-post-tag: </b>                                            # the ending part of html tag for highlight matched text
    highlight-fragment-size: 300                                        # the length of returned text which contains highlight content
```

**Java Code**

```java

@SpringBootApplication
public class Application {

  @Autowired
  private IndexService indexService;

  public static void main(String[] args) { 
    SpringApplication.run(Application.class, args); 
    // start to use indexService...
  }
}

```

NOTE: Click [here](https://github.com/bndynet/ftsi) to get started for `IndexService`. 