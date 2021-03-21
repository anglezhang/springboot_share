# springboot_share

#### Spring Boot 深入分享示例代码

### Spring Boot 自动装配

#### 理解Spring Boot自动装配

`@SpringBootApplication` 用于激活 `@SpringBootConfiguration` `@EnableAutoConfiguration` `@ComponentScan`

观察代码运行结果，是一致的

##### 读取候选装配组件

```java
/**
 * Return the auto-configuration class names that should be considered. By default
 * this method will load candidates using {@link SpringFactoriesLoader} with
 * {@link #getSpringFactoriesLoaderFactoryClass()}.
 * @param metadata the source metadata
 * @param attributes the {@link #getAttributes(AnnotationMetadata) annotation
 * attributes}
 * @return a list of candidate configurations
 */
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata,
      AnnotationAttributes attributes) {
   List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
         getSpringFactoriesLoaderFactoryClass(), getBeanClassLoader());
   Assert.notEmpty(configurations,
         "No auto configuration classes found in META-INF/spring.factories. If you "
               + "are using a custom packaging, make sure that file is correct.");
   return configurations;
}
```

SpringFactoriesLoader 是 Spring Framework工厂机制的加载器，加载原理

* 搜索指定ClassLoader 下所有 META-INF/spring.factories 资源内容，允许存在多个
* 将META-INF/spring.factories 资源内容作为 Properties文件读取，合并作为一个 Key为接口的全类名Value是实现类全类名的列表
* 再从上一步返回的Map查找指定类名所映射的实现类全类名列表

##### `@EnableAutoConfiguration` 排除自动装配组件

```java
/**
 * Return any exclusions that limit the candidate configurations.
 * @param metadata the source metadata
 * @param attributes the {@link #getAttributes(AnnotationMetadata) annotation
 * attributes}
 * @return exclusions or an empty set
 */
protected Set<String> getExclusions(AnnotationMetadata metadata,
      AnnotationAttributes attributes) {
   Set<String> excluded = new LinkedHashSet<>();
   excluded.addAll(asList(attributes, "exclude"));
   excluded.addAll(Arrays.asList(attributes.getStringArray("excludeName")));
   excluded.addAll(getExcludeAutoConfigurationsProperty());
   return excluded;
}
```

获得自动装配排除的Class的名单

##### `@EnableAutoConfiguration`过滤自动装配组件

```java
private List<String> filter(List<String> configurations,
      AutoConfigurationMetadata autoConfigurationMetadata) {
   long startTime = System.nanoTime();
   String[] candidates = StringUtils.toStringArray(configurations);
   boolean[] skip = new boolean[candidates.length];
   boolean skipped = false;
   for (AutoConfigurationImportFilter filter : getAutoConfigurationImportFilters()) {
      invokeAwareMethods(filter);
      boolean[] match = filter.match(candidates, autoConfigurationMetadata);
      for (int i = 0; i < match.length; i++) {
         if (!match[i]) {
            skip[i] = true;
            skipped = true;
         }
      }
   }
   if (!skipped) {
      return configurations;
   }
   List<String> result = new ArrayList<>(candidates.length);
   for (int i = 0; i < candidates.length; i++) {
      if (!skip[i]) {
         result.add(candidates[i]);
      }
   }
   if (logger.isTraceEnabled()) {
      int numberFiltered = configurations.size() - result.size();
      logger.trace("Filtered " + numberFiltered + " auto configuration class in "
            + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)
            + " ms");
   }
   return new ArrayList<>(result);
}
```

作用是过滤`META-INF/spring.factories` 资源中那些当前`ClassLoader`不存在Class

### Spring Boot 自动装配命名潜规则

xxxxAutoConfiguration

### Spring Boot 条件自动装配

#### 理解`@ConditionalOnClass` 