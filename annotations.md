Annotations
===

@SpringApplication
---
Annotation used to bootstrap a class and launch a Spring app from a simple Java main method.

The SpringApplication._run_ method return a __ConfigurableApplicationContext__ object, that can be used for searching for available beans.

```java

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
```

@Component
---
Annotation used as decorator for a class that should automatically be instantiated in a Spring app. It results in having a bean of that class.

The name of the bean, not the class will be assigned by default. If you want multiple instances, use [@Bean](#bean) and specify their name.

Also, most important annotations derived from __@Component__ are:

1. [@Service](#service)
2. [@RestController](#restcontroller)
3. [@Configuration](#configuration)

```java

@Component
public class Logger {

    public void log(String message){
        System.out.println(message);
    }

}
```

@Bean
---
Annotation used as decorator for a method returning an object (so the method is not *void*) that should automatically run. It results in having a bean of the type returnd, similarly to [@Component](#component). However, this methods need to be put in a class that is sure to be instantiated.

```java
@Bean
public Logger logger() {
    return new Logger();
}
```

If you want multiple instances, specify the name of the beans.

```java

@Bean(name = "host")
public String dataBaseHost() {
    return "amazon.rds.mysql.com";
}


@Bean(name = "hostFallBack")
public String dataBaseHostFallback() {
    return "localhost;
}
```

@Autowired
---
Annotation used to specify which constructor of a class annotated with [@Component](#component)(or one of its derived forms) should be used to instantiate that class.

```java
@Configuration
public class WebConfiguration {

    @Autowired
    public WebConfiguration(Logger l) { 
        // this constructor will be called
        // a bean of Logger class will searched
    }

    public WebConfiguration(){
        System.out.println("I am not instantiated through THIS constructor");
    }

```

@PostConstruct
---
Annotation used to mark a method of a class marked as [@Component](#component) that should run immediately after the instantiation of that class. 

```java
@Component
public class Connection {

    @Autowired
    public Connection(String host, int port) { 
    }

    @PostConstruct
    public void connect(){
        // create the actual connection    
    }

```

@PreDestroy
---
Annotation used to mark a method of a class marked as [@Component](#component) that should run before the destroying of an instance the of that class. 

```java
@Component
public class Connection {

    // ... other methods

    @PreDestroy
    public void connect(){
        // close the connection    
    }

```

@Configuration
---
Annotation derived from __@Component__. Marks a configuration class.

```java
@Configuration
public class WebConfiguration {

    // ... some methods
}
```

@RestController
---
Annotation derived from __@Component__. Marks a REST resource class.

The REST resource class should also have a [@RequestMapping](#requestmapping) annotation for the entire class, and one for every method used as an _endpoint_, containing the path and the method.

```java
@RestController
@RequestMapping("/user")
public class UserController {

    // ... some methods
}
```

@RequestMapping
---
The base annotation for the more known:
1. [@GetMapping](#getmapping)
2. [@PostMapping](#postmapping)
3. [@PutMapping](#putmapping)
4. [@DeleteMapping](#deletemapping)
5. [@PatchMapping](#deletemapping)


@Service
---
Annotation derived from __@Component__.

```java
@Service
public class UserService {

    // ... some methods
}
```

@Builder
---
Annotation created by [lombok](https://projectlombok.org/), marks a class to create a static inner class after the Builder design pattern. 

```java

```

```java

```

@EnableScheduling
---


@Scheduled
---
@Profile
---
@Transactional
---
@Data
---
@Valid
---
@Constraint
---

@GetMapping
---
@PostMapping
---
@PutMapping
---
@DeleteMapping
---
@PatchMapping
---
@Cacheable
---
@EnableSecurity
---
@PreDestroy
---
@PrePersist
---
@Column
---
@Entity
---
@Table
---
@Enumerated
---
@Column
---
@Query
---
@Data
---
@ToString
---
@EqualsAndHashcode
---
@RabbitListener
---
@RolesAllowed
---