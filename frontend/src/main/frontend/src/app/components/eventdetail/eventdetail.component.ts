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
  ngOnInit(): void {
    //throw new Error("Method not implemented.");
  }

  motorsportEvent: Promise<MotorsportEvent>;
  eventId: string;

  constructor(private motorSportEventService: MotorsporteventService, private route: ActivatedRoute) {
    this.route
      .params
      .subscribe(params => {
        this.eventId = params['id']
      });

      this.motorsportEvent = this.motorSportEventService.getEventById(this.eventId)
        .then((res: Response) => res.json());

      /*
      this.motorsportEvent = new Promise(((resolve, reject) => {
        setTimeout(()=> resolve("COMPLETE!"), 3000);
      }))*/

      /*.then((res: Response) =>
        res.json());*/
  }

}
