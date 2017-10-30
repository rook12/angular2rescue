import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map';
import {MotorsportEvent} from "../../components/events/events.component";

@Injectable()
export class MotorsporteventService {


  constructor(private http:Http) {}

  getEventsWithObservable(): Observable<MotorsportEvent[]> {
    return this.http.get("/api/event/list" )
      .map(this.extractData);
  }

  private extractData(res: Response ) {
    let body = res.json();
    return body;
  }

  private handleErrorObservable (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

}
