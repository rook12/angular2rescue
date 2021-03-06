import { Component, OnInit } from '@angular/core';
import {MotorsporteventService} from "../../services/motorsportevent/motorsportevent.service";
import {MotorsportEvent} from "../events/events.component";
import {Observable} from "rxjs/Observable";
import {ActivatedRoute} from "@angular/router";
import {DataGridModule} from 'primeng/primeng';
import {Response} from "@angular/http";
import {reject} from "q";

@Component({
  selector: 'app-eventdetail',
  templateUrl: './eventdetail.component.html',
  styleUrls: ['./eventdetail.component.css']
})
export class EventdetailComponent implements OnInit {

  public editRouterLink = "/event-edit";

  ngOnInit(): void {
    this.motorsportEvent = this.motorSportEventService.getEventById(this.eventId)
      .then((res: Response) => res.json());
  }

  motorsportEvent: Promise<MotorsportEvent>;
  eventId: string;

  constructor(private motorSportEventService: MotorsporteventService, private route: ActivatedRoute) {
    this.route
      .params
      .subscribe(params => {
        this.eventId = params['id']
      });

  }

}
