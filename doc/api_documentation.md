### OpenAPI Specification을 이용한 더욱 효과적인 API 문서화
https://tech.kakaopay.com/post/openapi-documentation/

최근 새로운 Spring 기반 서버 프로젝트를 구축하게 되면서 API 문서화 개발을 진행하게 됐습니다. Spring 기반의 프로젝트에서는 Swagger와 Spring REST Docs를 가장 많이 사용하는데요. 각각 장단점이 있어 팀의 선호에 따라 하나를 선택하는 경우가 많습니다.


### API 문서화 도구
#### Swagger
Swagger는 Controller에 몇 가지의 어노테이션을 달기만 해도 API 문서가 만들어지는 편리함이 있지만
Test를 강제하지는 않기에 문서의 신뢰도를 높게 유지하기 어려운 문제가 있습니다.
그럼에도 문서가 워낙 아름답고 API Test도 지원하기 때문에 많이 사용되고 있습니다.

#### Spring REST Docs
Spring REST Docs는 Integration 테스트를 작성해서 통과해야만 문서가 작성되므로 문서의 신뢰도가 높게 유지된다는 장점이 있습니다.
Swagger와 다르게 소스코드에 변경을 주지 않아 비즈니스 로직과 테스트케이스를 분리하는 장점이 있고 테스트를 강제하므로 유지보수에도 도움을 줍니다. 반면 문서가 Swagger에 비해 아름답지 않고 API Test를 지원하지 않는 단점이 있습니다.

#### OpenApi Specification(OAS) 기반 API 문서화

Swagger 팀이 SmartBear Software에 합류하면서 Swagger Spec.이 OpenApi Spec.으로 명칭이 바뀌었고 오늘날에는 RESTful API 스펙에 대한 사실상의 표준으로서 활용되고 있다고 합니다. Swagger-UI는 이 OAS를 해석하여 API 스펙을 시각화해줍니다. 또한 Postman,
Paw 같은 API Client들도 OAS를 지원하고 있어 OAS의 활용도가 다양한 것을 알 수 있습니다.

### 결론
본 포스팅에서는 자주 비교되곤 하는 Spring REST Docs와 Swagger의 장점만을 뽑아낸 API 문서화 구축 방법을 공유드렸습니다.
빌드 시 생성되는 OAS 파일은 Postman, Paw, Insomnia 같은 API Client에서 Import하여 사용할 수 있으므로 API Client를 구성하는 수고를 줄일 수도 있습니다. :) 실무에 도입한지는 1년이 넘었는데 그동안 테스트케이스 작성을 강제하여 API 품질을 항상 높게 유지할 수 있었고
Swagger의 아름다운 UI도 제공하여 다른 조직과의 협업도 우수히 진행할 수 있었습니다.