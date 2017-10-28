import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Motorsportevent} from "./motorsportevent";
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

  observableMotorsportEvents: Observable<Motorsportevent[]>;
  motorsportEvents: Motorsportevent[];
  errorMessage: String;

  ngOnInit() {
    this.observableMotorsportEvents = this.motorSportEventService.getEventsWithObservable();
    this.observableMotorsportEvents.subscribe(
      responses => this.motorsportEvents = responses,
      error => this.errorMessage = <any>error
    );
  }

}