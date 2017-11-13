call curl -d "name=event231231&startDate=28102017&endDate=28102017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
call curl -d "name=event2&startDate=29102017&endDate=29102017&crewRequired=6&unitsRequired=2" -X POST http://localhost:8080/api/event/add
call curl -d "name=event3&startDate=01112017&endDate=04112017&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
call curl -d "name=event4&startDate=04112017&endDate=07112017&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
call curl -d "name=event5&startDate=06112017&endDate=06112017&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
call curl -d "name=event6&startDate=25112017&endDate=25112017&crewRequired=9&unitsRequired=3" -X POST http://localhost:8080/api/event/add
call curl -d "name=event7&startDate=02122017&endDate=03122017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
call curl -d "name=event8&startDate=04122017&endDate=07122017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
call curl -d "name=event9&startDate=04012017&endDate=05012017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
call curl -d "name=event10&startDate=23012017&endDate=25012017&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
call curl -d "firstName=Joe&lastName=May&phoneNumber=04544454775&licenseNumber=633578" -X POST http://localhost:8080/api/crew/add
call curl -d "firstName=Kev&lastName=Bloggs&phoneNumber=01226775996&licenseNumber=126558" -X POST http://localhost:8080/api/crew/add
call curl -d "firstName=Ross&lastName=Logan&phoneNumber=07922256831&licenseNumber=11458" -X POST http://localhost:8080/api/crew/add
call curl -d "firstName=Iain&lastName=Smith&phoneNumber=07933356987&licenseNumber=335689" -X POST http://localhost:8080/api/crew/add
call curl -d "firstName=Stewart&lastName=Burns&phoneNumber=07633598855&licenseNumber=11257" -X POST http://localhost:8080/api/crew/add
curl -d "crewMemberId=1" -X POST http://localhost:8080/api/event/1/crew/add
curl -d "crewMemberId=2" -X POST http://localhost:8080/api/event/1/crew/add
curl -d "crewMemberId=3" -X POST http://localhost:8080/api/event/1/crew/add
curl -d "crewMemberId=4" -X POST http://localhost:8080/api/event/1/crew/add
curl -d "crewMemberId=4" -X POST http://localhost:8080/api/event/2/crew/add
curl -d "crewMemberId=1" -X POST http://localhost:8080/api/event/2/crew/add
curl -d "crewMemberId=4" -X POST http://localhost:8080/api/event/3/crew/add
curl -d "crewMemberId=5" -X POST http://localhost:8080/api/event/3/crew/add
REM Update event name
REM curl -d "{\"id\":\"1\", \"name\":\"event1\"}" -H "Content-Type: application/json" -X PUT http://localhost:8080/api/event/1
exit 0
