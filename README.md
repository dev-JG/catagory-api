# Backend Engineer - 과제
***

### 설계
서버
- Spring Boot 2.7.18
- JPA, queryDsl 5.0.0
- H2
- mapstruct, lombok
- thymeleaf, bootstrap

DB
- category 카테고리 정보 테이블
- brand 브랜드 정보 테이블
- goods 상품 정보 테이블
- category_min_goods 카테고리별 최저가 상품 정보를 담는 테이블

***

### 코드 빌드, 테스트, 실행 방법
- 코드 빌드: gradle build
- 테스트: gradle test
- 실행 방법: java -jar categoryApi-0.0.1-SNAPSHOT.jar
- 
***

### 구현 범위
1. 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
- GET, /api/v1/categories/price/goods/min
- http://localhost:8080/api/v1/categories/price/goods/min

1-1. 프론트페이지
- http://localhost:8080/category/brand/minPrice
- /api/v1/categories/price/goods/min를 호출하여, 화면에 표시하는 간단한 기능의 페이지
![initial](https://user-images.githubusercontent.com/60951370/283982893-e260ec2b-5ad5-417a-9628-dd05d881a165.png)

2. 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
- GET, /api/v1/categories/price/brand/min
- http://localhost:8080/api/v1/categories/price/brand/min

3. 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
- GET, /api/v1/categories/price/goods/max-min
- http://localhost:8080/api/v1/categories/price/goods/max-min?categoryName=상의

4. 브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API
- 브랜드 추가 POST, /api/v1/brand
- 브랜드 수정 PUT, /api/v1/brand/{brandNo}
- 브랜드 삭제 DELETE, /api/v1/goods/{brandNo}
- 상품 추가 POST, /api/v1/goods
- 상품 수정 PUT, /api/v1/goods/{goodsNo}
- 상품 삭제 DELETE, /api/v1/goods/{goodsNo}

***

### 추가 개선방향
- 카테고리별 최저가 브랜드의 상품 가격, 총액을 제공하는 API는 현재 스케쥴러 / updateCategoryMinGoodsData() 를 통해 5분마다 category_min_goods 테이블에 매핑정보를 갱신하고 있습니다. 
이 부분은 스케쥴러 형태가 아닌 별도의 배치로 분리하고, RDB가 아닌 문서형 NoSql에 상품정보를 저장, 제공하는 형태로 구조를 개선할 수 있습니다.

- 최저가, 최고가의 상품을 구하는 경우, 동일한 가격의 상품이 복수개 일 때 어느 것을 우선적으로 노출 시킬지에 대한 정책이 정해져 있지 않습니다.
실제 서비스를 할 때는 이 부분의 정책이 정해지고, API기능에 추가가 되어야 합니다.
현재는 같은 브랜드, 같은 카테고리일 때, 상품은 1개라는 가정하에 구현하였습니다.