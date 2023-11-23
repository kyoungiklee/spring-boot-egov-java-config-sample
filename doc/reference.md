
#### Spring Boot와 H2 연동하기
https://velog.io/@maigumi/Spring-Boot%EC%99%80-H2-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0

### [IntelliJ IDEA] H2 Database를 Data Source로 추가하기(메모리, 파일) + ER Diagram 보기

https://jaime-note.tistory.com/94

### H2 DB 생성하는 방법(오류가 발생하고 있음)

```shell
>java -cp h2-2.2.224.jar org.h2.tools.Shell
Welcome to H2 Shell
Exit with Ctrl+C
[Enter]   jdbc:h2:mem:2
URL       jdbc:h2:./path/to/database
[Enter]   org.h2.Driver
Driver
[Enter]   sa
User      your_username
Password  (hidden)
Type the same password again to confirm database creation.
Password  (hidden)
Connected

sql> quit
Connection closed
```


### (SpringBoot 예외처리) Exception 전략
적합한 Exception 처리의 중요성
스프링은 예외처리를 위해 다양하고 막강한 어노테이션을 제공하고 있습니다. 일관성 있는 코드 스타일을 유지하면서 Exception을 처리하는 방법에 대해서 소개하겠습니다

https://freedeveloper.tistory.com/233

* Exception 전략
* Exception Guide

https://cheese10yun.github.io/spring-guide-exception/

* Spring Guide GitHub

https://github.com/cheese10yun/spring-guide

* Spring Validator

http://wonwoo.ml/index.php/post/1082

* @ControllerAdvice 설정 참조

https://lankydan.dev/2017/09/12/global-exception-handling-with-controlleradvice

* @Order 어노테이션으로 실행 순서 조정

https://javafactory.tistory.com/1516

* @Order 어노테이션에 대하여
* 
https://www.baeldung.com/spring-order


