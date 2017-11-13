import { Component, OnInit } from '@angular/core';
import {MotorsportEvent} from "../events/events.component";

@Component({
  selector: 'app-eventedit',
  templateUrl: './eventedit.component.html',
  styleUrls: ['./eventedit.component.css']
})
export class EventeditComponent implements OnInit {

  constructor() { }

  submitted = false;

  //model = new MotorsportEvent();

  onSubmit() {this.submitted = true; }

  //get diagnostic() { return JSON.stringify(this.model)}


  ngOnInit() {
  }

}
