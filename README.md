<h1>프로젝트 목표</h1>
<li>1. Spring Boot기반으로 CRUD 기능이 포함된 REST API를 구현 할 수 있다.</li>
<li>2. 3 Layer Architecture에 따라 각 Layer의 목적에 맞게 개발</li>
<li>3. JPA를 활용하여 데이터베이스를 관리하고 영속성에 대해서 이해</li>
<li>4. 회원가입, 로그인을 통해 인증/인가를 이해하고 JWT를 활용</li>
<li>5. RestTemplate을 통해 외부 정보를 호출하고 활용</li>

<h3>프로젝트 소감</h3>
Entity의 연관관계를 연결하는 것이 처음이라 생각보다 쉽지 않았다.
CRUD를 구현하고 3 Layer Architecture에 맞춰 개발을 하는게 되게 정형화 되어 있는 느낌을 받았다.
다른 프로젝트에서도 비슷하게 진행을 하면 될 것 같다.


<h4>API 설계</h4>

![image](https://github.com/user-attachments/assets/74851f35-3000-47bc-8050-e6421871a498)

![image](https://github.com/user-attachments/assets/23df5382-e54d-4339-bacc-a0658a0765af)

![image](https://github.com/user-attachments/assets/35de66a0-a28f-4352-b74f-75bf53d11ca7)


<h4>ERD 설계</h4>

![image](https://github.com/user-attachments/assets/1d817a39-f117-47f3-a21c-9eb6c0bf4ffa)

모든 Entity에 생성, 수정의 시간이 필요하기에 Timestamped라는 interface를 만들었다.

Schedule과 Comment는 양방향 관계
User는 Schedule과 Comment과 연관 관계이다.
User와 Schedule은 ManyToMany관계이기에 중간 테이블을 생성해서 ManyToOne으로 가는 방향을 정했다.
