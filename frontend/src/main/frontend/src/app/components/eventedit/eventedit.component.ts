// https://angular.io/guide/forms


import { Component, OnInit } from '@angular/core';
import {MotorsportEvent} from "../events/events.component";
import {ActivatedRoute} from "@angular/router";
import {MotorsporteventService} from "../../services/motorsportevent/motorsportevent.service";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-eventedit',
  templateUrl: './eventedit.component.html',
  styleUrls: ['./eventedit.component.css']
})
export class EventeditComponent implements OnInit {



  rescueUnits = ['Rescue11test', 'Rescue12test', 'Rescue14test']

  submitted = false;

  errorMessage: String;
  observableMotorsportEvent: Observable<Object>;
  motorsportEvent: Object;

  eventId: string;


  onSubmit() {this.submitted = true; }

  //get diagnostic() { return JSON.stringify(this.motorsportEvent)}

  /*constructor() {
    this.motorsportEvent.name = 'aaaaa';
    this.motorsportEvent.crewRequired = 4;
    this.motorsportEvent.unitsRequired = 2;

  }*/

  constructor(private motorSportEventService: MotorsporteventService, private route: ActivatedRoute) {
    this.route
      .params
      .subscribe(params => {
        this.eventId = params['id']
      });

  }


  ngOnInit() {
    this.observableMotorsportEvent = this.motorSportEventService.getEventById(this.eventId);
    this.observableMotorsportEvent.subscribe(
      resp => this.motorsportEvent = resp,
      error => this.errorMessage = <any>error
    )
  }

}
