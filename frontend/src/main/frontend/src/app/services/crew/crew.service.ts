import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class CrewService {

  constructor(private http:Http) {}

  getCrewMembers() {
    return this.http.get("/api/crew/list").toPromise();
  }

}
