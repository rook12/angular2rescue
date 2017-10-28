import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Motorsportevent} from "../../components/events/motorsportevent";
import 'rxjs/add/operator/map';

@Injectable()
export class MotorsporteventService {

  constructor(private http:Http) {}

  getEventsWithObservable(): Observable<Motorsportevent[]> {
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
