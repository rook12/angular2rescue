//Doesn't seem to be strictly necessary but it seems to help the intelli sense so it knows what the json should look like

export class Motorsportevent {
  name: string;
  unitsRequired: number;
  crewRequired: number;
  startDate: Date;
  endDate: Date;

  constructor() {
  }
}
