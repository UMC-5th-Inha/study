### Malz
## Add mission to Member's Mission

- 미션 상태를 정수로 표현하니 헷갈려서 enum 클래스를 만들었습니다.
  - in_progress : 진행 중
  - complete : 성공
  - fail : 실패
- [x] DTO
- [x] Converter
- [x] Controller
- [x] Service
- [x] Repository

memberMission 이 아무래도 member 와 mission 의 매핑 엔티티다보니

memberMissionCommandServiceImpl 이 memberRepository와 missionRepoistory에 의존성을 가질 수 밖에 없었습니다.
