# STOMP + RabbitMQ
> Spring Boot 기반의 채팅프로그램

## 사용 기술
<img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white"></br>
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"></br>
<img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"></br>
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=Java&logoColor=white"></br>
<img src="https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=Java&logoColor=white"></br>
<img src="https://img.shields.io/badge/Lombok-AC3922?style=for-the-badge&logo=Java&logoColor=white"></br>
<img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">

## 개발 환경 설정

<img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white"></br>
<img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white"></br>
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=Java&logoColor=white"></br>
<img src="https://img.shields.io/badge/H2 Database-0F20F7?style=for-the-badge&logo=Java&logoColor=white"></br>

## 정보
개인적인 학습용도로 사용하는 Repository입니다.

## 실행 가이드
rabbitmq-server-3.12.3<br>
dependency : otp_win64_25.1
```
cd C:\Program Files\RabbitMQ Server\rabbitmq_server-3.12.3\sbin
rabbitmq-plugins enable rabbitmq_management
rabbitmq-server

1. 제대로 시작이 안될시 관리자 권한으로 터미널 실행
2. 같은 이름의 노드가 실행중일 수 있음 중지 후 재시작할것
rabbitmq-service.bat stop
```