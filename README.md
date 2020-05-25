# Inversion of Control (IoC)
Runtime environment (or framework) which inject dependencies. Framework is managing the construction of components 
and placing them in the context, developer is not creating an object because framework is providing an instantiated one.
* Is a technique to allow dependencies to be injected at runtime.
* Dependencies are not predetermined.

# Dependency Inversion vs Dependency Injection
Dependency Inversion addresses abstraction.
Dependency Injection refers into the injection of dependencies into a class.


# Dependency Injection (DI)
Is a mechanism creating connections between class fields and components in context without creating instances of injected components.
* Is where a needed object is injected by another object.
* The class being injected has no responsibility in instantiating the object being injected.

# IoC vs DI:
* DI - refers to composition of classes, ie. you compose your classes with DI in your mind.
* IoC is the runtime environment of your code, ie. Spring Framework's IoC Container. Spring is in control of injection of dependencies.

### Types of dependency injection:
* By class properties - least preferred
    - can be public or private properties
    - using private properties - Spring inject the dependency using reflection at runtime. It is considered as a bad practice (EVIL) - problem with testing 
        (how to inject dependency in private property, it requires extra work). 
* By setters
* By constructor - most preferable because it requires dependencies to be injected when the class is instantiated.


### Concrete classes vs interfaces
* DI can be done with concrete classes or with interfaces.
* Generally DI with concrete classes should be avoided.
* DI via interfaces is highly preferred:
    - Allows runtime to decide which implementation to inject.
    - Follows interface segregation principle of SOLID.
    - Also, makes your code more testable.


#### Best practices with DI:
* Favor using controller injection over setter injection, definitely over property injection.
* Use final properties for injected components to ensure that nothing in our class can change it.
* Whenever practical, use an interface.


### @Qualifier
Annotation tells Spring which bean to inject if there are more than one bean of specific type.

### @Primary bean
Annotation tells Spring which bean should be injected if there are more than one bean of specific type
and none of them has @Qualifier annotation. In other words Spring will choose Primary Bean as default injected bean.

### Spring Profiles
Profiles allow to control Spring application to run in different configuration, ie.
different data sources configuration like H2 for development profile and Oracle databases for production profile.

### Default profile
Tell Spring which profile to use in case none specified in application properties.