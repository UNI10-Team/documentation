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
Annotation created by [lombok](https://projectlombok.org/), marks a class to create a static inner class implementing the Builder design pattern. 

Also, in the example below, we will find __@Singular__ if we want for a Collection field to add members one by one and __@Builder.Default__ if we want a default value for a field.

```java
@Builder
public class Pizza {

    @Singular private List<String> toppings;
    @Builder.Default private String sauce = "Ketchup";
    private long radius;
    private int price;
    private boolean isSpecialOffer;
}
```

The code from above generates the following [Pizza.class](Pizza.java) and the following behaviour.

```java
 List<String> toppings = Arrays.asList("Corn", "Ananas", "Bacon");
Pizza pizza = Pizza.builder()
        .price(100)
        .toppings(toppings)
        .topping("Mushroom")
        .topping("Tomato")
        //.sauce("Mayo")
        .build();
```

@EnableScheduling
---
Annotation used to activate the [@Scheduled](#scheduled) methods. Can be used for either the SpringApplication main class, or any [@Component](#component). One annotation is enough for all the methods to trigger.

```java
@Configuration
@EnableScheduling
public class SchedulingConfiguration {
}
```

@Scheduled
---
Annotation used to mark a method that should run multiple times, at fixed delay, and an initial delay, both in miliseconds.

```java
@Scheduled(fixedDelay = 1000, initialDelay = 1000)
public void deleteLogs(){
    // delete the logs
}
```

@Profile
---
Annotation used to mark components that should only be instantiated when running a specific profile.

```java
@Component
@Profile("dev")
public class Logger{
}
```
The above class will be instatiated only when the profile is setted to __dev__.
```properties
spring.profiles.active=dev
```

@Transactional
---
Annotation used for the Repository interfaces, to enable ```fetch = FetchType.LAZY``` on __[@OneToMany]()__, __[@OneToOne]()__, __[@ManyToOne]()__ and __[@ManyToMany]()__, marks a field that can be fetched later from the database
```java
@Transactional
public interface HumanRepository extends JpaRepository<Human, Long>{
}
```

@Data
---
Annotation created by [lombok](https://projectlombok.org/), marks a class to create a getters, settes, toString, equals and hashcode at compile time.
```java
@Data
public class Human {
    private long id;
    private String name;
    private int age;
}
```

@Valid
---
Annotation used to check if a http resource sent to a [@RestController](#restcontroller) is valid
```java
@ValidHuman
public class Human {
    private int age;
    private String name;
    // ... constructors, getters, setters
}
```
```java
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HumanValidator.class)
public @interface ValidHuman {

    String message() default "Human is not valid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
```
```java
public class HumanValidator implements ConstraintValidator<ValidHuman, Human> {

    @Override
    public void initialize(ValidHuman constraintAnnotation) {
    }

    @Override
    public boolean isValid(Human value, ConstraintValidatorContext context) {
        return value.getAge() > 0 && !value.getName().equals("");
    }
}
```
Usage:
```java
@PostMapping
    public void save(@RequestBody @Valid Human human){
        // save to database
    }
```

@Constraint
---
See [@Valid](#valid).

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
Annotation used to enable web security, role based.
Can be used for either the SpringApplication main class, or any [@Component](#component). One annotation is enough for all the methods to trigger.

@RolesAllowed
---
Annotation used to mark a class or method that should run only if the current user has one of the roles.
It is the same as __@Secured__.

```java
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER}")
public void createNote(){
    // ... create note here
}
```

@PrePersist
---
Annotation marking a method that should run before an entity is saved into the database.

@Column
---
Annotation decorating a field of an [@Entity](#entity) that should be stored in the database.
Can be specified: 
1. name
2. nullable
3. unique



@Entity
---
Annotation used to mark classes that should be stored in the database.

@Id
---
Annotation used to mark the primary key of a __@Entity__.
If it is a number, __@GeneratedValue__ can be used to automatically generate a new value.

@Table
---
Annotation used to decorate classes that should be stored in the database.
The following can be specified
1. name
2. schema

@Enumerated
---
Annotation used to mark a field that is an enum, or collection of enums. It has to be used together with __@ElementCollection__.

```java
@Enumerated
@ElementCollection(targetClass = Role.class)
private Set<Role> roles = new HashSet<>();
```

@Query
---
Annotation used to describe the __SQL__ command of an method, if it can not be automatically generated.

```java
public interface HumanRepository extends JpaRepository<Human, Long>{
    @Query("select h from human h")
    List<Human> findAll();

}
```