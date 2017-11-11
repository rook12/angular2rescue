curl -d "name=event1&startDate=28102017&endDate=28102017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event2&startDate=29102017&endDate=29102017&crewRequired=6&unitsRequired=2" -X POST http://localhost:8080/api/event/add
curl -d "name=event3&startDate=01112017&endDate=04112017&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event4&startDate=04112017&endDate=07112017&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event5&startDate=06112017&endDate=06112017&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event6&startDate=25112017&endDate=25112017&crewRequired=9&unitsRequired=3" -X POST http://localhost:8080/api/event/add
curl -d "name=event7&startDate=02122017&endDate=03122017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event8&startDate=04122017&endDate=07122017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event9&startDate=04012017&endDate=05012017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event10&startDate=23012017&endDate=25012017&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl http://localhost:8080/api/event/count