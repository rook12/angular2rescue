curl -d "name=event1&startDate=281017&endDate=281017&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event2&startDate=291017&endDate=291017&crewRequired=6&unitsRequired=2" -X POST http://localhost:8080/api/event/add
curl -d "name=event3&startDate=011117&endDate=041117&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event4&startDate=041117&endDate=071117&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event5&startDate=061117&endDate=061117&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event6&startDate=251117&endDate=251117&crewRequired=9&unitsRequired=3" -X POST http://localhost:8080/api/event/add
curl -d "name=event7&startDate=021217&endDate=031217&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event8&startDate=041217&endDate=071217&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event9&startDate=040117&endDate=050117&crewRequired=3&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl -d "name=event10&startDate=230117&endDate=250117&crewRequired=2&unitsRequired=1" -X POST http://localhost:8080/api/event/add
curl http://localhost:8080/api/event/count