// https://angular.io/guide/forms


import { Component, OnInit } from '@angular/core';
import {MotorsportEvent} from "../events/events.component";
import {ActivatedRoute, Router} from "@angular/router";
import {MotorsporteventService} from "../../services/motorsportevent/motorsportevent.service";
import {Response} from "@angular/http";
import {ICrew} from "../../interfaces/crew";
import {CrewService} from "../../services/crew/crew.service";

@Component({
  selector: 'app-eventedit',

  templateUrl: './eventedit.component.html',
  styleUrls: ['./eventedit.component.css']
})
export class EventeditComponent implements OnInit {

  rescueUnits = ['Rescue11test', 'Rescue12test', 'Rescue14test']

  submitted = false;

  isDataAvailable:boolean = false;

  motorsportEvent:MotorsportEvent = null;
  eventId: string;

  crew: ICrew[] = [];
  selectedCrew: ICrew[] = [];

  onSubmit() {
    this.submitted = true;

    this.motorSportEventService.updateEvent(this.eventId, this.motorsportEvent)
      .then(value => {
        console.log(">>>>>>>>>>>>Submitted! - " + value.json().message);
        this.router.navigate(["/event-detail/" + this.eventId]);
      })

      .catch(reason => {console.error(reason)})


  }

  constructor(private motorSportEventService: MotorsporteventService, private crewService: CrewService, private route: ActivatedRoute, private router: Router) {
    this.router = router;
    this.route
      .params
      .subscribe(params => {
        this.eventId = params['id']
      });

    //this.crew = [{name:'joe',id:1}, {name:'bob',id:2}];

  }


  ngOnInit(): void {
    var p1 = this.motorSportEventService.getEventById(this.eventId)
      .then((res: Response) => {
          this.motorsportEvent = new MotorsportEvent().deserialise(res.json());

          for(var i in this.motorsportEvent.crew) {
            this.selectedCrew.push(this.motorsportEvent.crew[i]);
          }

        }
      );

    var p2 = this.crewService.getCrewMembers()
      .then((res: Response) => {
        var resArray = res.json();
        for(var i in resArray) {
          this.crew.push({name:resArray[i].firstName + ' ' + resArray[i].lastName, id: resArray[i].crewMemberId})
        }
      });

    Promise.all([p1, p2])
      .then(value => {
        console.log("all promises returned");
        this.isDataAvailable = true;
      });


    /*console.log("p1 - " + p1);*/

  }

}
