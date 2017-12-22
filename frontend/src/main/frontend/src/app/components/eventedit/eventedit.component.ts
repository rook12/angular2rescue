// https://angular.io/guide/forms


import { Component, OnInit } from '@angular/core';
import {MotorsportEvent} from "../events/events.component";
import {ActivatedRoute, Router} from "@angular/router";
import {MotorsporteventService} from "../../services/motorsportevent/motorsportevent.service";
import {Response} from "@angular/http";

@Component({
  selector: 'app-eventedit',

  templateUrl: './eventedit.component.html',
  styleUrls: ['./eventedit.component.css']
})
export class EventeditComponent implements OnInit {

  rescueUnits = ['Rescue11test', 'Rescue12test', 'Rescue14test']

  submitted = false;

  dateValue:Date = new Date(1485562200000);

  isDataAvailable:boolean = false;

  motorsportEvent:MotorsportEvent = null;
  eventId: string;


  onSubmit() {
    this.submitted = true;

    this.motorSportEventService.updateEvent(this.eventId, this.motorsportEvent)
      .then(value => {
        console.log(">>>>>>>>>>>>Submitted! - " + value.json().message);
        this.router.navigate(["/event-detail/" + this.eventId]);
      })

      .catch(reason => {console.error(reason)})


  }

  constructor(private motorSportEventService: MotorsporteventService, private route: ActivatedRoute, private router: Router) {
    this.router = router;
    this.route
      .params
      .subscribe(params => {
        this.eventId = params['id']
      });

  }


  ngOnInit(): void {
    this.motorSportEventService.getEventById(this.eventId)
      .then((res: Response) => {
          this.motorsportEvent = new MotorsportEvent().deserialise(res.json());
          this.isDataAvailable = true;
        }
      );
  }

}
