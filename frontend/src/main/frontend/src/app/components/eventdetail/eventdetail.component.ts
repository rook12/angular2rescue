import { Component, OnInit } from '@angular/core';
import {MotorsporteventService} from "../../services/motorsportevent/motorsportevent.service";
import {MotorsportEvent} from "../events/events.component";
import {Observable} from "rxjs/Observable";
import {ActivatedRoute} from "@angular/router";
import {DataGridModule} from 'primeng/primeng';

@Component({
  selector: 'app-eventdetail',
  templateUrl: './eventdetail.component.html',
  styleUrls: ['./eventdetail.component.css']
})
export class EventdetailComponent implements OnInit {

  constructor(private motorSportEventService: MotorsporteventService, private route: ActivatedRoute) {
    this.route
      .params
      .subscribe(params => {
        this.eventId = params['id']
      });

  }

  errorMessage: String;
  observableMotorsportEvent: Observable<Object>;
  motorsportEvent: Object;

  eventId: string;

  ngOnInit() {
    this.observableMotorsportEvent = this.motorSportEventService.getEventById(this.eventId);
    this.observableMotorsportEvent.subscribe(
      resp => this.motorsportEvent = resp,
      error => this.errorMessage = <any>error
    )

  }

}
