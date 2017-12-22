import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
//import {MotorsportEvent} from "./motorsportevent";
import {MotorsporteventService} from "../../services/motorsportevent/motorsportevent.service";

/*Example for subscribing to new events being added
https://www.concretepage.com/angular-2/angular-2-http-get-example*/

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  constructor(private motorSportEventService: MotorsporteventService) { }

  observableMotorsportEvents: Observable<MotorsportEvent[]>;
  motorsportEvents: MotorsportEvent[];
  errorMessage: String;

  ngOnInit() {
    this.observableMotorsportEvents = this.motorSportEventService.getEventsWithObservable();
    this.observableMotorsportEvents.subscribe(
      responses => this.motorsportEvents = responses,
      error => this.errorMessage = <any>error
    );
  }

}

//Doesn't seem to be strictly necessary but it seems to help the intelli sense so it knows what the json should look like

export class MotorsportEvent {
  id: number;
  name: string;
  unitsRequired: number;
  crewRequired: number;
  startDate: Date;
  endDate: Date;
  links: Object[];
  motorsportEventId: number;

  constructor() {
  }

  deserialise(input) : MotorsportEvent {
    this.id = input.id;
    this.name = input.name;
    this.unitsRequired = input.unitsRequired;
    this.crewRequired = input.crewRequired;
    this.startDate = new Date(input.startDate);
    this.endDate = new Date(input.endDate);
    return this;
  }

  /*build(jsonResponse:object) {
    jsonResponse.id
  }*/

  /*setName(name: string) {
    this.name = name;
  }*/
}
