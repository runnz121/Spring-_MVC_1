# Spring-_MVC_1
 
 ### 기본 출력 정보
 
   project-> servlet -> basic -> request 에

  * requestHeaderServlet : 헤더파일 정보 출력확인
  * requestparamservelet : 파라미터 정보 출력 확인


#### application.properties

* logging.level.org.apache.coyote.http11=debug
입력시 디버깅 

### main -> web -> frontcontroller -> v1
가장 기본적인 frontcontroller 사용

### main -> web -> frontcontroller -> v2
myview 클래스를 따로 빼서 해당 클래스를 통해 view만 랜더링(반환)

### main -> web -> frontcontroller -> v3
httlservletrequest없이 모델 만든 후 view까지 전달

### main -> web -> frontcontroller -> v4
논리뷰만 전달하여 뷰 리졸버에서 물리뷰 반환

### main -> web -> frontcontroller -> v5
어댑터 컨트롤러를 추가하여 v3와 v4컨트롤러를 선택해서 받을 수 있음
