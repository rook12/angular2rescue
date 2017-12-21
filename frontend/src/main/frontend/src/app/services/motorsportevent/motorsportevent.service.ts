import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {MotorsportEvent} from "../../components/events/events.component";

@Injectable()
export class MotorsporteventService {


  constructor(private http:Http) {}

  getEventById(eventId: string): Promise<Response> {
    return this.http.get("/api/event/" + eventId).toPromise();
  }

  updateEvent(eventId: string, motorsportEvent: Object): Promise<Response> {
    console.log("1................")
    console.log("2................")
    let url = "/api/event/" + eventId
    console.log("url - " + url)

    return this.http.put(url, motorsportEvent).toPromise();

  }

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
